package io.swagger.model;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.model.BlockIdentifier;
import io.swagger.model.Transaction;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;


/**
 * Blocks contain an array of Transactions that occurred at a particular BlockIdentifier. A hard requirement for blocks returned by Rosetta implementations is that they MUST be _inalterable_: once a client has requested and received a block identified by a specific BlockIndentifier, all future calls for that same BlockIdentifier must return the same block contents.
 **/
@Schema(description = "Blocks contain an array of Transactions that occurred at a particular BlockIdentifier. A hard requirement for blocks returned by Rosetta implementations is that they MUST be _inalterable_: once a client has requested and received a block identified by a specific BlockIndentifier, all future calls for that same BlockIdentifier must return the same block contents.")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaInflectorServerCodegen", date = "2020-10-18T05:48:04.106Z[GMT]")
public class Block   {
  @JsonProperty("block_identifier")
  private BlockIdentifier blockIdentifier = null;
  @JsonProperty("parent_block_identifier")
  private BlockIdentifier parentBlockIdentifier = null;
  @JsonProperty("timestamp")
  private Long timestamp = null;
  @JsonProperty("transactions")
  private List<Transaction> transactions = new ArrayList<>();
  @JsonProperty("metadata")
  private Object metadata = null;
  /**
   **/
  public Block blockIdentifier(BlockIdentifier blockIdentifier) {
    this.blockIdentifier = blockIdentifier;
    return this;
  }

  
  @Schema(required = true, description = "")
  @JsonProperty("block_identifier")
  public BlockIdentifier getBlockIdentifier() {
    return blockIdentifier;
  }
  public void setBlockIdentifier(BlockIdentifier blockIdentifier) {
    this.blockIdentifier = blockIdentifier;
  }

  /**
   **/
  public Block parentBlockIdentifier(BlockIdentifier parentBlockIdentifier) {
    this.parentBlockIdentifier = parentBlockIdentifier;
    return this;
  }

  
  @Schema(required = true, description = "")
  @JsonProperty("parent_block_identifier")
  public BlockIdentifier getParentBlockIdentifier() {
    return parentBlockIdentifier;
  }
  public void setParentBlockIdentifier(BlockIdentifier parentBlockIdentifier) {
    this.parentBlockIdentifier = parentBlockIdentifier;
  }

  /**
   **/
  public Block timestamp(Long timestamp) {
    this.timestamp = timestamp;
    return this;
  }

  
  @Schema(required = true, description = "")
  @JsonProperty("timestamp")
  public Long getTimestamp() {
    return timestamp;
  }
  public void setTimestamp(Long timestamp) {
    this.timestamp = timestamp;
  }

  /**
   **/
  public Block transactions(List<Transaction> transactions) {
    this.transactions = transactions;
    return this;
  }

  
  @Schema(required = true, description = "")
  @JsonProperty("transactions")
  public List<Transaction> getTransactions() {
    return transactions;
  }
  public void setTransactions(List<Transaction> transactions) {
    this.transactions = transactions;
  }

  /**
   **/
  public Block metadata(Object metadata) {
    this.metadata = metadata;
    return this;
  }

  
  @Schema(example = "{\"transactions_root\":\"0x1dcc4de8dec75d7aab85b567b6ccd41ad312451b948a7413f0a142fd40d49347\",\"difficulty\":\"123891724987128947\"}", description = "")
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
    Block block = (Block) o;
    return Objects.equals(blockIdentifier, block.blockIdentifier) &&
        Objects.equals(parentBlockIdentifier, block.parentBlockIdentifier) &&
        Objects.equals(timestamp, block.timestamp) &&
        Objects.equals(transactions, block.transactions) &&
        Objects.equals(metadata, block.metadata);
  }

  @Override
  public int hashCode() {
    return Objects.hash(blockIdentifier, parentBlockIdentifier, timestamp, transactions, metadata);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Block {\n");
    sb.append("    blockIdentifier: ").append(toIndentedString(blockIdentifier)).append("\n");
    sb.append("    parentBlockIdentifier: ").append(toIndentedString(parentBlockIdentifier)).append("\n");
    sb.append("    timestamp: ").append(toIndentedString(timestamp)).append("\n");
    sb.append("    transactions: ").append(toIndentedString(transactions)).append("\n");
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
