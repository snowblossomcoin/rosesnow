package io.swagger.model;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;


/**
 * In blockchains with sharded state, the SubNetworkIdentifier is required to query some object on a specific shard. This identifier is optional for all non-sharded blockchains.
 **/
@Schema(description = "In blockchains with sharded state, the SubNetworkIdentifier is required to query some object on a specific shard. This identifier is optional for all non-sharded blockchains.")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaInflectorServerCodegen", date = "2020-11-12T07:15:46.859Z[GMT]")
public class SubNetworkIdentifier   {
  @JsonProperty("network")
  private String network = null;
  @JsonProperty("metadata")
  private Object metadata = null;
  /**
   **/
  public SubNetworkIdentifier network(String network) {
    this.network = network;
    return this;
  }

  
  @Schema(example = "shard 1", required = true, description = "")
  @JsonProperty("network")
  public String getNetwork() {
    return network;
  }
  public void setNetwork(String network) {
    this.network = network;
  }

  /**
   **/
  public SubNetworkIdentifier metadata(Object metadata) {
    this.metadata = metadata;
    return this;
  }

  
  @Schema(example = "{\"producer\":\"0x52bc44d5378309ee2abf1539bf71de1b7d7be3b5\"}", description = "")
  @JsonProperty("metadata")
  public Object getMetadata() {
    return metadata;
  }
  public void setMetadata(Object metadata) {
    this.metadata = metadata;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SubNetworkIdentifier subNetworkIdentifier = (SubNetworkIdentifier) o;
    return Objects.equals(network, subNetworkIdentifier.network) &&
        Objects.equals(metadata, subNetworkIdentifier.metadata);
  }

  @Override
  public int hashCode() {
    return Objects.hash(network, metadata);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SubNetworkIdentifier {\n");
    sb.append("    network: ").append(toIndentedString(network)).append("\n");
    sb.append("    metadata: ").append(toIndentedString(metadata)).append("\n");
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
