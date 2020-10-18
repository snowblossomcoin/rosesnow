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
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaInflectorServerCodegen", date = "2020-10-18T05:48:04.106Z[GMT]")
public class Allow   {
  @JsonProperty("operation_statuses")
  private List<OperationStatus> operationStatuses = new ArrayList<>();
  @JsonProperty("operation_types")
  private List<String> operationTypes = new ArrayList<>();
  @JsonProperty("errors")
  private List<Error> errors = new ArrayList<>();
  @JsonProperty("historical_balance_lookup")
  private Boolean historicalBalanceLookup = null;
  @JsonProperty("call_methods")
  private List<String> callMethods = new ArrayList<>();
  @JsonProperty("balance_exemptions")
  private List<BalanceExemption> balanceExemptions = new ArrayList<>();
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
        Objects.equals(callMethods, allow.callMethods) &&
        Objects.equals(balanceExemptions, allow.balanceExemptions);
  }

  @Override
  public int hashCode() {
    return Objects.hash(operationStatuses, operationTypes, errors, historicalBalanceLookup, callMethods, balanceExemptions);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Allow {\n");
    sb.append("    operationStatuses: ").append(toIndentedString(operationStatuses)).append("\n");
    sb.append("    operationTypes: ").append(toIndentedString(operationTypes)).append("\n");
    sb.append("    errors: ").append(toIndentedString(errors)).append("\n");
    sb.append("    historicalBalanceLookup: ").append(toIndentedString(historicalBalanceLookup)).append("\n");
    sb.append("    callMethods: ").append(toIndentedString(callMethods)).append("\n");
    sb.append("    balanceExemptions: ").append(toIndentedString(balanceExemptions)).append("\n");
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
