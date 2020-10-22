package io.swagger.controllers;

import io.swagger.oas.inflector.models.RequestContext;
import io.swagger.oas.inflector.models.ResponseContext;
import javax.ws.rs.core.Response.Status;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import snowblossom.lib.ValidationException;
import java.io.File;
import java.util.List;

import io.swagger.model.*;

import io.swagger.model.ConstructionCombineRequest;
import io.swagger.model.ConstructionCombineResponse;
import java.util.LinkedList;
import io.swagger.model.ConstructionDeriveRequest;
import io.swagger.model.ConstructionDeriveResponse;
import io.swagger.model.ConstructionHashRequest;
import io.swagger.model.ConstructionMetadataRequest;
import io.swagger.model.ConstructionMetadataResponse;
import io.swagger.model.ConstructionParseRequest;
import io.swagger.model.ConstructionParseResponse;
import io.swagger.model.ConstructionPayloadsRequest;
import io.swagger.model.ConstructionPayloadsResponse;
import io.swagger.model.ConstructionPreprocessRequest;
import io.swagger.model.ConstructionPreprocessResponse;
import io.swagger.model.ConstructionSubmitRequest;
import io.swagger.model.Error;
import io.swagger.model.TransactionIdentifierResponse;
import com.fasterxml.jackson.databind.JsonNode;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.snowblossom.rosesnow.RoseSnow;
import org.snowblossom.rosesnow.RoseUtil;
import snowblossom.lib.ChainHash;
import snowblossom.lib.Globals;
import snowblossom.node.SnowBlossomNode;
import snowblossom.proto.BlockHeader;
import snowblossom.proto.TransactionInner;
import snowblossom.proto.TransactionInput;
import snowblossom.proto.TransactionOutput;
import snowblossom.lib.NetworkParams;
import snowblossom.lib.HexUtil;
import snowblossom.lib.AddressUtil;
import snowblossom.lib.AddressSpecHash;
import snowblossom.lib.SignatureUtil;
import com.google.protobuf.ByteString;
import java.util.HashSet;
import com.google.common.collect.ImmutableList;
import snowblossom.lib.DigestUtil;
import snowblossom.proto.AddressSpec;
import snowblossom.lib.TransactionUtil;


@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaInflectorServerCodegen", date = "2020-10-18T05:48:04.106Z[GMT]")
public class Construction {

  public ResponseContext constructionCombine(RequestContext request , JsonNode body) 
    throws Exception
  {
    ConstructionCombineRequest req = new ObjectMapper().readValue(body.toString(), ConstructionCombineRequest.class);
    NetworkParams params = RoseUtil.getParams(req.getNetworkIdentifier());


    snowblossom.proto.Transaction.Builder s_tx = snowblossom.proto.Transaction.newBuilder().mergeFrom(
      snowblossom.proto.Transaction.parseFrom( HexUtil.hexStringToBytes( req.getUnsignedTransaction() ) ));

    TransactionInner inner = TransactionUtil.getInner(s_tx.build());

    for(Signature sig : req.getSignatures())
    {
      RoseUtil.checkSignature(sig);
      AddressSpec spec = RoseUtil.getSpecForPublicKey(sig.getPublicKey());

      int claim_idx = 0;
      for(AddressSpec claim_spec : inner.getClaimsList())
      {
        if (claim_spec.equals(spec)) break;
        claim_idx++;
      }
      s_tx.addSignatures( snowblossom.proto.SignatureEntry.newBuilder()
        .setClaimIdx(claim_idx)
        .setKeyIdx(0)
        .setSignature( HexUtil.hexStringToBytes( sig.getHexBytes() ) )
        .build()
        );

    }

    ConstructionCombineResponse resp = new ConstructionCombineResponse();
    resp.setSignedTransaction( HexUtil.getHexString( s_tx.build().toByteString() ) );
    return new ResponseContext().entity( resp );
  }

  public ResponseContext constructionDerive(RequestContext request , JsonNode body) 
    throws Exception
  {
    ConstructionDeriveRequest req = new ObjectMapper().readValue(body.toString(), ConstructionDeriveRequest.class);
    NetworkParams params = RoseUtil.getParams(req.getNetworkIdentifier());

    PublicKey pk = req.getPublicKey(); 

    AddressSpecHash hash = RoseUtil.getSpecHashForPublicKey(pk);

    ConstructionDeriveResponse resp = new ConstructionDeriveResponse();
    resp.setAccountIdentifier( new AccountIdentifier().address(hash.toAddressString(params)) );

    return new ResponseContext().entity(resp);
  }

  public ResponseContext constructionHash(RequestContext request , JsonNode body) 
    throws Exception
  {
    ConstructionHashRequest req = new ObjectMapper().readValue(body.toString(), ConstructionHashRequest.class);
    NetworkParams params = RoseUtil.getParams(req.getNetworkIdentifier());

    String tx_hex = req.getSignedTransaction();
    snowblossom.proto.Transaction s_tx = snowblossom.proto.Transaction.parseFrom( HexUtil.hexStringToBytes(tx_hex) );

    TransactionIdentifierResponse resp = new TransactionIdentifierResponse();

    resp.setTransactionIdentifier( new TransactionIdentifier().hash(HexUtil.getHexString( s_tx.getTxHash() ) ));

    return new ResponseContext().entity(resp);
  }

  public ResponseContext constructionMetadata(RequestContext request , JsonNode body) 
    throws Exception
  {
    ConstructionMetadataRequest req = new ObjectMapper().readValue(body.toString(), ConstructionMetadataRequest.class);
    NetworkParams params = RoseUtil.getParams(req.getNetworkIdentifier());

    ConstructionMetadataResponse resp = new ConstructionMetadataResponse();

    long suggested_fee = Math.round(Globals.BASIC_FEE * 500);

    resp.setSuggestedFee( ImmutableList.of( RoseUtil.getSnowAmount(suggested_fee, params)));
    resp.setMetadata(body);

    return new ResponseContext().entity(resp);
  }

  public ResponseContext constructionParse(RequestContext request , JsonNode body) 
    throws Exception
  {
    ConstructionParseRequest req = new ObjectMapper().readValue(body.toString(), ConstructionParseRequest.class);
    NetworkParams params = RoseUtil.getParams(req.getNetworkIdentifier());

    String tx_hex = req.getTransaction();
    snowblossom.proto.Transaction s_tx = snowblossom.proto.Transaction.parseFrom( HexUtil.hexStringToBytes(tx_hex) );

    NetworkIdentifier id = req.getNetworkIdentifier();
    
    // TODO - this operation should not be online
    SnowBlossomNode node = RoseSnow.getNode(id);
    
    Transaction tx = RoseUtil.protoToModel(s_tx, node);

    ConstructionParseResponse resp = new ConstructionParseResponse();
    for(Operation op : tx.getOperations())
    {
      op.setStatus(null);
      resp.getOperations().add(op);
    }

    TransactionInner inner = TransactionUtil.getInner(s_tx);
    LinkedList<AccountIdentifier> signers = new LinkedList<>();
    for(snowblossom.proto.SignatureEntry sig : s_tx.getSignaturesList())
    {
      int claim_idx = sig.getClaimIdx();  
      AddressSpec spec = inner.getClaims(claim_idx);

      AddressSpecHash hash = AddressUtil.getHashForSpec(spec);

      signers.add( new AccountIdentifier().address(hash.toAddressString(params)));


    }
    resp.setAccountIdentifierSigners(signers);


    return new ResponseContext().entity(resp);
  }

  public ResponseContext constructionPayloads(RequestContext request, JsonNode body) 
    throws Exception
  {
    ConstructionPayloadsRequest req = new ObjectMapper().readValue(body.toString(), ConstructionPayloadsRequest.class);
    NetworkParams params = RoseUtil.getParams(req.getNetworkIdentifier());

    TransactionInner.Builder inner = TransactionInner.newBuilder();
    inner.setVersion(1);
    long input_value=0;
    long output_value=0;
    HashSet<AddressSpecHash> needed_claims = new HashSet<>();

    for(Operation op : req.getOperations())
    {
      if (op.getType().equals("INPUT"))
      {
        AddressSpecHash hs = new AddressSpecHash( op.getAccount().getAddress(), params );
        long v = Long.parseLong(op.getAmount().getValue());

        v=-v; // We think in positive terms for this
        input_value += v;

        String coin_id = op.getCoinChange().getCoinIdentifier().getIdentifier();
        String src_tx_str = coin_id.split(":")[0];
        int idx = Integer.parseInt(coin_id.split(":")[1]);

        needed_claims.add(hs);
        TransactionInput in = TransactionInput.newBuilder()
          .setSpecHash(hs.getBytes())
          .setSrcTxId( HexUtil.hexStringToBytes( src_tx_str ) )
          .setSrcTxOutIdx( idx )
          .build();

        inner.addInputs(in);

      }
      else if (op.getType().equals("OUTPUT"))
      {
        AddressSpecHash hs = new AddressSpecHash( op.getAccount().getAddress(), params );
        long v = Long.parseLong(op.getAmount().getValue());
        output_value += v;
        TransactionOutput out = TransactionOutput.newBuilder()
          .setValue(v)
          .setRecipientSpecHash(hs.getBytes())
          .build();

        inner.addOutputs(out);
      }
      else
      {
        throw new ValidationException("Unexpected op type: " + op.getType());
      }

    }
    
		inner.setFee(input_value - output_value);
    HashSet<PublicKey> needed_signers = new HashSet<>();
    for(PublicKey pk : req.getPublicKeys())
    {
      AddressSpec spec = RoseUtil.getSpecForPublicKey(pk);
      AddressSpecHash hash = RoseUtil.getSpecHashForPublicKey(pk);
      if (needed_claims.contains(hash))
      {
        inner.addClaims(spec);
        needed_claims.remove(hash);
        needed_signers.add(pk);
      }
    }

		snowblossom.proto.Transaction.Builder tx = snowblossom.proto.Transaction.newBuilder();

    ByteString inner_data= inner.build().toByteString();
    tx.setInnerData(inner_data);
    tx.setTxHash(ByteString.copyFrom(DigestUtil.getMD().digest(inner_data.toByteArray())));

    ConstructionPayloadsResponse resp = new ConstructionPayloadsResponse();

		resp.setUnsignedTransaction( HexUtil.getHexString(tx.build().toByteString()));

    for(PublicKey pk : needed_signers)
    {
      
      AddressSpecHash hash = RoseUtil.getSpecHashForPublicKey(pk);
      SigningPayload load = new SigningPayload();

      load.setHexBytes( HexUtil.getHexString(tx.getTxHash()));
      load.setAccountIdentifier( new AccountIdentifier().address( hash.toAddressString(params) ) );
      load.setSignatureType( SignatureType.ECDSA );

      resp.getPayloads().add(load);

    }


    return new ResponseContext().entity(resp);
  }

  public ResponseContext constructionPreprocess(RequestContext request , JsonNode body)
    throws Exception
  {
    ConstructionPreprocessRequest req = new ObjectMapper().readValue(body.toString(), ConstructionPreprocessRequest.class);
    NetworkParams params = RoseUtil.getParams(req.getNetworkIdentifier());
  
    ConstructionPreprocessResponse resp = new ConstructionPreprocessResponse();
    HashSet<AccountIdentifier> needed_keys = new HashSet<>();

    for(Operation op : req.getOperations())
    {
      if (op.getType().equals("INPUT"))
      {
        needed_keys.add(op.getAccount());
      }
    }

    resp.setRequiredPublicKeys(ImmutableList.copyOf(needed_keys));

    return new ResponseContext().entity(resp);
  }

  public ResponseContext constructionSubmit(RequestContext request , JsonNode body) 
    throws Exception
  {
    ConstructionSubmitRequest req = new ObjectMapper().readValue(body.toString(), ConstructionSubmitRequest.class);
    NetworkParams params = RoseUtil.getParams(req.getNetworkIdentifier());

    String tx_hex = req.getSignedTransaction();
    snowblossom.proto.Transaction s_tx = snowblossom.proto.Transaction.parseFrom( HexUtil.hexStringToBytes(tx_hex) );

    snowblossom.proto.SubmitReply reply = RoseSnow.getClient( req.getNetworkIdentifier() ).getBlockingStub().submitTransaction(s_tx);

    if (reply.getSuccess() != true)
    {
      throw new ValidationException(reply.toString());
    }


    TransactionIdentifierResponse resp = new TransactionIdentifierResponse();

    resp.setTransactionIdentifier( new TransactionIdentifier().hash(HexUtil.getHexString( s_tx.getTxHash() ) ));

    return new ResponseContext().entity(resp);

  }

}

