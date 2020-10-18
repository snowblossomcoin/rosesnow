package io.swagger.model;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.model.NetworkIdentifier;
import io.swagger.model.Operation;
import io.swagger.model.PublicKey;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;


/**
 * ConstructionPayloadsRequest is the request to &#x60;/construction/payloads&#x60;. It contains the network, a slice of operations, and arbitrary metadata that was returned by the call to &#x60;/construction/metadata&#x60;.  Optionally, the request can also include an array of PublicKeys associated with the AccountIdentifiers returned in ConstructionPreprocessResponse. 
 **/
@Schema(description = "ConstructionPayloadsRequest is the request to `/construction/payloads`. It contains the network, a slice of operations, and arbitrary metadata that was returned by the call to `/construction/metadata`.  Optionally, the request can also include an array of PublicKeys associated with the AccountIdentifiers returned in ConstructionPreprocessResponse. ")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaInflectorServerCodegen", date = "2020-10-15T17:54:45.833Z[GMT]")
public class ConstructionPayloadsRequest   {
  @JsonProperty("network_identifier")
  private NetworkIdentifier networkIdentifier = null;
  @JsonProperty("operations")
  private List<Operation> operations = new ArrayList<>();
  @JsonProperty("metadata")
  private Object metadata = null;
  @JsonProperty("public_keys")
  private List<PublicKey> publicKeys = null;
  /**
   **/
  public ConstructionPayloadsRequest networkIdentifier(NetworkIdentifier networkIdentifier) {
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
   **/
  public ConstructionPayloadsRequest operations(List<Operation> operations) {
    this.operations = operations;
    return this;
  }

  
  @Schema(required = true, description = "")
  @JsonProperty("operations")
  public List<Operation> getOperations() {
    return operations;
  }
  public void setOperations(List<Operation> operations) {
    this.operations = operations;
  }

  /**
   **/
  public ConstructionPayloadsRequest metadata(Object metadata) {
    this.metadata = metadata;
    return this;
  }

  
  @Schema(description = "")
  @JsonProperty("metadata")
  public Object getMetadata() {
    return metadata;
  }
  public void setMetadata(Object metadata) {
    this.metadata = metadata;
  }

  /**
   **/
  public ConstructionPayloadsRequest publicKeys(List<PublicKey> publicKeys) {
    this.publicKeys = publicKeys;
    return this;
  }

  
  @Schema(description = "")
  @JsonProperty("public_keys")
  public List<PublicKey> getPublicKeys() {
    return publicKeys;
  }
  public void setPublicKeys(List<PublicKey> publicKeys) {
    this.publicKeys = publicKeys;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ConstructionPayloadsRequest constructionPayloadsRequest = (ConstructionPayloadsRequest) o;
    return Objects.equals(networkIdentifier, constructionPayloadsRequest.networkIdentifier) &&
        Objects.equals(operations, constructionPayloadsRequest.operations) &&
        Objects.equals(metadata, constructionPayloadsRequest.metadata) &&
        Objects.equals(publicKeys, constructionPayloadsRequest.publicKeys);
  }

  @Override
  public int hashCode() {
    return Objects.hash(networkIdentifier, operations, metadata, publicKeys);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ConstructionPayloadsRequest {\n");
    sb.append("    networkIdentifier: ").append(toIndentedString(networkIdentifier)).append("\n");
    sb.append("    operations: ").append(toIndentedString(operations)).append("\n");
    sb.append("    metadata: ").append(toIndentedString(metadata)).append("\n");
    sb.append("    publicKeys: ").append(toIndentedString(publicKeys)).append("\n");
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
