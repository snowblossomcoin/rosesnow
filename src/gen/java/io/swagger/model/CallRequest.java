package io.swagger.model;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.model.NetworkIdentifier;
import io.swagger.v3.oas.annotations.media.Schema;


/**
 * CallRequest is the input to the &#x60;/call&#x60; endpoint.
 **/
@Schema(description = "CallRequest is the input to the `/call` endpoint.")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaInflectorServerCodegen", date = "2020-11-12T07:15:46.859Z[GMT]")
public class CallRequest   {
  @JsonProperty("network_identifier")
  private NetworkIdentifier networkIdentifier = null;
  @JsonProperty("method")
  private String method = null;
  @JsonProperty("parameters")
  private Object parameters = null;
  /**
   **/
  public CallRequest networkIdentifier(NetworkIdentifier networkIdentifier) {
    this.networkIdentifier = networkIdentifier;
    return this;
  }

  
  @Schema(required = true, description = "")
  @JsonProperty("network_identifier")
  public NetworkIdentifier getNetworkIdentifier() {
    return networkIdentifier;
  }
  public void setNetworkIdentifier(NetworkIdentifier networkIdentifier) {
    this.networkIdentifier = networkIdentifier;
  }

  /**
   * Method is some network-specific procedure call. This method could map to a network-specific RPC endpoint, a method in an SDK generated from a smart contract, or some hybrid of the two. The implementation must define all available methods in the Allow object. However, it is up to the caller to determine which parameters to provide when invoking `/call`.
   **/
  public CallRequest method(String method) {
    this.method = method;
    return this;
  }

  
  @Schema(example = "eth_call", required = true, description = "Method is some network-specific procedure call. This method could map to a network-specific RPC endpoint, a method in an SDK generated from a smart contract, or some hybrid of the two. The implementation must define all available methods in the Allow object. However, it is up to the caller to determine which parameters to provide when invoking `/call`.")
  @JsonProperty("method")
  public String getMethod() {
    return method;
  }
  public void setMethod(String method) {
    this.method = method;
  }

  /**
   * Parameters is some network-specific argument for a method. It is up to the caller to determine which parameters to provide when invoking `/call`.
   **/
  public CallRequest parameters(Object parameters) {
    this.parameters = parameters;
    return this;
  }

  
  @Schema(example = "{\"block_number\":23,\"address\":\"0x52bc44d5378309ee2abf1539bf71de1b7d7be3b5\"}", required = true, description = "Parameters is some network-specific argument for a method. It is up to the caller to determine which parameters to provide when invoking `/call`.")
  @JsonProperty("parameters")
  public Object getParameters() {
    return parameters;
  }
  public void setParameters(Object parameters) {
    this.parameters = parameters;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CallRequest callRequest = (CallRequest) o;
    return Objects.equals(networkIdentifier, callRequest.networkIdentifier) &&
        Objects.equals(method, callRequest.method) &&
        Objects.equals(parameters, callRequest.parameters);
  }

  @Override
  public int hashCode() {
    return Objects.hash(networkIdentifier, method, parameters);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CallRequest {\n");
    sb.append("    networkIdentifier: ").append(toIndentedString(networkIdentifier)).append("\n");
    sb.append("    method: ").append(toIndentedString(method)).append("\n");
    sb.append("    parameters: ").append(toIndentedString(parameters)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
