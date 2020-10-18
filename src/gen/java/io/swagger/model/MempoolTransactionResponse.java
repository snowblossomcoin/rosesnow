package io.swagger.model;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.model.Transaction;
import io.swagger.v3.oas.annotations.media.Schema;


/**
 * A MempoolTransactionResponse contains an estimate of a mempool transaction. It may not be possible to know the full impact of a transaction in the mempool (ex: fee paid).
 **/
@Schema(description = "A MempoolTransactionResponse contains an estimate of a mempool transaction. It may not be possible to know the full impact of a transaction in the mempool (ex: fee paid).")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaInflectorServerCodegen", date = "2020-10-18T05:48:04.106Z[GMT]")
public class MempoolTransactionResponse   {
  @JsonProperty("transaction")
  private Transaction transaction = null;
  @JsonProperty("metadata")
  private Object metadata = null;
  /**
   **/
  public MempoolTransactionResponse transaction(Transaction transaction) {
    this.transaction = transaction;
    return this;
  }

  
  @Schema(required = true, description = "")
  @JsonProperty("transaction")
  public Transaction getTransaction() {
    return transaction;
  }
  public void setTransaction(Transaction transaction) {
    this.transaction = transaction;
  }

  /**
   **/
  public MempoolTransactionResponse metadata(Object metadata) {
    this.metadata = metadata;
    return this;
  }

  
  @Schema(example = "{\"descendant_fees\":123923,\"ancestor_count\":2}", description = "")
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
    MempoolTransactionResponse mempoolTransactionResponse = (MempoolTransactionResponse) o;
    return Objects.equals(transaction, mempoolTransactionResponse.transaction) &&
        Objects.equals(metadata, mempoolTransactionResponse.metadata);
  }

  @Override
  public int hashCode() {
    return Objects.hash(transaction, metadata);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MempoolTransactionResponse {\n");
    sb.append("    transaction: ").append(toIndentedString(transaction)).append("\n");
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
