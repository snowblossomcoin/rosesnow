
import com.google.protobuf.ByteString;
import java.util.Random;
import org.junit.Test;
import org.junit.Assert;
import org.junit.BeforeClass;
import snowblossom.lib.KeyUtil;
import snowblossom.lib.SignatureUtil;
import snowblossom.proto.WalletKeyPair;
import snowblossom.lib.Globals;
import snowblossom.lib.HexUtil;
import org.snowblossom.rosesnow.RoseUtil;

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

}
