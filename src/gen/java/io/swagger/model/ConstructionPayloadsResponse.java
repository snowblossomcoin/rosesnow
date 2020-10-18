package io.swagger.model;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.model.SigningPayload;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;


/**
 * ConstructionTransactionResponse is returned by &#x60;/construction/payloads&#x60;. It contains an unsigned transaction blob (that is usually needed to construct the a network transaction from a collection of signatures) and an array of payloads that must be signed by the caller.
 **/
@Schema(description = "ConstructionTransactionResponse is returned by `/construction/payloads`. It contains an unsigned transaction blob (that is usually needed to construct the a network transaction from a collection of signatures) and an array of payloads that must be signed by the caller.")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaInflectorServerCodegen", date = "2020-10-18T05:48:04.106Z[GMT]")
public class ConstructionPayloadsResponse   {
  @JsonProperty("unsigned_transaction")
  private String unsignedTransaction = null;
  @JsonProperty("payloads")
  private List<SigningPayload> payloads = new ArrayList<>();
  /**
   **/
  public ConstructionPayloadsResponse unsignedTransaction(String unsignedTransaction) {
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
  public ConstructionPayloadsResponse payloads(List<SigningPayload> payloads) {
    this.payloads = payloads;
    return this;
  }

  
  @Schema(required = true, description = "")
  @JsonProperty("payloads")
  public List<SigningPayload> getPayloads() {
    return payloads;
  }
  public void setPayloads(List<SigningPayload> payloads) {
    this.payloads = payloads;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ConstructionPayloadsResponse constructionPayloadsResponse = (ConstructionPayloadsResponse) o;
    return Objects.equals(unsignedTransaction, constructionPayloadsResponse.unsignedTransaction) &&
        Objects.equals(payloads, constructionPayloadsResponse.payloads);
  }

  @Override
  public int hashCode() {
    return Objects.hash(unsignedTransaction, payloads);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ConstructionPayloadsResponse {\n");
    sb.append("    unsignedTransaction: ").append(toIndentedString(unsignedTransaction)).append("\n");
    sb.append("    payloads: ").append(toIndentedString(payloads)).append("\n");
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
