
import com.google.protobuf.ByteString;
import java.util.Random;
import org.junit.Test;
import org.junit.Assert;
import org.junit.BeforeClass;
import snowblossom.lib.KeyUtil;
import snowblossom.lib.SignatureUtil;
import snowblossom.proto.WalletKeyPair;
import snowblossom.proto.AddressSpec;
import snowblossom.proto.SigSpec;
import snowblossom.lib.Globals;
import snowblossom.lib.AddressUtil;
import snowblossom.lib.HexUtil;
import org.snowblossom.rosesnow.RoseUtil;

import org.bouncycastle.asn1.DERObjectIdentifier;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.DigestInfo;

public class TestSigCoding
{

  @BeforeClass
  public static void loadProvider()
  {
    Globals.addCryptoProvider();
  }

  @Test
  public void testConvert()
    throws Exception
  {
    Random rnd = new Random();
    for(int j=0; j<20; j++)
    {
      WalletKeyPair wkp = KeyUtil.generateWalletStandardECKey();
      byte b[]=new byte[64];

      for(int i=0; i<200; i++)
      {
        rnd.nextBytes(b);

        ByteString der_sig = SignatureUtil.sign(wkp, ByteString.copyFrom(b) );

        Assert.assertTrue( der_sig.size() > 66);
        Assert.assertTrue( der_sig.size() <= 72);

        ByteString raw_sig = RoseUtil.convertSigDerToRaw(der_sig);

        ByteString back = RoseUtil.convertSig(raw_sig);

        Assert.assertEquals( HexUtil.getHexString(der_sig), HexUtil.getHexString(back) );
      }
    }

  }

  
  /**
   * Sign something with ECDSA/NONE and verify with ECDSA/SHA1
   */ 
  @Test
  public void testSigNoneSha1() throws Exception
  {
    WalletKeyPair wkp = KeyUtil.generateWalletStandardECKey();

    AddressSpec addr_spec = AddressUtil.getSimpleSpecForKey( wkp );
    SigSpec sig_spec = addr_spec.getSigSpecs(0);
    
    java.security.PrivateKey priv_key = KeyUtil.decodePrivateKey(wkp.getPrivateKey(), "ECDSA");
    java.security.PublicKey pub_key = SignatureUtil.decodePublicKey(sig_spec);

    ByteString tx_hash = null;
    {
      byte[] b = new byte[32];
      Random rnd = new Random();
      rnd.nextBytes(b);
      tx_hash = ByteString.copyFrom(b);
    }

    java.security.Signature sig_engine = java.security.Signature.getInstance("NONEwithECDSA","BC");
    sig_engine.initSign(priv_key);
    ByteString sha1_tx_hash = RoseUtil.hashSha1(tx_hash);

    /*
    DigestInfo di = new DigestInfo(new AlgorithmIdentifier(new DERObjectIdentifier("1.3.14.3.2.26")), sha1_tx_hash.toByteArray());
    byte[] plain_sig = di.getEncoded("DER");

    //sig_engine.update( plain_sig );*/
    sig_engine.update( sha1_tx_hash.toByteArray() );

    ByteString signature = ByteString.copyFrom(sig_engine.sign());

    Assert.assertTrue(SignatureUtil.checkSignature(sig_spec, tx_hash, signature));

    

  }


}
