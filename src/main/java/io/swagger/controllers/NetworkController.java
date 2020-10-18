package io.swagger.controllers;

import io.swagger.oas.inflector.models.RequestContext;
import io.swagger.oas.inflector.models.ResponseContext;
import javax.ws.rs.core.Response.Status;

import java.io.File;
import java.util.List;

import io.swagger.model.*;

import io.swagger.model.Error;
import io.swagger.model.MetadataRequest;
import io.swagger.model.NetworkListResponse;
import io.swagger.model.NetworkOptionsResponse;
import io.swagger.model.NetworkRequest;
import io.swagger.model.NetworkStatusResponse;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaInflectorServerCodegen", date = "2020-10-15T17:54:45.833Z[GMT]")public class NetworkController  {
  /** 
   * Uncomment and implement as you see fit.  These operations will map
   * Directly to operation calls from the routing logic.  Because the inflector
   * Code allows you to implement logic incrementally, they are disabled.
   **/

  
    public ResponseContext networkList(RequestContext request , MetadataRequest body 
) {
        return new ResponseContext().status(Status.INTERNAL_SERVER_ERROR).entity( "Not bimplimented" );
    }
  

  /*
    public ResponseContext networkOptions(RequestContext request , NetworkRequest body 
) {
        return new ResponseContext().status(Status.INTERNAL_SERVER_ERROR).entity( "Not implemented" );
    }
  */

  /*
    public ResponseContext networkStatus(RequestContext request , NetworkRequest body 
) {
        return new ResponseContext().status(Status.INTERNAL_SERVER_ERROR).entity( "Not implemented" );
    }
  */

}

