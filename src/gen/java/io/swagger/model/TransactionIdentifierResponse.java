package io.swagger.model;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.model.TransactionIdentifier;
import io.swagger.v3.oas.annotations.media.Schema;


/**
 * TransactionIdentifierResponse contains the transaction_identifier of a transaction that was submitted to either &#x60;/construction/hash&#x60; or &#x60;/construction/submit&#x60;. 
 **/
@Schema(description = "TransactionIdentifierResponse contains the transaction_identifier of a transaction that was submitted to either `/construction/hash` or `/construction/submit`. ")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaInflectorServerCodegen", date = "2020-10-15T17:54:45.833Z[GMT]")
public class TransactionIdentifierResponse   {
  @JsonProperty("transaction_identifier")
  private TransactionIdentifier transactionIdentifier = null;
  @JsonProperty("metadata")
  private Object metadata = null;
  /**
   **/
  public TransactionIdentifierResponse transactionIdentifier(TransactionIdentifier transactionIdentifier) {
    this.transactionIdentifier = transactionIdentifier;
    return this;
  }

  
  @Schema(required = true, description = "")
  @JsonProperty("transaction_identifier")
  public TransactionIdentifier getTransactionIdentifier() {
    return transactionIdentifier;
  }
  public void setTransactionIdentifier(TransactionIdentifier transactionIdentifier) {
    this.transactionIdentifier = transactionIdentifier;
  }

  /**
   **/
  public TransactionIdentifierResponse metadata(Object metadata) {
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
    TransactionIdentifierResponse transactionIdentifierResponse = (TransactionIdentifierResponse) o;
    return Objects.equals(transactionIdentifier, transactionIdentifierResponse.transactionIdentifier) &&
        Objects.equals(metadata, transactionIdentifierResponse.metadata);
  }

  @Override
  public int hashCode() {
    return Objects.hash(transactionIdentifier, metadata);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TransactionIdentifierResponse {\n");
    sb.append("    transactionIdentifier: ").append(toIndentedString(transactionIdentifier)).append("\n");
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
