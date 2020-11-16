package io.swagger.controllers;

import io.swagger.oas.inflector.models.RequestContext;
import io.swagger.oas.inflector.models.ResponseContext;
import javax.ws.rs.core.Response.Status;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import java.io.File;
import java.util.List;

import io.swagger.model.*;

import io.swagger.model.Error;
import io.swagger.model.MempoolResponse;
import io.swagger.model.MempoolTransactionRequest;
import io.swagger.model.MempoolTransactionResponse;
import io.swagger.model.NetworkRequest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.snowblossom.rosesnow.RoseSnow;
import org.snowblossom.rosesnow.RoseUtil;
import snowblossom.lib.ChainHash;
import snowblossom.lib.Globals;
import snowblossom.node.PeerLink;
import snowblossom.node.SnowBlossomNode;
import snowblossom.proto.BlockHeader;


@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaInflectorServerCodegen", date = "2020-10-18T05:48:04.106Z[GMT]")

public class Mempool {

  public ResponseContext mempool(RequestContext request , JsonNode body)
    throws Exception
  {
    NetworkRequest req = new ObjectMapper().readValue(body.toString(), NetworkRequest.class);
    NetworkIdentifier id = req.getNetworkIdentifier();
    SnowBlossomNode node = RoseSnow.getNode(id);

    MempoolResponse resp = new MempoolResponse();

    for(ChainHash hash : node.getMemPool().getPoolHashList())
    {
      resp.getTransactionIdentifiers().add( new TransactionIdentifier().hash( hash.toString() ));
    }

    return new ResponseContext().entity(resp );
  }

  public ResponseContext mempoolTransaction(RequestContext request , JsonNode body) 
    throws Exception
  {
    MempoolTransactionRequest req = new ObjectMapper().readValue(body.toString(), MempoolTransactionRequest.class);
    NetworkIdentifier id = req.getNetworkIdentifier();
    SnowBlossomNode node = RoseSnow.getNode(id);

    ChainHash tx_id = new ChainHash(req.getTransactionIdentifier().getHash());
    
    MempoolTransactionResponse resp = new MempoolTransactionResponse();

    snowblossom.proto.Transaction s_tx = node.getMemPool().getTransaction(tx_id);
    if (s_tx != null)
    {
      resp.setTransaction( RoseUtil.protoToModel(s_tx, node, node.getParams()));
    }

    return new ResponseContext().entity(resp);
  }

}

