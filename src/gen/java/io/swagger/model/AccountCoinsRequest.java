package io.swagger.model;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.model.AccountIdentifier;
import io.swagger.model.Currency;
import io.swagger.model.NetworkIdentifier;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;


/**
 * AccountCoinsRequest is utilized to make a request on the /account/coins endpoint.
 **/
@Schema(description = "AccountCoinsRequest is utilized to make a request on the /account/coins endpoint.")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaInflectorServerCodegen", date = "2020-11-12T07:15:46.859Z[GMT]")
public class AccountCoinsRequest   {
  @JsonProperty("network_identifier")
  private NetworkIdentifier networkIdentifier = null;
  @JsonProperty("account_identifier")
  private AccountIdentifier accountIdentifier = null;
  @JsonProperty("include_mempool")
  private Boolean includeMempool = null;
  @JsonProperty("currencies")
  private List<Currency> currencies = null;
  /**
   **/
  public AccountCoinsRequest networkIdentifier(NetworkIdentifier networkIdentifier) {
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
  public AccountCoinsRequest accountIdentifier(AccountIdentifier accountIdentifier) {
    this.accountIdentifier = accountIdentifier;
    return this;
  }

  
  @Schema(required = true, description = "")
  @JsonProperty("account_identifier")
  public AccountIdentifier getAccountIdentifier() {
    return accountIdentifier;
  }
  public void setAccountIdentifier(AccountIdentifier accountIdentifier) {
    this.accountIdentifier = accountIdentifier;
  }

  /**
   * Include state from the mempool when looking up an account's unspent coins. Note, using this functionality breaks any guarantee of idempotency.
   **/
  public AccountCoinsRequest includeMempool(Boolean includeMempool) {
    this.includeMempool = includeMempool;
    return this;
  }

  
  @Schema(required = true, description = "Include state from the mempool when looking up an account's unspent coins. Note, using this functionality breaks any guarantee of idempotency.")
  @JsonProperty("include_mempool")
  public Boolean isIncludeMempool() {
    return includeMempool;
  }
  public void setIncludeMempool(Boolean includeMempool) {
    this.includeMempool = includeMempool;
  }

  /**
   * In some cases, the caller may not want to retrieve coins for all currencies for an AccountIdentifier. If the currencies field is populated, only coins for the specified currencies will be returned. If not populated, all unspent coins will be returned.
   **/
  public AccountCoinsRequest currencies(List<Currency> currencies) {
    this.currencies = currencies;
    return this;
  }

  
  @Schema(description = "In some cases, the caller may not want to retrieve coins for all currencies for an AccountIdentifier. If the currencies field is populated, only coins for the specified currencies will be returned. If not populated, all unspent coins will be returned.")
  @JsonProperty("currencies")
  public List<Currency> getCurrencies() {
    return currencies;
  }
  public void setCurrencies(List<Currency> currencies) {
    this.currencies = currencies;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AccountCoinsRequest accountCoinsRequest = (AccountCoinsRequest) o;
    return Objects.equals(networkIdentifier, accountCoinsRequest.networkIdentifier) &&
        Objects.equals(accountIdentifier, accountCoinsRequest.accountIdentifier) &&
        Objects.equals(includeMempool, accountCoinsRequest.includeMempool) &&
        Objects.equals(currencies, accountCoinsRequest.currencies);
  }

  @Override
  public int hashCode() {
    return Objects.hash(networkIdentifier, accountIdentifier, includeMempool, currencies);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AccountCoinsRequest {\n");
    sb.append("    networkIdentifier: ").append(toIndentedString(networkIdentifier)).append("\n");
    sb.append("    accountIdentifier: ").append(toIndentedString(accountIdentifier)).append("\n");
    sb.append("    includeMempool: ").append(toIndentedString(includeMempool)).append("\n");
    sb.append("    currencies: ").append(toIndentedString(currencies)).append("\n");
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
