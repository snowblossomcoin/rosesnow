package io.swagger.model;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.model.BalanceExemption;
import io.swagger.model.Error;
import io.swagger.model.OperationStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;


/**
 * Allow specifies supported Operation status, Operation types, and all possible error statuses. This Allow object is used by clients to validate the correctness of a Rosetta Server implementation. It is expected that these clients will error if they receive some response that contains any of the above information that is not specified here.
 **/
@Schema(description = "Allow specifies supported Operation status, Operation types, and all possible error statuses. This Allow object is used by clients to validate the correctness of a Rosetta Server implementation. It is expected that these clients will error if they receive some response that contains any of the above information that is not specified here.")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaInflectorServerCodegen", date = "2020-11-12T07:15:46.859Z[GMT]")
public class Allow   {
  @JsonProperty("operation_statuses")
  private List<OperationStatus> operationStatuses = new ArrayList<OperationStatus>();
  @JsonProperty("operation_types")
  private List<String> operationTypes = new ArrayList<String>();
  @JsonProperty("errors")
  private List<Error> errors = new ArrayList<Error>();
  @JsonProperty("historical_balance_lookup")
  private Boolean historicalBalanceLookup = null;
  @JsonProperty("timestamp_start_index")
  private Long timestampStartIndex = null;
  @JsonProperty("call_methods")
  private List<String> callMethods = new ArrayList<String>();
  @JsonProperty("balance_exemptions")
  private List<BalanceExemption> balanceExemptions = new ArrayList<BalanceExemption>();
  @JsonProperty("mempool_coins")
  private Boolean mempoolCoins = null;
  /**
   * All Operation.Status this implementation supports. Any status that is returned during parsing that is not listed here will cause client validation to error.
   **/
  public Allow operationStatuses(List<OperationStatus> operationStatuses) {
    this.operationStatuses = operationStatuses;
    return this;
  }

  
  @Schema(required = true, description = "All Operation.Status this implementation supports. Any status that is returned during parsing that is not listed here will cause client validation to error.")
  @JsonProperty("operation_statuses")
  public List<OperationStatus> getOperationStatuses() {
    return operationStatuses;
  }
  public void setOperationStatuses(List<OperationStatus> operationStatuses) {
    this.operationStatuses = operationStatuses;
  }

  /**
   * All Operation.Type this implementation supports. Any type that is returned during parsing that is not listed here will cause client validation to error.
   **/
  public Allow operationTypes(List<String> operationTypes) {
    this.operationTypes = operationTypes;
    return this;
  }

  
  @Schema(required = true, description = "All Operation.Type this implementation supports. Any type that is returned during parsing that is not listed here will cause client validation to error.")
  @JsonProperty("operation_types")
  public List<String> getOperationTypes() {
    return operationTypes;
  }
  public void setOperationTypes(List<String> operationTypes) {
    this.operationTypes = operationTypes;
  }

  /**
   * All Errors that this implementation could return. Any error that is returned during parsing that is not listed here will cause client validation to error.
   **/
  public Allow errors(List<Error> errors) {
    this.errors = errors;
    return this;
  }

  
  @Schema(required = true, description = "All Errors that this implementation could return. Any error that is returned during parsing that is not listed here will cause client validation to error.")
  @JsonProperty("errors")
  public List<Error> getErrors() {
    return errors;
  }
  public void setErrors(List<Error> errors) {
    this.errors = errors;
  }

  /**
   * Any Rosetta implementation that supports querying the balance of an account at any height in the past should set this to true.
   **/
  public Allow historicalBalanceLookup(Boolean historicalBalanceLookup) {
    this.historicalBalanceLookup = historicalBalanceLookup;
    return this;
  }

  
  @Schema(required = true, description = "Any Rosetta implementation that supports querying the balance of an account at any height in the past should set this to true.")
  @JsonProperty("historical_balance_lookup")
  public Boolean isHistoricalBalanceLookup() {
    return historicalBalanceLookup;
  }
  public void setHistoricalBalanceLookup(Boolean historicalBalanceLookup) {
    this.historicalBalanceLookup = historicalBalanceLookup;
  }

  /**
   * If populated, `timestamp_start_index` indicates the first block index where block timestamps are considered valid (i.e. all blocks less than `timestamp_start_index` could have invalid timestamps). This is useful when the genesis block (or blocks) of a network have timestamp 0. If not populated, block timestamps are assumed to be valid for all available blocks.
   * minimum: 0
   **/
  public Allow timestampStartIndex(Long timestampStartIndex) {
    this.timestampStartIndex = timestampStartIndex;
    return this;
  }

  
  @Schema(description = "If populated, `timestamp_start_index` indicates the first block index where block timestamps are considered valid (i.e. all blocks less than `timestamp_start_index` could have invalid timestamps). This is useful when the genesis block (or blocks) of a network have timestamp 0. If not populated, block timestamps are assumed to be valid for all available blocks.")
  @JsonProperty("timestamp_start_index")
  public Long getTimestampStartIndex() {
    return timestampStartIndex;
  }
  public void setTimestampStartIndex(Long timestampStartIndex) {
    this.timestampStartIndex = timestampStartIndex;
  }

  /**
   * All methods that are supported by the /call endpoint. Communicating which parameters should be provided to /call is the responsibility of the implementer (this is en lieu of defining an entire type system and requiring the implementer to define that in Allow).
   **/
  public Allow callMethods(List<String> callMethods) {
    this.callMethods = callMethods;
    return this;
  }

  
  @Schema(required = true, description = "All methods that are supported by the /call endpoint. Communicating which parameters should be provided to /call is the responsibility of the implementer (this is en lieu of defining an entire type system and requiring the implementer to define that in Allow).")
  @JsonProperty("call_methods")
  public List<String> getCallMethods() {
    return callMethods;
  }
  public void setCallMethods(List<String> callMethods) {
    this.callMethods = callMethods;
  }

  /**
   * BalanceExemptions is an array of BalanceExemption indicating which account balances could change without a corresponding Operation. BalanceExemptions should be used sparingly as they may introduce significant complexity for integrators that attempt to reconcile all account balance changes. If your implementation relies on any BalanceExemptions, you MUST implement historical balance lookup (the ability to query an account balance at any BlockIdentifier).
   **/
  public Allow balanceExemptions(List<BalanceExemption> balanceExemptions) {
    this.balanceExemptions = balanceExemptions;
    return this;
  }

  
  @Schema(required = true, description = "BalanceExemptions is an array of BalanceExemption indicating which account balances could change without a corresponding Operation. BalanceExemptions should be used sparingly as they may introduce significant complexity for integrators that attempt to reconcile all account balance changes. If your implementation relies on any BalanceExemptions, you MUST implement historical balance lookup (the ability to query an account balance at any BlockIdentifier).")
  @JsonProperty("balance_exemptions")
  public List<BalanceExemption> getBalanceExemptions() {
    return balanceExemptions;
  }
  public void setBalanceExemptions(List<BalanceExemption> balanceExemptions) {
    this.balanceExemptions = balanceExemptions;
  }

  /**
   * Any Rosetta implementation that can update an AccountIdentifier's unspent coins based on the contents of the mempool should populate this field as true. If false, requests to `/account/coins` that set `include_mempool` as true will be automatically rejected.
   **/
  public Allow mempoolCoins(Boolean mempoolCoins) {
    this.mempoolCoins = mempoolCoins;
    return this;
  }

  
  @Schema(required = true, description = "Any Rosetta implementation that can update an AccountIdentifier's unspent coins based on the contents of the mempool should populate this field as true. If false, requests to `/account/coins` that set `include_mempool` as true will be automatically rejected.")
  @JsonProperty("mempool_coins")
  public Boolean isMempoolCoins() {
    return mempoolCoins;
  }
  public void setMempoolCoins(Boolean mempoolCoins) {
    this.mempoolCoins = mempoolCoins;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Allow allow = (Allow) o;
    return Objects.equals(operationStatuses, allow.operationStatuses) &&
        Objects.equals(operationTypes, allow.operationTypes) &&
        Objects.equals(errors, allow.errors) &&
        Objects.equals(historicalBalanceLookup, allow.historicalBalanceLookup) &&
        Objects.equals(timestampStartIndex, allow.timestampStartIndex) &&
        Objects.equals(callMethods, allow.callMethods) &&
        Objects.equals(balanceExemptions, allow.balanceExemptions) &&
        Objects.equals(mempoolCoins, allow.mempoolCoins);
  }

  @Override
  public int hashCode() {
    return Objects.hash(operationStatuses, operationTypes, errors, historicalBalanceLookup, timestampStartIndex, callMethods, balanceExemptions, mempoolCoins);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Allow {\n");
    sb.append("    operationStatuses: ").append(toIndentedString(operationStatuses)).append("\n");
    sb.append("    operationTypes: ").append(toIndentedString(operationTypes)).append("\n");
    sb.append("    errors: ").append(toIndentedString(errors)).append("\n");
    sb.append("    historicalBalanceLookup: ").append(toIndentedString(historicalBalanceLookup)).append("\n");
    sb.append("    timestampStartIndex: ").append(toIndentedString(timestampStartIndex)).append("\n");
    sb.append("    callMethods: ").append(toIndentedString(callMethods)).append("\n");
    sb.append("    balanceExemptions: ").append(toIndentedString(balanceExemptions)).append("\n");
    sb.append("    mempoolCoins: ").append(toIndentedString(mempoolCoins)).append("\n");
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
