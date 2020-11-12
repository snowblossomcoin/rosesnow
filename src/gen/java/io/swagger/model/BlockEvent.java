package io.swagger.model;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.model.BlockEventType;
import io.swagger.model.BlockIdentifier;
import io.swagger.v3.oas.annotations.media.Schema;


/**
 * BlockEvent represents the addition or removal of a BlockIdentifier from storage. Streaming BlockEvents allows lightweight clients to update their own state without needing to implement their own syncing logic.
 **/
@Schema(description = "BlockEvent represents the addition or removal of a BlockIdentifier from storage. Streaming BlockEvents allows lightweight clients to update their own state without needing to implement their own syncing logic.")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaInflectorServerCodegen", date = "2020-11-12T07:15:46.859Z[GMT]")
public class BlockEvent   {
  @JsonProperty("sequence")
  private Long sequence = null;
  @JsonProperty("block_identifier")
  private BlockIdentifier blockIdentifier = null;
  @JsonProperty("type")
  private BlockEventType type = null;
  /**
   * sequence is the unique identifier of a BlockEvent within the context of a NetworkIdentifier.
   * minimum: 0
   **/
  public BlockEvent sequence(Long sequence) {
    this.sequence = sequence;
    return this;
  }

  
  @Schema(example = "5", required = true, description = "sequence is the unique identifier of a BlockEvent within the context of a NetworkIdentifier.")
  @JsonProperty("sequence")
  public Long getSequence() {
    return sequence;
  }
  public void setSequence(Long sequence) {
    this.sequence = sequence;
  }

  /**
   **/
  public BlockEvent blockIdentifier(BlockIdentifier blockIdentifier) {
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
  public BlockEvent type(BlockEventType type) {
    this.type = type;
    return this;
  }

  
  @Schema(required = true, description = "")
  @JsonProperty("type")
  public BlockEventType getType() {
    return type;
  }
  public void setType(BlockEventType type) {
    this.type = type;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BlockEvent blockEvent = (BlockEvent) o;
    return Objects.equals(sequence, blockEvent.sequence) &&
        Objects.equals(blockIdentifier, blockEvent.blockIdentifier) &&
        Objects.equals(type, blockEvent.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(sequence, blockIdentifier, type);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BlockEvent {\n");
    sb.append("    sequence: ").append(toIndentedString(sequence)).append("\n");
    sb.append("    blockIdentifier: ").append(toIndentedString(blockIdentifier)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
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
