package io.swagger.model;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;


/**
 * The block_identifier uniquely identifies a block in a particular network.
 **/
@Schema(description = "The block_identifier uniquely identifies a block in a particular network.")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaInflectorServerCodegen", date = "2020-10-18T05:48:04.106Z[GMT]")
public class BlockIdentifier   {
  @JsonProperty("index")
  private Long index = null;
  @JsonProperty("hash")
  private String hash = null;
  /**
   * This is also known as the block height.
   **/
  public BlockIdentifier index(Long index) {
    this.index = index;
    return this;
  }

  
  @Schema(example = "1123941", required = true, description = "This is also known as the block height.")
  @JsonProperty("index")
  public Long getIndex() {
    return index;
  }
  public void setIndex(Long index) {
    this.index = index;
  }

  /**
   **/
  public BlockIdentifier hash(String hash) {
    this.hash = hash;
    return this;
  }

  
  @Schema(example = "0x1f2cc6c5027d2f201a5453ad1119574d2aed23a392654742ac3c78783c071f85", required = true, description = "")
  @JsonProperty("hash")
  public String getHash() {
    return hash;
  }
  public void setHash(String hash) {
    this.hash = hash;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BlockIdentifier blockIdentifier = (BlockIdentifier) o;
    return Objects.equals(index, blockIdentifier.index) &&
        Objects.equals(hash, blockIdentifier.hash);
  }

  @Override
  public int hashCode() {
    return Objects.hash(index, hash);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BlockIdentifier {\n");
    sb.append("    index: ").append(toIndentedString(index)).append("\n");
    sb.append("    hash: ").append(toIndentedString(hash)).append("\n");
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
