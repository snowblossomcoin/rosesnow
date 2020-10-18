package io.swagger.model;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.model.NetworkIdentifier;
import io.swagger.model.Signature;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;


/**
 * ConstructionCombineRequest is the input to the &#x60;/construction/combine&#x60; endpoint. It contains the unsigned transaction blob returned by &#x60;/construction/payloads&#x60; and all required signatures to create a network transaction. 
 **/
@Schema(description = "ConstructionCombineRequest is the input to the `/construction/combine` endpoint. It contains the unsigned transaction blob returned by `/construction/payloads` and all required signatures to create a network transaction. ")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaInflectorServerCodegen", date = "2020-10-15T17:54:45.833Z[GMT]")
public class ConstructionCombineRequest   {
  @JsonProperty("network_identifier")
  private NetworkIdentifier networkIdentifier = null;
  @JsonProperty("unsigned_transaction")
  private String unsignedTransaction = null;
  @JsonProperty("signatures")
  private List<Signature> signatures = new ArrayList<>();
  /**
   **/
  public ConstructionCombineRequest networkIdentifier(NetworkIdentifier networkIdentifier) {
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
  public ConstructionCombineRequest unsignedTransaction(String unsignedTransaction) {
    this.unsignedTransaction = unsignedTransaction;
    return this;
  }

  
  @Schema(required = true, description = "")
  @JsonProperty("unsigned_transaction")
  public String getUnsignedTransaction() {
    return unsignedTransaction;
  }
  public void setUnsignedTransaction(String unsignedTransaction) {
    this.unsignedTransaction = unsignedTransaction;
  }

  /**
   **/
  public ConstructionCombineRequest signatures(List<Signature> signatures) {
    this.signatures = signatures;
    return this;
  }

  
  @Schema(required = true, description = "")
  @JsonProperty("signatures")
  public List<Signature> getSignatures() {
    return signatures;
  }
  public void setSignatures(List<Signature> signatures) {
    this.signatures = signatures;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ConstructionCombineRequest constructionCombineRequest = (ConstructionCombineRequest) o;
    return Objects.equals(networkIdentifier, constructionCombineRequest.networkIdentifier) &&
        Objects.equals(unsignedTransaction, constructionCombineRequest.unsignedTransaction) &&
        Objects.equals(signatures, constructionCombineRequest.signatures);
  }

  @Override
  public int hashCode() {
    return Objects.hash(networkIdentifier, unsignedTransaction, signatures);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ConstructionCombineRequest {\n");
    sb.append("    networkIdentifier: ").append(toIndentedString(networkIdentifier)).append("\n");
    sb.append("    unsignedTransaction: ").append(toIndentedString(unsignedTransaction)).append("\n");
    sb.append("    signatures: ").append(toIndentedString(signatures)).append("\n");
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
