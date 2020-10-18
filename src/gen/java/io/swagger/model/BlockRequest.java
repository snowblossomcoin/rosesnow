package io.swagger.model;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.model.NetworkIdentifier;
import io.swagger.model.PartialBlockIdentifier;
import io.swagger.v3.oas.annotations.media.Schema;


/**
 * A BlockRequest is utilized to make a block request on the /block endpoint. 
 **/
@Schema(description = "A BlockRequest is utilized to make a block request on the /block endpoint. ")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaInflectorServerCodegen", date = "2020-10-15T17:54:45.833Z[GMT]")
public class BlockRequest   {
  @JsonProperty("network_identifier")
  private NetworkIdentifier networkIdentifier = null;
  @JsonProperty("block_identifier")
  private PartialBlockIdentifier blockIdentifier = null;
  /**
   **/
  public BlockRequest networkIdentifier(NetworkIdentifier networkIdentifier) {
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
  public BlockRequest blockIdentifier(PartialBlockIdentifier blockIdentifier) {
    this.blockIdentifier = blockIdentifier;
    return this;
  }

  
  @Schema(required = true, description = "")
  @JsonProperty("block_identifier")
  public PartialBlockIdentifier getBlockIdentifier() {
    return blockIdentifier;
  }
  public void setBlockIdentifier(PartialBlockIdentifier blockIdentifier) {
    this.blockIdentifier = blockIdentifier;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BlockRequest blockRequest = (BlockRequest) o;
    return Objects.equals(networkIdentifier, blockRequest.networkIdentifier) &&
        Objects.equals(blockIdentifier, blockRequest.blockIdentifier);
  }

  @Override
  public int hashCode() {
    return Objects.hash(networkIdentifier, blockIdentifier);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BlockRequest {\n");
    sb.append("    networkIdentifier: ").append(toIndentedString(networkIdentifier)).append("\n");
    sb.append("    blockIdentifier: ").append(toIndentedString(blockIdentifier)).append("\n");
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
