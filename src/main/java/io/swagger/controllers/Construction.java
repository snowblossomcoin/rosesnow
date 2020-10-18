package io.swagger.controllers;

import io.swagger.oas.inflector.models.RequestContext;
import io.swagger.oas.inflector.models.ResponseContext;
import javax.ws.rs.core.Response.Status;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import java.io.File;
import java.util.List;

import io.swagger.model.*;

import io.swagger.model.ConstructionCombineRequest;
import io.swagger.model.ConstructionCombineResponse;
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

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaInflectorServerCodegen", date = "2020-10-18T05:48:04.106Z[GMT]")public class Construction {
  /** 
   * Uncomment and implement as you see fit.  These operations will map
   * Directly to operation calls from the routing logic.  Because the inflector
   * Code allows you to implement logic incrementally, they are disabled.
   **/

    public ResponseContext constructionCombine(RequestContext request , JsonNode body 
) {
        return new ResponseContext().status(Status.INTERNAL_SERVER_ERROR).entity( "Not implemented" );
    }

    public ResponseContext constructionDerive(RequestContext request , JsonNode body 
) {
        return new ResponseContext().status(Status.INTERNAL_SERVER_ERROR).entity( "Not implemented" );
    }

    public ResponseContext constructionHash(RequestContext request , JsonNode body 
) {
        return new ResponseContext().status(Status.INTERNAL_SERVER_ERROR).entity( "Not implemented" );
    }

    public ResponseContext constructionMetadata(RequestContext request , JsonNode body 
) {
        return new ResponseContext().status(Status.INTERNAL_SERVER_ERROR).entity( "Not implemented" );
    }

    public ResponseContext constructionParse(RequestContext request , JsonNode body 
) {
        return new ResponseContext().status(Status.INTERNAL_SERVER_ERROR).entity( "Not implemented" );
    }

    public ResponseContext constructionPayloads(RequestContext request , JsonNode body 
) {
        return new ResponseContext().status(Status.INTERNAL_SERVER_ERROR).entity( "Not implemented" );
    }

    public ResponseContext constructionPreprocess(RequestContext request , JsonNode body 
) {
        return new ResponseContext().status(Status.INTERNAL_SERVER_ERROR).entity( "Not implemented" );
    }

    public ResponseContext constructionSubmit(RequestContext request , JsonNode body 
) {
        return new ResponseContext().status(Status.INTERNAL_SERVER_ERROR).entity( "Not implemented" );
    }

}
