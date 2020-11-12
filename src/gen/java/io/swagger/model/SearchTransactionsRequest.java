package io.swagger.model;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.model.AccountIdentifier;
import io.swagger.model.CoinIdentifier;
import io.swagger.model.Currency;
import io.swagger.model.NetworkIdentifier;
import io.swagger.model.Operator;
import io.swagger.model.TransactionIdentifier;
import io.swagger.v3.oas.annotations.media.Schema;


/**
 * SearchTransactionsRequest is used to search for transactions matching a set of provided conditions in canonical blocks.
 **/
@Schema(description = "SearchTransactionsRequest is used to search for transactions matching a set of provided conditions in canonical blocks.")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaInflectorServerCodegen", date = "2020-11-12T07:15:46.859Z[GMT]")
public class SearchTransactionsRequest   {
  @JsonProperty("network_identifier")
  private NetworkIdentifier networkIdentifier = null;
  @JsonProperty("operator")
  private Operator operator = null;
  @JsonProperty("max_block")
  private Long maxBlock = null;
  @JsonProperty("offset")
  private Long offset = null;
  @JsonProperty("limit")
  private Long limit = null;
  @JsonProperty("transaction_identifier")
  private TransactionIdentifier transactionIdentifier = null;
  @JsonProperty("account_identifier")
  private AccountIdentifier accountIdentifier = null;
  @JsonProperty("coin_identifier")
  private CoinIdentifier coinIdentifier = null;
  @JsonProperty("currency")
  private Currency currency = null;
  @JsonProperty("status")
  private String status = null;
  @JsonProperty("type")
  private String type = null;
  @JsonProperty("address")
  private String address = null;
  @JsonProperty("success")
  private Boolean success = null;
  /**
   **/
  public SearchTransactionsRequest networkIdentifier(NetworkIdentifier networkIdentifier) {
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
  public SearchTransactionsRequest operator(Operator operator) {
    this.operator = operator;
    return this;
  }

  
  @Schema(description = "")
  @JsonProperty("operator")
  public Operator getOperator() {
    return operator;
  }
  public void setOperator(Operator operator) {
    this.operator = operator;
  }

  /**
   * max_block is the largest block index to consider when searching for transactions. If this field is not populated, the current block is considered the max_block. If you do not specify a max_block, it is possible a newly synced block will interfere with paginated transaction queries (as the offset could become invalid with newly added rows).
   * minimum: 0
   **/
  public SearchTransactionsRequest maxBlock(Long maxBlock) {
    this.maxBlock = maxBlock;
    return this;
  }

  
  @Schema(example = "5", description = "max_block is the largest block index to consider when searching for transactions. If this field is not populated, the current block is considered the max_block. If you do not specify a max_block, it is possible a newly synced block will interfere with paginated transaction queries (as the offset could become invalid with newly added rows).")
  @JsonProperty("max_block")
  public Long getMaxBlock() {
    return maxBlock;
  }
  public void setMaxBlock(Long maxBlock) {
    this.maxBlock = maxBlock;
  }

  /**
   * offset is the offset into the query result to start returning transactions. If any search conditions are changed, the query offset will change and you must restart your search iteration.
   * minimum: 0
   **/
  public SearchTransactionsRequest offset(Long offset) {
    this.offset = offset;
    return this;
  }

  
  @Schema(example = "5", description = "offset is the offset into the query result to start returning transactions. If any search conditions are changed, the query offset will change and you must restart your search iteration.")
  @JsonProperty("offset")
  public Long getOffset() {
    return offset;
  }
  public void setOffset(Long offset) {
    this.offset = offset;
  }

  /**
   * limit is the maximum number of transactions to return in one call. The implementation may return <= limit transactions.
   * minimum: 0
   **/
  public SearchTransactionsRequest limit(Long limit) {
    this.limit = limit;
    return this;
  }

  
  @Schema(example = "5", description = "limit is the maximum number of transactions to return in one call. The implementation may return <= limit transactions.")
  @JsonProperty("limit")
  public Long getLimit() {
    return limit;
  }
  public void setLimit(Long limit) {
    this.limit = limit;
  }

  /**
   **/
  public SearchTransactionsRequest transactionIdentifier(TransactionIdentifier transactionIdentifier) {
    this.transactionIdentifier = transactionIdentifier;
    return this;
  }

  
  @Schema(description = "")
  @JsonProperty("transaction_identifier")
  public TransactionIdentifier getTransactionIdentifier() {
    return transactionIdentifier;
  }
  public void setTransactionIdentifier(TransactionIdentifier transactionIdentifier) {
    this.transactionIdentifier = transactionIdentifier;
  }

  /**
   **/
  public SearchTransactionsRequest accountIdentifier(AccountIdentifier accountIdentifier) {
    this.accountIdentifier = accountIdentifier;
    return this;
  }

  
  @Schema(description = "")
  @JsonProperty("account_identifier")
  public AccountIdentifier getAccountIdentifier() {
    return accountIdentifier;
  }
  public void setAccountIdentifier(AccountIdentifier accountIdentifier) {
    this.accountIdentifier = accountIdentifier;
  }

  /**
   **/
  public SearchTransactionsRequest coinIdentifier(CoinIdentifier coinIdentifier) {
    this.coinIdentifier = coinIdentifier;
    return this;
  }

  
  @Schema(description = "")
  @JsonProperty("coin_identifier")
  public CoinIdentifier getCoinIdentifier() {
    return coinIdentifier;
  }
  public void setCoinIdentifier(CoinIdentifier coinIdentifier) {
    this.coinIdentifier = coinIdentifier;
  }

  /**
   **/
  public SearchTransactionsRequest currency(Currency currency) {
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
   * status is the network-specific operation type.
   **/
  public SearchTransactionsRequest status(String status) {
    this.status = status;
    return this;
  }

  
  @Schema(example = "reverted", description = "status is the network-specific operation type.")
  @JsonProperty("status")
  public String getStatus() {
    return status;
  }
  public void setStatus(String status) {
    this.status = status;
  }

  /**
   * type is the network-specific operation type.
   **/
  public SearchTransactionsRequest type(String type) {
    this.type = type;
    return this;
  }

  
  @Schema(example = "transfer", description = "type is the network-specific operation type.")
  @JsonProperty("type")
  public String getType() {
    return type;
  }
  public void setType(String type) {
    this.type = type;
  }

  /**
   * address is AccountIdentifier.Address. This is used to get all transactions related to an AccountIdentifier.Address, regardless of SubAccountIdentifier.
   **/
  public SearchTransactionsRequest address(String address) {
    this.address = address;
    return this;
  }

  
  @Schema(example = "0x1dcc4de8dec75d7aab85b567b6ccd41ad312451b948a7413f0a142fd40d49347", description = "address is AccountIdentifier.Address. This is used to get all transactions related to an AccountIdentifier.Address, regardless of SubAccountIdentifier.")
  @JsonProperty("address")
  public String getAddress() {
    return address;
  }
  public void setAddress(String address) {
    this.address = address;
  }

  /**
   * success is a synthetic condition populated by parsing network-specific operation statuses (using the mapping provided in `/network/options`).
   **/
  public SearchTransactionsRequest success(Boolean success) {
    this.success = success;
    return this;
  }

  
  @Schema(description = "success is a synthetic condition populated by parsing network-specific operation statuses (using the mapping provided in `/network/options`).")
  @JsonProperty("success")
  public Boolean isSuccess() {
    return success;
  }
  public void setSuccess(Boolean success) {
    this.success = success;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SearchTransactionsRequest searchTransactionsRequest = (SearchTransactionsRequest) o;
    return Objects.equals(networkIdentifier, searchTransactionsRequest.networkIdentifier) &&
        Objects.equals(operator, searchTransactionsRequest.operator) &&
        Objects.equals(maxBlock, searchTransactionsRequest.maxBlock) &&
        Objects.equals(offset, searchTransactionsRequest.offset) &&
        Objects.equals(limit, searchTransactionsRequest.limit) &&
        Objects.equals(transactionIdentifier, searchTransactionsRequest.transactionIdentifier) &&
        Objects.equals(accountIdentifier, searchTransactionsRequest.accountIdentifier) &&
        Objects.equals(coinIdentifier, searchTransactionsRequest.coinIdentifier) &&
        Objects.equals(currency, searchTransactionsRequest.currency) &&
        Objects.equals(status, searchTransactionsRequest.status) &&
        Objects.equals(type, searchTransactionsRequest.type) &&
        Objects.equals(address, searchTransactionsRequest.address) &&
        Objects.equals(success, searchTransactionsRequest.success);
  }

  @Override
  public int hashCode() {
    return Objects.hash(networkIdentifier, operator, maxBlock, offset, limit, transactionIdentifier, accountIdentifier, coinIdentifier, currency, status, type, address, success);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SearchTransactionsRequest {\n");
    sb.append("    networkIdentifier: ").append(toIndentedString(networkIdentifier)).append("\n");
    sb.append("    operator: ").append(toIndentedString(operator)).append("\n");
    sb.append("    maxBlock: ").append(toIndentedString(maxBlock)).append("\n");
    sb.append("    offset: ").append(toIndentedString(offset)).append("\n");
    sb.append("    limit: ").append(toIndentedString(limit)).append("\n");
    sb.append("    transactionIdentifier: ").append(toIndentedString(transactionIdentifier)).append("\n");
    sb.append("    accountIdentifier: ").append(toIndentedString(accountIdentifier)).append("\n");
    sb.append("    coinIdentifier: ").append(toIndentedString(coinIdentifier)).append("\n");
    sb.append("    currency: ").append(toIndentedString(currency)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    address: ").append(toIndentedString(address)).append("\n");
    sb.append("    success: ").append(toIndentedString(success)).append("\n");
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
