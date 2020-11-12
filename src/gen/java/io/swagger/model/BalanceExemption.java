package io.swagger.model;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.model.Currency;
import io.swagger.model.ExemptionType;
import io.swagger.v3.oas.annotations.media.Schema;


/**
 * BalanceExemption indicates that the balance for an exempt account could change without a corresponding Operation. This typically occurs with staking rewards, vesting balances, and Currencies with a dynamic supply. Currently, it is possible to exempt an account from strict reconciliation by SubAccountIdentifier.Address or by Currency. This means that any account with SubAccountIdentifier.Address would be exempt or any balance of a particular Currency would be exempt, respectively. BalanceExemptions should be used sparingly as they may introduce significant complexity for integrators that attempt to reconcile all account balance changes. If your implementation relies on any BalanceExemptions, you MUST implement historical balance lookup (the ability to query an account balance at any BlockIdentifier).
 **/
@Schema(description = "BalanceExemption indicates that the balance for an exempt account could change without a corresponding Operation. This typically occurs with staking rewards, vesting balances, and Currencies with a dynamic supply. Currently, it is possible to exempt an account from strict reconciliation by SubAccountIdentifier.Address or by Currency. This means that any account with SubAccountIdentifier.Address would be exempt or any balance of a particular Currency would be exempt, respectively. BalanceExemptions should be used sparingly as they may introduce significant complexity for integrators that attempt to reconcile all account balance changes. If your implementation relies on any BalanceExemptions, you MUST implement historical balance lookup (the ability to query an account balance at any BlockIdentifier).")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaInflectorServerCodegen", date = "2020-11-12T07:15:46.859Z[GMT]")
public class BalanceExemption   {
  @JsonProperty("sub_account_address")
  private String subAccountAddress = null;
  @JsonProperty("currency")
  private Currency currency = null;
  @JsonProperty("exemption_type")
  private ExemptionType exemptionType = null;
  /**
   * SubAccountAddress is the SubAccountIdentifier.Address that the BalanceExemption applies to (regardless of the value of SubAccountIdentifier.Metadata).
   **/
  public BalanceExemption subAccountAddress(String subAccountAddress) {
    this.subAccountAddress = subAccountAddress;
    return this;
  }

  
  @Schema(example = "staking", description = "SubAccountAddress is the SubAccountIdentifier.Address that the BalanceExemption applies to (regardless of the value of SubAccountIdentifier.Metadata).")
  @JsonProperty("sub_account_address")
  public String getSubAccountAddress() {
    return subAccountAddress;
  }
  public void setSubAccountAddress(String subAccountAddress) {
    this.subAccountAddress = subAccountAddress;
  }

  /**
   **/
  public BalanceExemption currency(Currency currency) {
    this.currency = currency;
    return this;
  }

  
  @Schema(description = "")
  @JsonProperty("currency")
  public Currency getCurrency() {
    return currency;
  }
  public void setCurrency(Currency currency) {
    this.currency = currency;
  }

  /**
   **/
  public BalanceExemption exemptionType(ExemptionType exemptionType) {
    this.exemptionType = exemptionType;
    return this;
  }

  
  @Schema(description = "")
  @JsonProperty("exemption_type")
  public ExemptionType getExemptionType() {
    return exemptionType;
  }
  public void setExemptionType(ExemptionType exemptionType) {
    this.exemptionType = exemptionType;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BalanceExemption balanceExemption = (BalanceExemption) o;
    return Objects.equals(subAccountAddress, balanceExemption.subAccountAddress) &&
        Objects.equals(currency, balanceExemption.currency) &&
        Objects.equals(exemptionType, balanceExemption.exemptionType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(subAccountAddress, currency, exemptionType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BalanceExemption {\n");
    sb.append("    subAccountAddress: ").append(toIndentedString(subAccountAddress)).append("\n");
    sb.append("    currency: ").append(toIndentedString(currency)).append("\n");
    sb.append("    exemptionType: ").append(toIndentedString(exemptionType)).append("\n");
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
