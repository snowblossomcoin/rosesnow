package io.swagger.model;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.model.NetworkIdentifier;
import io.swagger.model.TransactionIdentifier;
import io.swagger.v3.oas.annotations.media.Schema;


/**
 * A MempoolTransactionRequest is utilized to retrieve a transaction from the mempool.
 **/
@Schema(description = "A MempoolTransactionRequest is utilized to retrieve a transaction from the mempool.")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaInflectorServerCodegen", date = "2020-11-12T07:15:46.859Z[GMT]")
public class MempoolTransactionRequest   {
  @JsonProperty("network_identifier")
  private NetworkIdentifier networkIdentifier = null;
  @JsonProperty("transaction_identifier")
  private TransactionIdentifier transactionIdentifier = null;
  /**
   **/
  public MempoolTransactionRequest networkIdentifier(NetworkIdentifier networkIdentifier) {
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
  public MempoolTransactionRequest transactionIdentifier(TransactionIdentifier transactionIdentifier) {
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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MempoolTransactionRequest mempoolTransactionRequest = (MempoolTransactionRequest) o;
    return Objects.equals(networkIdentifier, mempoolTransactionRequest.networkIdentifier) &&
        Objects.equals(transactionIdentifier, mempoolTransactionRequest.transactionIdentifier);
  }

  @Override
  public int hashCode() {
    return Objects.hash(networkIdentifier, transactionIdentifier);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MempoolTransactionRequest {\n");
    sb.append("    networkIdentifier: ").append(toIndentedString(networkIdentifier)).append("\n");
    sb.append("    transactionIdentifier: ").append(toIndentedString(transactionIdentifier)).append("\n");
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
