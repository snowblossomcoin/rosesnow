package org.snowblossom.rosesnow;

import duckutil.ConfigMem;
import io.swagger.model.*;
import io.swagger.model.NetworkIdentifier;
import java.util.TreeMap;
import snowblossom.lib.AddressSpecHash;
import snowblossom.lib.ChainHash;
import snowblossom.lib.NetworkParams;
import snowblossom.lib.TransactionUtil;
import snowblossom.node.SnowBlossomNode;
import snowblossom.proto.TransactionInner;
import snowblossom.proto.TransactionInput;
import snowblossom.proto.TransactionOutput;
import snowblossom.lib.HexUtil;
import snowblossom.lib.AddressUtil;
import snowblossom.lib.SignatureUtil;
import snowblossom.proto.AddressSpec;
import snowblossom.proto.SigSpec;
import snowblossom.lib.ValidationException;
import com.google.protobuf.ByteString;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import org.junit.Assert;

public class RoseUtil
{

  /**
   * Node can be null
   */
  public static Transaction protoToModel( snowblossom.proto.Transaction s_tx, SnowBlossomNode node, NetworkParams params)
  {
    Transaction tx = new Transaction();
    ChainHash tx_id = new ChainHash(s_tx.getTxHash());

    tx.setTransactionIdentifier( new TransactionIdentifier().hash( tx_id.toString() ));

    TransactionInner inner = TransactionUtil.getInner(s_tx);

    long tx_idx = 0;
    for(TransactionInput tx_in : inner.getInputsList())
    {
      Operation o = new Operation();
      o.setOperationIdentifier( new OperationIdentifier().index(tx_idx) );
      o.setType("INPUT");
      o.setStatus("OK");

      AddressSpecHash spec_hash = new AddressSpecHash(tx_in.getSpecHash());
      ChainHash src_tx_id = new ChainHash(tx_in.getSrcTxId());
      int src_idx = tx_in.getSrcTxOutIdx();

      o.setAccount( new AccountIdentifier().address( spec_hash.toAddressString(params) ));

      long value = tx_in.getValue();

			if ((value == 0L) && (node != null))
			{
        snowblossom.proto.Transaction src_tx = node.getDB().getTransactionMap().get(src_tx_id.getBytes());
        if (src_tx == null)
        {
          src_tx = node.getMemPool().getTransaction(src_tx_id);
        }
        TransactionInner src_tx_inner = TransactionUtil.getInner(src_tx);

      	value = src_tx_inner.getOutputs(src_idx).getValue();
      }

      o.setAmount( getSnowAmount(-value, params) );

      o.setCoinChange(  
        new CoinChange()
          .coinAction(CoinAction.SPENT)
          .coinIdentifier(new CoinIdentifier().identifier(src_tx_id.toString()+":" + src_idx))
        );

      tx.getOperations().add(o);
      tx_idx++;
    }

    int out_idx=0;
    for(TransactionOutput tx_out : inner.getOutputsList())
    {
      Operation o = new Operation();
      o.setOperationIdentifier( new OperationIdentifier().index(tx_idx) );
      o.setType("OUTPUT");
      o.setStatus("OK");

      long value = tx_out.getValue();
      AddressSpecHash spec_hash = new AddressSpecHash( tx_out.getRecipientSpecHash() );
      o.setAmount( getSnowAmount(value, params) );
      o.setAccount( new AccountIdentifier().address( spec_hash.toAddressString(params) ));

      o.setCoinChange(  
        new CoinChange()
          .coinAction(CoinAction.CREATED)
          .coinIdentifier(new CoinIdentifier().identifier(tx_id.toString()+":" + out_idx))
        );


      tx.getOperations().add(o);
      tx_idx++;
      out_idx++;
    }



    return tx;
  }
  public static Amount getSnowAmount(long value, NetworkParams params)
  {
    Currency c = new Currency().symbol(params.getAddressPrefix().toUpperCase()).decimals(6);
    return new Amount().value("" + value).currency(c);
  }

  public static NetworkParams getParams(NetworkIdentifier id)
  {
    TreeMap<String, String> cm = new TreeMap<>();
    cm.put("network", id.getNetwork());
    ConfigMem config = new ConfigMem(cm);
    return NetworkParams.loadFromConfig(config);

  }

  public static AddressSpec getSpecForPublicKey(PublicKey pk)
    throws ValidationException
  {
    if (!CurveType.SECP256K1.equals(pk.getCurveType()))
    {
      throw new ValidationException("Unexpected curve type: " + pk.getCurveType());
    }
    String hex_str = pk.getHexBytes();

    ByteString hex = HexUtil.hexStringToBytes(hex_str);

    return AddressUtil.getSimpleSpecForKey(hex, SignatureUtil.SIG_TYPE_ECDSA_COMPRESSED);
  }

  public static AddressSpecHash getSpecHashForPublicKey(PublicKey pk)
    throws ValidationException
  {
    return AddressUtil.getHashForSpec(getSpecForPublicKey(pk));
  }

  public static ByteString checkSignature(Signature sig, ByteString tx_hash)
    throws ValidationException
  {
    AddressSpec spec = getSpecForPublicKey(sig.getPublicKey());
    SigSpec sig_spec = spec.getSigSpecs(0);

    ByteString smash_sig = convertSig( HexUtil.hexStringToBytes( sig.getHexBytes() ) );
    //ByteString data = HexUtil.hexStringToBytes(sig.getSigningPayload().getHexBytes());

    if(!SignatureUtil.checkSignature(sig_spec, tx_hash, smash_sig))
    {
      throw new ValidationException("Signature check failed");
    }
    return smash_sig;

  }

  public static ByteString hashSha256(ByteString in)
  {
    try
    {
      java.security.MessageDigest md = java.security.MessageDigest.getInstance("SHA-256");
      return ByteString.copyFrom(md.digest(in.toByteArray()));

    }
    catch(Exception e){throw new RuntimeException(e);}
  }
  public static ByteString hashSha1(ByteString in)
  {
    try
    {
      java.security.MessageDigest md = java.security.MessageDigest.getInstance("SHA-1");
      return ByteString.copyFrom(md.digest(in.toByteArray()));

    }
    catch(Exception e){throw new RuntimeException(e);}
  }


  /** 
   * Converts signature from raw R|S style (64 bytes) to DER encoded (72 to 70 bytes or so)
   */
  public static ByteString convertSig(ByteString raw_sig)
  {
    ByteString r = raw_sig.substring(0,32);
    ByteString s = raw_sig.substring(32);

    r = convertBigInteger(r);
    s = convertBigInteger(s);

    byte[] b = new byte[1];
    ByteString der_sig = ByteString.EMPTY;
    b[0]=0x30; der_sig = der_sig.concat(ByteString.copyFrom(b));
    int len = r.size() + s.size() + 4;
    b[0]=(byte)len; der_sig = der_sig.concat(ByteString.copyFrom(b));

    b[0]=0x02; der_sig = der_sig.concat(ByteString.copyFrom(b));
    b[0]=(byte)r.size(); der_sig = der_sig.concat(ByteString.copyFrom(b));
    der_sig = der_sig.concat(r);

    b[0]=0x02; der_sig = der_sig.concat(ByteString.copyFrom(b));
    b[0]=(byte)s.size(); der_sig = der_sig.concat(ByteString.copyFrom(b));
    der_sig = der_sig.concat(s);

    return der_sig;
  }

  
  /** 
   * Only used by tests
   */
  public static ByteString convertSigDerToRaw(ByteString der)
  {
    ByteBuffer buff = ByteBuffer.wrap( der.toByteArray() );

    Assert.assertEquals(0x30, buff.get()); // 0x30
    buff.get(); // total len
    Assert.assertEquals(0x02, buff.get()); // 0x02
    int len = buff.get();
    System.out.println("Length: " + len);
    byte[] r_b = new byte[len];
    buff.get(r_b);

    Assert.assertEquals(0x02, buff.get()); // 0x02
    len = buff.get();
    byte[] s_b = new byte[len];
    buff.get(s_b);

    Assert.assertEquals(0, buff.remaining());

    return convertBigIntegerToFixed( ByteString.copyFrom(r_b) )
      .concat(
        convertBigIntegerToFixed( ByteString.copyFrom(s_b) ));


  }

  /** convert fixed length integer to dynamic length integer */
  public static ByteString convertBigInteger(ByteString s)
  {
    BigInteger in = new BigInteger(1, s.toByteArray());

    return ByteString.copyFrom( in.toByteArray() );
  }

  /**
   * convert dynamic length integer to fixed length at 32 bytes
   */
  public static ByteString convertBigIntegerToFixed(ByteString dynamic)
  {
    BigInteger in = new BigInteger(1, dynamic.toByteArray());

    ByteString s = ByteString.copyFrom( in.toByteArray() );
    while (s.size() > 32)
    {
      s = s.substring(1);
    }
    while(s.size() < 32)
    {
      byte b[]=new byte[1];
      b[0] = 0;
      s = ByteString.copyFrom(b).concat(s);
    }
    return s;

  }
 
}
