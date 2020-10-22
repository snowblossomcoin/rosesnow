package io.swagger.controllers;

import io.swagger.oas.inflector.models.RequestContext;
import io.swagger.oas.inflector.models.ResponseContext;
import javax.ws.rs.core.Response.Status;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import java.io.File;
import java.util.List;

import io.swagger.model.*;

import io.swagger.model.BlockRequest;
import io.swagger.model.BlockResponse;
import io.swagger.model.BlockTransactionRequest;
import io.swagger.model.BlockTransactionResponse;
import io.swagger.model.Error;
import com.fasterxml.jackson.databind.JsonNode;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.snowblossom.rosesnow.RoseSnow;
import org.snowblossom.rosesnow.RoseUtil;
import snowblossom.lib.ChainHash;
import snowblossom.lib.Globals;
import snowblossom.node.SnowBlossomNode;
import snowblossom.proto.BlockHeader;


@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaInflectorServerCodegen", date = "2020-10-18T05:48:04.106Z[GMT]")
public class Block
{
    public ResponseContext block(RequestContext request , JsonNode body) 
      throws Exception
    {
      BlockRequest req = new ObjectMapper().readValue(body.toString(), BlockRequest.class);

      NetworkIdentifier id = req.getNetworkIdentifier();
      SnowBlossomNode node = RoseSnow.getNode(id);

      PartialBlockIdentifier pbi = req.getBlockIdentifier();

      ChainHash block_hash = null;
      if (pbi.getHash() != null) block_hash = new ChainHash(pbi.getHash());
      else
      {
        block_hash = node.getDB().getBlockHashAtHeight(pbi.getIndex().intValue());
      }

      BlockResponse resp = new BlockResponse();

      snowblossom.proto.Block blk = node.getDB().getBlockMap().get(block_hash.getBytes());
      
      io.swagger.model.Block b = new io.swagger.model.Block();

      b.setBlockIdentifier( new BlockIdentifier()
        .index( (long) blk.getHeader().getBlockHeight() )
        .hash( new ChainHash(blk.getHeader().getSnowHash()).toString() ));

      if (blk.getHeader().getBlockHeight() == 0)
      {
        b.setParentBlockIdentifier( b.getBlockIdentifier());

      }
      else
      {
        long p = (long) blk.getHeader().getBlockHeight()-1;

        b.setParentBlockIdentifier( new BlockIdentifier()
          .index( p )
          .hash( new ChainHash(blk.getHeader().getPrevBlockHash()).toString() ));
      }
      b.setTimestamp( blk.getHeader().getTimestamp() );

      for( snowblossom.proto.Transaction s_tx : blk.getTransactionsList() )
      {
        b.getTransactions().add( RoseUtil.protoToModel(s_tx, node) );
      }


      resp.setBlock(b);

      return new ResponseContext().entity(resp);
    }

  public ResponseContext blockTransaction(RequestContext request , JsonNode body )
    throws Exception
  {
    BlockTransactionRequest req = new ObjectMapper().readValue(body.toString(), BlockTransactionRequest.class);

    NetworkIdentifier id = req.getNetworkIdentifier();
    BlockIdentifier bi = req.getBlockIdentifier();
    TransactionIdentifier ti = req.getTransactionIdentifier();

    SnowBlossomNode node = RoseSnow.getNode(id);

    ChainHash tx_id = new ChainHash(ti.getHash());

    snowblossom.proto.Transaction s_tx = node.getDB().getTransactionMap().get(tx_id.getBytes());

    BlockTransactionResponse resp = new BlockTransactionResponse();

    resp.setTransaction( RoseUtil.protoToModel(s_tx, node) );

    return new ResponseContext().entity( resp );
  }

}

