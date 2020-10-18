package io.swagger.model;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.model.Allow;
import io.swagger.model.Version;
import io.swagger.v3.oas.annotations.media.Schema;


/**
 * NetworkOptionsResponse contains information about the versioning of the node and the allowed operation statuses, operation types, and errors. 
 **/
@Schema(description = "NetworkOptionsResponse contains information about the versioning of the node and the allowed operation statuses, operation types, and errors. ")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaInflectorServerCodegen", date = "2020-10-15T17:54:45.833Z[GMT]")
public class NetworkOptionsResponse   {
  @JsonProperty("version")
  private Version version = null;
  @JsonProperty("allow")
  private Allow allow = null;
  /**
   **/
  public NetworkOptionsResponse version(Version version) {
    this.version = version;
    return this;
  }

  
  @Schema(required = true, description = "")
  @JsonProperty("version")
  public Version getVersion() {
    return version;
  }
  public void setVersion(Version version) {
    this.version = version;
  }

  /**
   **/
  public NetworkOptionsResponse allow(Allow allow) {
    this.allow = allow;
    return this;
  }

  
  @Schema(required = true, description = "")
  @JsonProperty("allow")
  public Allow getAllow() {
    return allow;
  }
  public void setAllow(Allow allow) {
    this.allow = allow;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NetworkOptionsResponse networkOptionsResponse = (NetworkOptionsResponse) o;
    return Objects.equals(version, networkOptionsResponse.version) &&
        Objects.equals(allow, networkOptionsResponse.allow);
  }

  @Override
  public int hashCode() {
    return Objects.hash(version, allow);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NetworkOptionsResponse {\n");
    sb.append("    version: ").append(toIndentedString(version)).append("\n");
    sb.append("    allow: ").append(toIndentedString(allow)).append("\n");
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
