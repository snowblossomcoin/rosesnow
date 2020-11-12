package io.swagger.model;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.model.Amount;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;


/**
 * The ConstructionMetadataResponse returns network-specific metadata used for transaction construction. Optionally, the implementer can return the suggested fee associated with the transaction being constructed. The caller may use this info to adjust the intent of the transaction or to create a transaction with a different account that can pay the suggested fee. Suggested fee is an array in case fee payment must occur in multiple currencies.
 **/
@Schema(description = "The ConstructionMetadataResponse returns network-specific metadata used for transaction construction. Optionally, the implementer can return the suggested fee associated with the transaction being constructed. The caller may use this info to adjust the intent of the transaction or to create a transaction with a different account that can pay the suggested fee. Suggested fee is an array in case fee payment must occur in multiple currencies.")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaInflectorServerCodegen", date = "2020-11-12T07:15:46.859Z[GMT]")
public class ConstructionMetadataResponse   {
  @JsonProperty("metadata")
  private Object metadata = null;
  @JsonProperty("suggested_fee")
  private List<Amount> suggestedFee = null;
  /**
   **/
  public ConstructionMetadataResponse metadata(Object metadata) {
    this.metadata = metadata;
    return this;
  }

  
  @Schema(example = "{\"account_sequence\":23,\"recent_block_hash\":\"0x52bc44d5378309ee2abf1539bf71de1b7d7be3b5\"}", required = true, description = "")
  @JsonProperty("metadata")
  public Object getMetadata() {
    return metadata;
  }
  public void setMetadata(Object metadata) {
    this.metadata = metadata;
  }

  /**
   **/
  public ConstructionMetadataResponse suggestedFee(List<Amount> suggestedFee) {
    this.suggestedFee = suggestedFee;
    return this;
  }

  
  @Schema(description = "")
  @JsonProperty("suggested_fee")
  public List<Amount> getSuggestedFee() {
    return suggestedFee;
  }
  public void setSuggestedFee(List<Amount> suggestedFee) {
    this.suggestedFee = suggestedFee;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ConstructionMetadataResponse constructionMetadataResponse = (ConstructionMetadataResponse) o;
    return Objects.equals(metadata, constructionMetadataResponse.metadata) &&
        Objects.equals(suggestedFee, constructionMetadataResponse.suggestedFee);
  }

  @Override
  public int hashCode() {
    return Objects.hash(metadata, suggestedFee);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ConstructionMetadataResponse {\n");
    sb.append("    metadata: ").append(toIndentedString(metadata)).append("\n");
    sb.append("    suggestedFee: ").append(toIndentedString(suggestedFee)).append("\n");
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
