package io.swagger.model;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.model.NetworkIdentifier;
import io.swagger.v3.oas.annotations.media.Schema;


/**
 * ConstructionHashRequest is the input to the &#x60;/construction/hash&#x60; endpoint.
 **/
@Schema(description = "ConstructionHashRequest is the input to the `/construction/hash` endpoint.")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaInflectorServerCodegen", date = "2020-10-18T05:48:04.106Z[GMT]")
public class ConstructionHashRequest   {
  @JsonProperty("network_identifier")
  private NetworkIdentifier networkIdentifier = null;
  @JsonProperty("signed_transaction")
  private String signedTransaction = null;
  /**
   **/
  public ConstructionHashRequest networkIdentifier(NetworkIdentifier networkIdentifier) {
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
  public ConstructionHashRequest signedTransaction(String signedTransaction) {
    this.signedTransaction = signedTransaction;
    return this;
  }

  
  @Schema(required = true, description = "")
  @JsonProperty("signed_transaction")
  public String getSignedTransaction() {
    return signedTransaction;
  }
  public void setSignedTransaction(String signedTransaction) {
    this.signedTransaction = signedTransaction;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ConstructionHashRequest constructionHashRequest = (ConstructionHashRequest) o;
    return Objects.equals(networkIdentifier, constructionHashRequest.networkIdentifier) &&
        Objects.equals(signedTransaction, constructionHashRequest.signedTransaction);
  }

  @Override
  public int hashCode() {
    return Objects.hash(networkIdentifier, signedTransaction);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ConstructionHashRequest {\n");
    sb.append("    networkIdentifier: ").append(toIndentedString(networkIdentifier)).append("\n");
    sb.append("    signedTransaction: ").append(toIndentedString(signedTransaction)).append("\n");
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
