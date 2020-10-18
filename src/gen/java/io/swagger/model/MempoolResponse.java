package io.swagger.model;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.model.TransactionIdentifier;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;


/**
 * A MempoolResponse contains all transaction identifiers in the mempool for a particular network_identifier.
 **/
@Schema(description = "A MempoolResponse contains all transaction identifiers in the mempool for a particular network_identifier.")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaInflectorServerCodegen", date = "2020-10-18T05:48:04.106Z[GMT]")
public class MempoolResponse   {
  @JsonProperty("transaction_identifiers")
  private List<TransactionIdentifier> transactionIdentifiers = new ArrayList<>();
  /**
   **/
  public MempoolResponse transactionIdentifiers(List<TransactionIdentifier> transactionIdentifiers) {
    this.transactionIdentifiers = transactionIdentifiers;
    return this;
  }

  
  @Schema(required = true, description = "")
  @JsonProperty("transaction_identifiers")
  public List<TransactionIdentifier> getTransactionIdentifiers() {
    return transactionIdentifiers;
  }
  public void setTransactionIdentifiers(List<TransactionIdentifier> transactionIdentifiers) {
    this.transactionIdentifiers = transactionIdentifiers;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MempoolResponse mempoolResponse = (MempoolResponse) o;
    return Objects.equals(transactionIdentifiers, mempoolResponse.transactionIdentifiers);
  }

  @Override
  public int hashCode() {
    return Objects.hash(transactionIdentifiers);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MempoolResponse {\n");
    sb.append("    transactionIdentifiers: ").append(toIndentedString(transactionIdentifiers)).append("\n");
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
