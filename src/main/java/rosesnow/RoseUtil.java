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

public class RoseUtil
{

  public static Transaction protoToModel( snowblossom.proto.Transaction s_tx, SnowBlossomNode node)
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

      o.setAccount( new AccountIdentifier().address( spec_hash.toAddressString(node.getParams()) ));

      snowblossom.proto.Transaction src_tx = node.getDB().getTransactionMap().get(src_tx_id.getBytes());
      if (src_tx == null)
      {
        src_tx = node.getMemPool().getTransaction(src_tx_id);
      }
      TransactionInner src_tx_inner = TransactionUtil.getInner(src_tx);

      long value = src_tx_inner.getOutputs(src_idx).getValue();

      // Question, should spent amounts be negative?  Probably
      o.setAmount( getSnowAmount(-value, node.getParams()) );

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
      o.setAmount( getSnowAmount(value, node.getParams()) );
      o.setAccount( new AccountIdentifier().address( spec_hash.toAddressString(node.getParams()) ));

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

  public static void checkSignature(Signature sig)
    throws ValidationException
  {
    AddressSpec spec = getSpecForPublicKey(sig.getPublicKey());
    SigSpec sig_spec = spec.getSigSpecs(0);

    ByteString sig_data = HexUtil.hexStringToBytes( sig.getHexBytes() );
    ByteString data = HexUtil.hexStringToBytes( sig.getSigningPayload().getHexBytes() );

    // TODO - remove
    System.out.println("LORK Signature data: " + sig.getHexBytes());
    System.out.println("LORK Signed data: " + sig.getSigningPayload().getHexBytes());


    if(!SignatureUtil.checkSignature(sig_spec, data, sig_data))
    {
      throw new ValidationException("Signature check failed");
    }

  }
}
