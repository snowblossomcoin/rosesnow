package org.snowblossom.rosesnow.test;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.model.*;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import snowblossom.lib.HexUtil;
import snowblossom.lib.NetworkParams;
import snowblossom.lib.NetworkParamsTestnet;
import snowblossom.lib.KeyUtil;
import snowblossom.lib.AddressUtil;
import snowblossom.lib.Globals;
import snowblossom.lib.SignatureUtil;
import snowblossom.proto.WalletKeyPair;
import snowblossom.proto.AddressSpec;
import com.google.protobuf.ByteString;
import org.junit.Assert;
import java.util.List;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import com.google.common.collect.ImmutableList;
import org.snowblossom.rosesnow.RoseUtil;


/**
 * The purpose of this class is to verify that basic
 * keys, signing and transaction construction work
 */
public class ConstructionE2E
{
  public static final String rose_url="http://localhost:8080";
  public static final NetworkParams params = new NetworkParamsTestnet();
  public static final NetworkIdentifier net_id = new NetworkIdentifier().blockchain("snowblossom").network("testnet");
  public static final String wallet_path="keypair.dat";

  public static void main(String args[])
    throws Exception
  {
    new ConstructionE2E();
  }

  public ConstructionE2E()
    throws Exception
  {
    Globals.addCryptoProvider();

    NetworkStatusResponse status = req("/network/status", 
      new NetworkRequest().networkIdentifier(net_id),
      NetworkStatusResponse.class);


    // Generate an address
    WalletKeyPair wkp = loadOrGen();
    AddressSpec spec = AddressUtil.getSimpleSpecForKey(wkp);
    ByteString pub_key_bytes = spec.getSigSpecs(0).getPublicKey();

    PublicKey pub_key = new PublicKey()
      .hexBytes(HexUtil.getHexString(pub_key_bytes))
      .curveType(CurveType.SECP256K1);

    AccountIdentifier a_id = null;

    String gen_addr = AddressUtil.getHashForSpec(spec).toAddressString(params);

    { // Check derived address matches
      ConstructionDeriveResponse der_resp = req("/construction/derive",
        new ConstructionDeriveRequest().networkIdentifier(net_id).publicKey(pub_key),
        ConstructionDeriveResponse.class);

      String addr = der_resp.getAccountIdentifier().getAddress();

      a_id = der_resp.getAccountIdentifier();

      Assert.assertEquals(gen_addr, addr);

      System.out.println(addr + " " + gen_addr);
    }

    List<Coin> coins = null;
    { // wait for balance
      
      while(true)
      {
        System.out.println("Waiting for balance on " + gen_addr);
        AccountCoinsResponse bal = req("/account/coins", 
          new AccountCoinsRequest()
            .accountIdentifier(a_id)
            .networkIdentifier(net_id)
            .includeMempool(true),
          AccountCoinsResponse.class);

        if (bal.getCoins() != null)
        {
          if (bal.getCoins().size() > 0)
          {
            coins = bal.getCoins();
            break;
          }
        }
        Thread.sleep(10000);
      }
    }
    for(Coin c : coins)
    {
      System.out.println(c);
    }
    
    ConstructionPayloadsResponse payloads_resp = null;
    { // get payloads

      Assert.assertTrue(coins.size() > 0);
      Coin coin = coins.get(0);

      ConstructionPayloadsRequest payload_req = new ConstructionPayloadsRequest();
      payload_req.setNetworkIdentifier(net_id);
      payload_req.setPublicKeys( ImmutableList.of(pub_key) );


      System.out.println("CCC: " + coin);
      long val = Long.parseLong(coin.getAmount().getValue());

      Assert.assertTrue(val > 0L);



      payload_req.getOperations().add( new Operation()
        .type("INPUT")
        .account(a_id)
        .amount(new Amount().value("-" + coin.getAmount().getValue()).currency(coin.getAmount().getCurrency()))
        .coinChange( new CoinChange().coinIdentifier(coin.getCoinIdentifier()).coinAction(CoinAction.SPENT))
        );

      payload_req.getOperations().add( new Operation()
        .type("OUTPUT")
        .account(a_id)
        .amount(coin.getAmount())
      );

      payloads_resp = req("/construction/payloads", payload_req, ConstructionPayloadsResponse.class);

      System.out.println(payloads_resp);
    }

    String signed_tx = null;

    { // combine
      ConstructionCombineRequest combine_req = new ConstructionCombineRequest();

      combine_req.setNetworkIdentifier(net_id);
      combine_req.setUnsignedTransaction( payloads_resp.getUnsignedTransaction() );

      Signature sig = new Signature();

      SigningPayload payload = payloads_resp.getPayloads().get(0);

      sig.setPublicKey(pub_key);
      sig.setSignatureType(SignatureType.ECDSA);
      sig.setSigningPayload(payload);
     
      ByteString sign_data = HexUtil.hexStringToBytes( payload.getHexBytes() );
      
      java.security.PrivateKey priv_key = KeyUtil.decodePrivateKey(wkp.getPrivateKey(), "ECDSA");

      java.security.Signature sig_engine = java.security.Signature.getInstance("NONEwithECDSA","BC");
      sig_engine.initSign(priv_key);
      sig_engine.update( sign_data.toByteArray() );

      ByteString s = RoseUtil.convertSigDerToRaw(ByteString.copyFrom(sig_engine.sign()));

      sig.setHexBytes( HexUtil.getHexString(s));

      combine_req.getSignatures().add(sig);

      ConstructionCombineResponse resp = req("/construction/combine", combine_req, ConstructionCombineResponse.class);
      System.out.println(resp);

      signed_tx = resp.getSignedTransaction();
    }

    { // submit
      
      TransactionIdentifierResponse tx_id = req("/construction/submit", new ConstructionSubmitRequest().networkIdentifier(net_id).signedTransaction(signed_tx), TransactionIdentifierResponse.class);
      System.out.println(tx_id);
    }
    
    

  }

  public <T> T req(String path, Object o, Class<T> res)
    throws Exception
  {
    String json = runRequest(path, o);
    return new ObjectMapper().readValue(json, res);
  }

  public String runRequest(String path, Object o)
    throws Exception
  {
    URL u = new URL(rose_url + path);

    HttpURLConnection connection = (HttpURLConnection) u.openConnection();

    connection.setDoOutput(true);
    connection.setDoInput(true);
    connection.setInstanceFollowRedirects(false);
    connection.setRequestMethod("POST");
    connection.setRequestProperty("Content-Type", "application/json");

    OutputStream wr = connection.getOutputStream();
    new ObjectMapper()
      .setSerializationInclusion(Include.NON_NULL)
      .writerFor(o.getClass())
      .writeValues(wr).write(o);

    wr.flush();
    wr.close();

    Scanner scan = new Scanner(connection.getInputStream());
    StringBuilder sb = new StringBuilder();

    while(scan.hasNextLine())
    {
      String line = scan.nextLine();
      sb.append(line);
      sb.append('\n');
    }
    scan.close();
    return sb.toString();

  }

  public WalletKeyPair loadOrGen()
    throws Exception
  {
    File f = new File(wallet_path);
    if (f.exists())
    {
      return WalletKeyPair.parseFrom( new FileInputStream(f));
    }
    WalletKeyPair wkp = KeyUtil.generateWalletStandardECKey();

    FileOutputStream out = new FileOutputStream(f, false);

    out.write( wkp.toByteString().toByteArray() );
    out.flush();
    out.close();
    return wkp;
  }

}
