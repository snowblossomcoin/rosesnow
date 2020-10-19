package io.swagger.controllers;

import io.swagger.oas.inflector.models.RequestContext;
import io.swagger.oas.inflector.models.ResponseContext;
import javax.ws.rs.core.Response.Status;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import java.io.File;
import java.util.List;
import java.util.LinkedList;

import io.swagger.model.*;

import io.swagger.model.Error;
import io.swagger.model.MetadataRequest;
import io.swagger.model.NetworkListResponse;
import io.swagger.model.NetworkOptionsResponse;
import io.swagger.model.NetworkRequest;
import io.swagger.model.NetworkStatusResponse;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.snowblossom.rosesnow.RoseSnow;
import snowblossom.node.SnowBlossomNode;
import snowblossom.lib.ChainHash;
import snowblossom.proto.BlockHeader;
import snowblossom.node.PeerLink;


@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaInflectorServerCodegen", date = "2020-10-18T05:48:04.106Z[GMT]")public class Network  {
  /** 
   * Uncomment and implement as you see fit.  These operations will map
   * Directly to operation calls from the routing logic.  Because the inflector
   * Code allows you to implement logic incrementally, they are disabled.
   **/
  
  public ResponseContext networkList(RequestContext request , JsonNode body ) 
    throws Exception
  {
    MetadataRequest req = new ObjectMapper().readValue(body.toString(), MetadataRequest.class);

		LinkedList<NetworkIdentifier> lst = new LinkedList<>();

    lst.add(new NetworkIdentifier().blockchain("snowblossom").network("mainnet"));
    lst.add(new NetworkIdentifier().blockchain("snowblossom").network("testnet"));

		NetworkListResponse nlr = new NetworkListResponse().networkIdentifiers(lst);
		return new ResponseContext().entity(nlr);

  }

  public ResponseContext networkOptions(RequestContext request , JsonNode body )
    throws Exception
  {
    NetworkRequest req = new ObjectMapper().readValue(body.toString(), NetworkRequest.class);

    return new ResponseContext().status(Status.INTERNAL_SERVER_ERROR).entity( "Not implemented" );
  }

    public ResponseContext networkStatus(RequestContext request , JsonNode body )
      throws Exception
    {
      NetworkRequest req = new ObjectMapper().readValue(body.toString(), NetworkRequest.class);

      NetworkIdentifier id = req.getNetworkIdentifier();

      SnowBlossomNode node = RoseSnow.getNode(id);

      NetworkStatusResponse status = new NetworkStatusResponse();

      SyncStatus sync = new SyncStatus();
      sync.setStage("catch_up");

      if (node.getBlockIngestor().getHead() != null)
      {
        BlockHeader head = node.getBlockIngestor().getHead().getHeader();

        ChainHash hash = new ChainHash( head.getSnowHash());
        status.setCurrentBlockIdentifier( new BlockIdentifier()
          .index((long)head.getBlockHeight())
          .hash(hash.toString()));
        status.setCurrentBlockTimestamp( head.getTimestamp() );

        sync.setCurrentIndex( (long)head.getBlockHeight() );
        sync.setTargetIndex( (long)node.getPeerage().getHighestSeenHeader().getBlockHeight() );
        if (node.areWeSynced())
        {
          sync.setStage("synced");
        }
      }

      if (node.getDB().getBlockHashAtHeight(0) != null)
      {
        ChainHash hash = node.getDB().getBlockHashAtHeight(0);
        BlockIdentifier gen = new BlockIdentifier().index(0L).hash(hash.toString());
        status.setOldestBlockIdentifier(gen);
        status.setGenesisBlockIdentifier(gen);

      }
      for(PeerLink link : node.getPeerage().getLinkList())
      {
        status.getPeers().add(new Peer().peerId( link.getLinkId() ) );
      }



      status.setSyncStatus(sync);




      return new ResponseContext().entity(status);
    }

}

