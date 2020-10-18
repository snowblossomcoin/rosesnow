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
      return new ResponseContext().status(Status.INTERNAL_SERVER_ERROR).entity( "Not implemented" );
    }

}

