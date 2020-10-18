package io.swagger.model;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;


/**
 * The Version object is utilized to inform the client of the versions of different components of the Rosetta implementation.
 **/
@Schema(description = "The Version object is utilized to inform the client of the versions of different components of the Rosetta implementation.")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaInflectorServerCodegen", date = "2020-10-18T05:48:04.106Z[GMT]")
public class Version   {
  @JsonProperty("rosetta_version")
  private String rosettaVersion = null;
  @JsonProperty("node_version")
  private String nodeVersion = null;
  @JsonProperty("middleware_version")
  private String middlewareVersion = null;
  @JsonProperty("metadata")
  private Object metadata = null;
  /**
   * The rosetta_version is the version of the Rosetta interface the implementation adheres to. This can be useful for clients looking to reliably parse responses.
   **/
  public Version rosettaVersion(String rosettaVersion) {
    this.rosettaVersion = rosettaVersion;
    return this;
  }

  
  @Schema(example = "1.2.5", required = true, description = "The rosetta_version is the version of the Rosetta interface the implementation adheres to. This can be useful for clients looking to reliably parse responses.")
  @JsonProperty("rosetta_version")
  public String getRosettaVersion() {
    return rosettaVersion;
  }
  public void setRosettaVersion(String rosettaVersion) {
    this.rosettaVersion = rosettaVersion;
  }

  /**
   * The node_version is the canonical version of the node runtime. This can help clients manage deployments.
   **/
  public Version nodeVersion(String nodeVersion) {
    this.nodeVersion = nodeVersion;
    return this;
  }

  
  @Schema(example = "1.0.2", required = true, description = "The node_version is the canonical version of the node runtime. This can help clients manage deployments.")
  @JsonProperty("node_version")
  public String getNodeVersion() {
    return nodeVersion;
  }
  public void setNodeVersion(String nodeVersion) {
    this.nodeVersion = nodeVersion;
  }

  /**
   * When a middleware server is used to adhere to the Rosetta interface, it should return its version here. This can help clients manage deployments.
   **/
  public Version middlewareVersion(String middlewareVersion) {
    this.middlewareVersion = middlewareVersion;
    return this;
  }

  
  @Schema(example = "0.2.7", description = "When a middleware server is used to adhere to the Rosetta interface, it should return its version here. This can help clients manage deployments.")
  @JsonProperty("middleware_version")
  public String getMiddlewareVersion() {
    return middlewareVersion;
  }
  public void setMiddlewareVersion(String middlewareVersion) {
    this.middlewareVersion = middlewareVersion;
  }

  /**
   * Any other information that may be useful about versioning of dependent services should be returned here.
   **/
  public Version metadata(Object metadata) {
    this.metadata = metadata;
    return this;
  }

  
  @Schema(description = "Any other information that may be useful about versioning of dependent services should be returned here.")
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
    Version version = (Version) o;
    return Objects.equals(rosettaVersion, version.rosettaVersion) &&
        Objects.equals(nodeVersion, version.nodeVersion) &&
        Objects.equals(middlewareVersion, version.middlewareVersion) &&
        Objects.equals(metadata, version.metadata);
  }

  @Override
  public int hashCode() {
    return Objects.hash(rosettaVersion, nodeVersion, middlewareVersion, metadata);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Version {\n");
    sb.append("    rosettaVersion: ").append(toIndentedString(rosettaVersion)).append("\n");
    sb.append("    nodeVersion: ").append(toIndentedString(nodeVersion)).append("\n");
    sb.append("    middlewareVersion: ").append(toIndentedString(middlewareVersion)).append("\n");
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
