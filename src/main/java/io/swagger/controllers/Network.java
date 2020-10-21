package io.swagger.controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.model.*;
import io.swagger.model.MetadataRequest;
import io.swagger.model.NetworkListResponse;
import io.swagger.model.NetworkOptionsResponse;
import io.swagger.model.NetworkRequest;
import io.swagger.model.NetworkStatusResponse;
import io.swagger.oas.inflector.models.RequestContext;
import io.swagger.oas.inflector.models.ResponseContext;
import java.util.LinkedList;
import org.snowblossom.rosesnow.RoseSnow;
import snowblossom.lib.ChainHash;
import snowblossom.lib.Globals;
import snowblossom.node.PeerLink;
import snowblossom.node.SnowBlossomNode;
import snowblossom.proto.BlockHeader;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaInflectorServerCodegen", date = "2020-10-18T05:48:04.106Z[GMT]")
public class Network
{
  
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
    
    NetworkIdentifier id = req.getNetworkIdentifier();

    NetworkOptionsResponse options = new NetworkOptionsResponse();

    Version ver = new Version();
    ver.setRosettaVersion("1.4.5");
    ver.setNodeVersion( Globals.VERSION );
    ver.setMiddlewareVersion( RoseSnow.VERSION );
    options.setVersion(ver);

    Allow allow = new Allow();

    allow.getOperationTypes().add("SPEND");
    allow.getOperationTypes().add("RECEIVE");

    allow.getOperationStatuses().add(new OperationStatus().status("OK").successful(true));
    allow.getOperationStatuses().add(new OperationStatus().status("CONFIRMED").successful(true));
    allow.getOperationStatuses().add(new OperationStatus().status("PENDING").successful(true));
    allow.setHistoricalBalanceLookup(true);
    options.setAllow(allow);


    return new ResponseContext().entity(options);
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
      if (node.getPeerage().getHighestSeenHeader() != null)
      {
        sync.setTargetIndex( (long)node.getPeerage().getHighestSeenHeader().getBlockHeight() );
      }
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
