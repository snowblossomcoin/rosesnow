package io.swagger.model;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.model.BlockIdentifier;
import io.swagger.model.Transaction;
import io.swagger.v3.oas.annotations.media.Schema;


/**
 * BlockTransaction contains a populated Transaction and the BlockIdentifier that contains it.
 **/
@Schema(description = "BlockTransaction contains a populated Transaction and the BlockIdentifier that contains it.")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaInflectorServerCodegen", date = "2020-11-12T07:15:46.859Z[GMT]")
public class BlockTransaction   {
  @JsonProperty("block_identifier")
  private BlockIdentifier blockIdentifier = null;
  @JsonProperty("transaction")
  private Transaction transaction = null;
  /**
   **/
  public BlockTransaction blockIdentifier(BlockIdentifier blockIdentifier) {
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
  public BlockTransaction transaction(Transaction transaction) {
    this.transaction = transaction;
    return this;
  }

  
  @Schema(required = true, description = "")
  @JsonProperty("transaction")
  public Transaction getTransaction() {
    return transaction;
  }
  public void setTransaction(Transaction transaction) {
    this.transaction = transaction;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BlockTransaction blockTransaction = (BlockTransaction) o;
    return Objects.equals(blockIdentifier, blockTransaction.blockIdentifier) &&
        Objects.equals(transaction, blockTransaction.transaction);
  }

  @Override
  public int hashCode() {
    return Objects.hash(blockIdentifier, transaction);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BlockTransaction {\n");
    sb.append("    blockIdentifier: ").append(toIndentedString(blockIdentifier)).append("\n");
    sb.append("    transaction: ").append(toIndentedString(transaction)).append("\n");
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
