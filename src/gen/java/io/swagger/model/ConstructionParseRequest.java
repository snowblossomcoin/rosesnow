package io.swagger.model;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.model.NetworkIdentifier;
import io.swagger.v3.oas.annotations.media.Schema;


/**
 * ConstructionParseRequest is the input to the &#x60;/construction/parse&#x60; endpoint. It allows the caller to parse either an unsigned or signed transaction. 
 **/
@Schema(description = "ConstructionParseRequest is the input to the `/construction/parse` endpoint. It allows the caller to parse either an unsigned or signed transaction. ")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaInflectorServerCodegen", date = "2020-10-15T17:54:45.833Z[GMT]")
public class ConstructionParseRequest   {
  @JsonProperty("network_identifier")
  private NetworkIdentifier networkIdentifier = null;
  @JsonProperty("signed")
  private Boolean signed = null;
  @JsonProperty("transaction")
  private String transaction = null;
  /**
   **/
  public ConstructionParseRequest networkIdentifier(NetworkIdentifier networkIdentifier) {
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
   * Signed is a boolean indicating whether the transaction is signed. 
   **/
  public ConstructionParseRequest signed(Boolean signed) {
    this.signed = signed;
    return this;
  }

  
  @Schema(required = true, description = "Signed is a boolean indicating whether the transaction is signed. ")
  @JsonProperty("signed")
  public Boolean isSigned() {
    return signed;
  }
  public void setSigned(Boolean signed) {
    this.signed = signed;
  }

  /**
   * This must be either the unsigned transaction blob returned by `/construction/payloads` or the signed transaction blob returned by `/construction/combine`. 
   **/
  public ConstructionParseRequest transaction(String transaction) {
    this.transaction = transaction;
    return this;
  }

  
  @Schema(required = true, description = "This must be either the unsigned transaction blob returned by `/construction/payloads` or the signed transaction blob returned by `/construction/combine`. ")
  @JsonProperty("transaction")
  public String getTransaction() {
    return transaction;
  }
  public void setTransaction(String transaction) {
    this.transaction = transaction;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ConstructionParseRequest constructionParseRequest = (ConstructionParseRequest) o;
    return Objects.equals(networkIdentifier, constructionParseRequest.networkIdentifier) &&
        Objects.equals(signed, constructionParseRequest.signed) &&
        Objects.equals(transaction, constructionParseRequest.transaction);
  }

  @Override
  public int hashCode() {
    return Objects.hash(networkIdentifier, signed, transaction);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ConstructionParseRequest {\n");
    sb.append("    networkIdentifier: ").append(toIndentedString(networkIdentifier)).append("\n");
    sb.append("    signed: ").append(toIndentedString(signed)).append("\n");
    sb.append("    transaction: ").append(toIndentedString(transaction)).append("\n");
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
