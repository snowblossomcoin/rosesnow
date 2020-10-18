package io.swagger.model;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.model.AccountIdentifier;
import io.swagger.model.Amount;
import io.swagger.model.CoinChange;
import io.swagger.model.OperationIdentifier;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;


/**
 * Operations contain all balance-changing information within a transaction. They are always one-sided (only affect 1 AccountIdentifier) and can succeed or fail independently from a Transaction.
 **/
@Schema(description = "Operations contain all balance-changing information within a transaction. They are always one-sided (only affect 1 AccountIdentifier) and can succeed or fail independently from a Transaction.")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaInflectorServerCodegen", date = "2020-10-18T05:48:04.106Z[GMT]")
public class Operation   {
  @JsonProperty("operation_identifier")
  private OperationIdentifier operationIdentifier = null;
  @JsonProperty("related_operations")
  private List<OperationIdentifier> relatedOperations = null;
  @JsonProperty("type")
  private String type = null;
  @JsonProperty("status")
  private String status = null;
  @JsonProperty("account")
  private AccountIdentifier account = null;
  @JsonProperty("amount")
  private Amount amount = null;
  @JsonProperty("coin_change")
  private CoinChange coinChange = null;
  @JsonProperty("metadata")
  private Object metadata = null;
  /**
   **/
  public Operation operationIdentifier(OperationIdentifier operationIdentifier) {
    this.operationIdentifier = operationIdentifier;
    return this;
  }

  
  @Schema(required = true, description = "")
  @JsonProperty("operation_identifier")
  public OperationIdentifier getOperationIdentifier() {
    return operationIdentifier;
  }
  public void setOperationIdentifier(OperationIdentifier operationIdentifier) {
    this.operationIdentifier = operationIdentifier;
  }

  /**
   * Restrict referenced related_operations to identifier indexes < the current operation_identifier.index. This ensures there exists a clear DAG-structure of relations. Since operations are one-sided, one could imagine relating operations in a single transfer or linking operations in a call tree.
   **/
  public Operation relatedOperations(List<OperationIdentifier> relatedOperations) {
    this.relatedOperations = relatedOperations;
    return this;
  }

  
  @Schema(example = "[{\"index\":1},{\"index\":2}]", description = "Restrict referenced related_operations to identifier indexes < the current operation_identifier.index. This ensures there exists a clear DAG-structure of relations. Since operations are one-sided, one could imagine relating operations in a single transfer or linking operations in a call tree.")
  @JsonProperty("related_operations")
  public List<OperationIdentifier> getRelatedOperations() {
    return relatedOperations;
  }
  public void setRelatedOperations(List<OperationIdentifier> relatedOperations) {
    this.relatedOperations = relatedOperations;
  }

  /**
   * The network-specific type of the operation. Ensure that any type that can be returned here is also specified in the NetworkOptionsResponse. This can be very useful to downstream consumers that parse all block data.
   **/
  public Operation type(String type) {
    this.type = type;
    return this;
  }

  
  @Schema(example = "Transfer", required = true, description = "The network-specific type of the operation. Ensure that any type that can be returned here is also specified in the NetworkOptionsResponse. This can be very useful to downstream consumers that parse all block data.")
  @JsonProperty("type")
  public String getType() {
    return type;
  }
  public void setType(String type) {
    this.type = type;
  }

  /**
   * The network-specific status of the operation. Status is not defined on the transaction object because blockchains with smart contracts may have transactions that partially apply. Blockchains with atomic transactions (all operations succeed or all operations fail) will have the same status for each operation.
   **/
  public Operation status(String status) {
    this.status = status;
    return this;
  }

  
  @Schema(example = "Reverted", required = true, description = "The network-specific status of the operation. Status is not defined on the transaction object because blockchains with smart contracts may have transactions that partially apply. Blockchains with atomic transactions (all operations succeed or all operations fail) will have the same status for each operation.")
  @JsonProperty("status")
  public String getStatus() {
    return status;
  }
  public void setStatus(String status) {
    this.status = status;
  }

  /**
   **/
  public Operation account(AccountIdentifier account) {
    this.account = account;
    return this;
  }

  
  @Schema(description = "")
  @JsonProperty("account")
  public AccountIdentifier getAccount() {
    return account;
  }
  public void setAccount(AccountIdentifier account) {
    this.account = account;
  }

  /**
   **/
  public Operation amount(Amount amount) {
    this.amount = amount;
    return this;
  }

  
  @Schema(description = "")
  @JsonProperty("amount")
  public Amount getAmount() {
    return amount;
  }
  public void setAmount(Amount amount) {
    this.amount = amount;
  }

  /**
   **/
  public Operation coinChange(CoinChange coinChange) {
    this.coinChange = coinChange;
    return this;
  }

  
  @Schema(description = "")
  @JsonProperty("coin_change")
  public CoinChange getCoinChange() {
    return coinChange;
  }
  public void setCoinChange(CoinChange coinChange) {
    this.coinChange = coinChange;
  }

  /**
   **/
  public Operation metadata(Object metadata) {
    this.metadata = metadata;
    return this;
  }

  
  @Schema(example = "{\"asm\":\"304502201fd8abb11443f8b1b9a04e0495e0543d05611473a790c8939f089d073f90509a022100f4677825136605d732e2126d09a2d38c20c75946cd9fc239c0497e84c634e3dd01 03301a8259a12e35694cc22ebc45fee635f4993064190f6ce96e7fb19a03bb6be2\",\"hex\":\"48304502201fd8abb11443f8b1b9a04e0495e0543d05611473a790c8939f089d073f90509a022100f4677825136605d732e2126d09a2d38c20c75946cd9fc239c0497e84c634e3dd012103301a8259a12e35694cc22ebc45fee635f4993064190f6ce96e7fb19a03bb6be2\"}", description = "")
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
    Operation operation = (Operation) o;
    return Objects.equals(operationIdentifier, operation.operationIdentifier) &&
        Objects.equals(relatedOperations, operation.relatedOperations) &&
        Objects.equals(type, operation.type) &&
        Objects.equals(status, operation.status) &&
        Objects.equals(account, operation.account) &&
        Objects.equals(amount, operation.amount) &&
        Objects.equals(coinChange, operation.coinChange) &&
        Objects.equals(metadata, operation.metadata);
  }

  @Override
  public int hashCode() {
    return Objects.hash(operationIdentifier, relatedOperations, type, status, account, amount, coinChange, metadata);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Operation {\n");
    sb.append("    operationIdentifier: ").append(toIndentedString(operationIdentifier)).append("\n");
    sb.append("    relatedOperations: ").append(toIndentedString(relatedOperations)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    account: ").append(toIndentedString(account)).append("\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    coinChange: ").append(toIndentedString(coinChange)).append("\n");
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
