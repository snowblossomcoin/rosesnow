package io.swagger.controllers;

import io.swagger.oas.inflector.models.RequestContext;
import io.swagger.oas.inflector.models.ResponseContext;
import javax.ws.rs.core.Response.Status;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import java.io.File;
import java.util.List;

import io.swagger.model.*;

import io.swagger.model.AccountBalanceRequest;
import io.swagger.model.AccountBalanceResponse;
import io.swagger.model.Error;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaInflectorServerCodegen", date = "2020-10-18T05:48:04.106Z[GMT]")
public class Account 
{
  /** 
   * Uncomment and implement as you see fit.  These operations will map
   * Directly to operation calls from the routing logic.  Because the inflector
   * Code allows you to implement logic incrementally, they are disabled.
   **/

  public ResponseContext accountBalance(RequestContext request , JsonNode body) 
    throws Exception
  {
    AccountBalanceRequest req = new ObjectMapper().readValue(body.toString(), AccountBalanceRequest.class);
    NetworkIdentifier id = req.getNetworkIdentifier();
    AccountIdentifier acct = req.getAccountIdentifier();




    return new ResponseContext().status(Status.INTERNAL_SERVER_ERROR).entity( "Not implemented" );
  }

}

