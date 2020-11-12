package io.swagger.model;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;


/**
 * A Peer is a representation of a node&#x27;s peer.
 **/
@Schema(description = "A Peer is a representation of a node's peer.")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaInflectorServerCodegen", date = "2020-11-12T07:15:46.859Z[GMT]")
public class Peer   {
  @JsonProperty("peer_id")
  private String peerId = null;
  @JsonProperty("metadata")
  private Object metadata = null;
  /**
   **/
  public Peer peerId(String peerId) {
    this.peerId = peerId;
    return this;
  }

  
  @Schema(example = "0x52bc44d5378309ee2abf1539bf71de1b7d7be3b5", required = true, description = "")
  @JsonProperty("peer_id")
  public String getPeerId() {
    return peerId;
  }
  public void setPeerId(String peerId) {
    this.peerId = peerId;
  }

  /**
   **/
  public Peer metadata(Object metadata) {
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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Peer peer = (Peer) o;
    return Objects.equals(peerId, peer.peerId) &&
        Objects.equals(metadata, peer.metadata);
  }

  @Override
  public int hashCode() {
    return Objects.hash(peerId, metadata);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Peer {\n");
    sb.append("    peerId: ").append(toIndentedString(peerId)).append("\n");
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
