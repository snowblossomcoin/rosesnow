package io.swagger.model;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.model.NetworkIdentifier;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;


/**
 * A NetworkListResponse contains all NetworkIdentifiers that the node can serve information for.
 **/
@Schema(description = "A NetworkListResponse contains all NetworkIdentifiers that the node can serve information for.")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaInflectorServerCodegen", date = "2020-10-18T05:48:04.106Z[GMT]")
public class NetworkListResponse   {
  @JsonProperty("network_identifiers")
  private List<NetworkIdentifier> networkIdentifiers = new ArrayList<>();
  /**
   **/
  public NetworkListResponse networkIdentifiers(List<NetworkIdentifier> networkIdentifiers) {
    this.networkIdentifiers = networkIdentifiers;
    return this;
  }

  
  @Schema(required = true, description = "")
  @JsonProperty("network_identifiers")
  public List<NetworkIdentifier> getNetworkIdentifiers() {
    return networkIdentifiers;
  }
  public void setNetworkIdentifiers(List<NetworkIdentifier> networkIdentifiers) {
    this.networkIdentifiers = networkIdentifiers;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NetworkListResponse networkListResponse = (NetworkListResponse) o;
    return Objects.equals(networkIdentifiers, networkListResponse.networkIdentifiers);
  }

  @Override
  public int hashCode() {
    return Objects.hash(networkIdentifiers);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NetworkListResponse {\n");
    sb.append("    networkIdentifiers: ").append(toIndentedString(networkIdentifiers)).append("\n");
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
