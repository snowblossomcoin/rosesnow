package io.swagger.model;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.model.Operation;
import io.swagger.model.TransactionIdentifier;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;


/**
 * Transactions contain an array of Operations that are attributable to the same TransactionIdentifier.
 **/
@Schema(description = "Transactions contain an array of Operations that are attributable to the same TransactionIdentifier.")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaInflectorServerCodegen", date = "2020-11-12T07:15:46.859Z[GMT]")
public class Transaction   {
  @JsonProperty("transaction_identifier")
  private TransactionIdentifier transactionIdentifier = null;
  @JsonProperty("operations")
  private List<Operation> operations = new ArrayList<Operation>();
  @JsonProperty("metadata")
  private Object metadata = null;
  /**
   **/
  public Transaction transactionIdentifier(TransactionIdentifier transactionIdentifier) {
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
  public Transaction operations(List<Operation> operations) {
    this.operations = operations;
    return this;
  }

  
  @Schema(required = true, description = "")
  @JsonProperty("operations")
  public List<Operation> getOperations() {
    return operations;
  }
  public void setOperations(List<Operation> operations) {
    this.operations = operations;
  }

  /**
   * Transactions that are related to other transactions (like a cross-shard transaction) should include the tranaction_identifier of these transactions in the metadata.
   **/
  public Transaction metadata(Object metadata) {
    this.metadata = metadata;
    return this;
  }

  
  @Schema(example = "{\"size\":12378,\"lockTime\":1582272577}", description = "Transactions that are related to other transactions (like a cross-shard transaction) should include the tranaction_identifier of these transactions in the metadata.")
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
    Transaction transaction = (Transaction) o;
    return Objects.equals(transactionIdentifier, transaction.transactionIdentifier) &&
        Objects.equals(operations, transaction.operations) &&
        Objects.equals(metadata, transaction.metadata);
  }

  @Override
  public int hashCode() {
    return Objects.hash(transactionIdentifier, operations, metadata);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Transaction {\n");
    sb.append("    transactionIdentifier: ").append(toIndentedString(transactionIdentifier)).append("\n");
    sb.append("    operations: ").append(toIndentedString(operations)).append("\n");
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
