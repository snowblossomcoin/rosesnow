package io.swagger.model;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.model.BlockTransaction;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;


/**
 * SearchTransactionsResponse contains an ordered collection of BlockTransactions that match the query in SearchTransactionsRequest. These BlockTransactions are sorted from most recent block to oldest block.
 **/
@Schema(description = "SearchTransactionsResponse contains an ordered collection of BlockTransactions that match the query in SearchTransactionsRequest. These BlockTransactions are sorted from most recent block to oldest block.")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaInflectorServerCodegen", date = "2020-11-12T07:15:46.859Z[GMT]")
public class SearchTransactionsResponse   {
  @JsonProperty("next_offset")
  private Long nextOffset = null;
  @JsonProperty("transactions")
  private List<BlockTransaction> transactions = new ArrayList<BlockTransaction>();
  /**
   * next_offset is the next offset to use when paginating through transaction results. If this field is not populated, there are no more transactions to query.
   * minimum: 0
   **/
  public SearchTransactionsResponse nextOffset(Long nextOffset) {
    this.nextOffset = nextOffset;
    return this;
  }

  
  @Schema(example = "5", description = "next_offset is the next offset to use when paginating through transaction results. If this field is not populated, there are no more transactions to query.")
  @JsonProperty("next_offset")
  public Long getNextOffset() {
    return nextOffset;
  }
  public void setNextOffset(Long nextOffset) {
    this.nextOffset = nextOffset;
  }

  /**
   * transactions is an array of BlockTransactions sorted by most recent BlockIdentifier (meaning that transactions in recent blocks appear first). If there are many transactions for a particular search, transactions may not contain all matching transactions. It is up to the caller to paginate these transactions using the max_block field.
   **/
  public SearchTransactionsResponse transactions(List<BlockTransaction> transactions) {
    this.transactions = transactions;
    return this;
  }

  
  @Schema(required = true, description = "transactions is an array of BlockTransactions sorted by most recent BlockIdentifier (meaning that transactions in recent blocks appear first). If there are many transactions for a particular search, transactions may not contain all matching transactions. It is up to the caller to paginate these transactions using the max_block field.")
  @JsonProperty("transactions")
  public List<BlockTransaction> getTransactions() {
    return transactions;
  }
  public void setTransactions(List<BlockTransaction> transactions) {
    this.transactions = transactions;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SearchTransactionsResponse searchTransactionsResponse = (SearchTransactionsResponse) o;
    return Objects.equals(nextOffset, searchTransactionsResponse.nextOffset) &&
        Objects.equals(transactions, searchTransactionsResponse.transactions);
  }

  @Override
  public int hashCode() {
    return Objects.hash(nextOffset, transactions);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SearchTransactionsResponse {\n");
    sb.append("    nextOffset: ").append(toIndentedString(nextOffset)).append("\n");
    sb.append("    transactions: ").append(toIndentedString(transactions)).append("\n");
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
