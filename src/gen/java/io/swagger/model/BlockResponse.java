package io.swagger.model;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.model.Block;
import io.swagger.model.TransactionIdentifier;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;


/**
 * A BlockResponse includes a fully-populated block or a partially-populated block with a list of other transactions to fetch (other_transactions).  As a result of the consensus algorithm of some blockchains, blocks can be omitted (i.e. certain block indexes can be skipped). If a query for one of these omitted indexes is made, the response should not include a &#x60;Block&#x60; object.  It is VERY important to note that blocks MUST still form a canonical, connected chain of blocks where each block has a unique index. In other words, the &#x60;PartialBlockIdentifier&#x60; of a block after an omitted block should reference the last non-omitted block. 
 **/
@Schema(description = "A BlockResponse includes a fully-populated block or a partially-populated block with a list of other transactions to fetch (other_transactions).  As a result of the consensus algorithm of some blockchains, blocks can be omitted (i.e. certain block indexes can be skipped). If a query for one of these omitted indexes is made, the response should not include a `Block` object.  It is VERY important to note that blocks MUST still form a canonical, connected chain of blocks where each block has a unique index. In other words, the `PartialBlockIdentifier` of a block after an omitted block should reference the last non-omitted block. ")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaInflectorServerCodegen", date = "2020-10-15T17:54:45.833Z[GMT]")
public class BlockResponse   {
  @JsonProperty("block")
  private Block block = null;
  @JsonProperty("other_transactions")
  private List<TransactionIdentifier> otherTransactions = null;
  /**
   **/
  public BlockResponse block(Block block) {
    this.block = block;
    return this;
  }

  
  @Schema(description = "")
  @JsonProperty("block")
  public Block getBlock() {
    return block;
  }
  public void setBlock(Block block) {
    this.block = block;
  }

  /**
   * Some blockchains may require additional transactions to be fetched that weren't returned in the block response (ex: block only returns transaction hashes). For blockchains with a lot of transactions in each block, this can be very useful as consumers can concurrently fetch all transactions returned. 
   **/
  public BlockResponse otherTransactions(List<TransactionIdentifier> otherTransactions) {
    this.otherTransactions = otherTransactions;
    return this;
  }

  
  @Schema(description = "Some blockchains may require additional transactions to be fetched that weren't returned in the block response (ex: block only returns transaction hashes). For blockchains with a lot of transactions in each block, this can be very useful as consumers can concurrently fetch all transactions returned. ")
  @JsonProperty("other_transactions")
  public List<TransactionIdentifier> getOtherTransactions() {
    return otherTransactions;
  }
  public void setOtherTransactions(List<TransactionIdentifier> otherTransactions) {
    this.otherTransactions = otherTransactions;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BlockResponse blockResponse = (BlockResponse) o;
    return Objects.equals(block, blockResponse.block) &&
        Objects.equals(otherTransactions, blockResponse.otherTransactions);
  }

  @Override
  public int hashCode() {
    return Objects.hash(block, otherTransactions);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BlockResponse {\n");
    sb.append("    block: ").append(toIndentedString(block)).append("\n");
    sb.append("    otherTransactions: ").append(toIndentedString(otherTransactions)).append("\n");
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
