package io.swagger.model;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.model.Amount;
import io.swagger.model.NetworkIdentifier;
import io.swagger.model.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;


/**
 * ConstructionPreprocessRequest is passed to the &#x60;/construction/preprocess&#x60; endpoint so that a Rosetta implementation can determine which metadata it needs to request for construction.  Metadata provided in this object should NEVER be a product of live data (i.e. the caller must follow some network-specific data fetching strategy outside of the Construction API to populate required Metadata). If live data is required for construction, it MUST be fetched in the call to &#x60;/construction/metadata&#x60;.  The caller can provide a max fee they are willing to pay for a transaction. This is an array in the case fees must be paid in multiple currencies.  The caller can also provide a suggested fee multiplier to indicate that the suggested fee should be scaled. This may be used to set higher fees for urgent transactions or to pay lower fees when there is less urgency. It is assumed that providing a very low multiplier (like 0.0001) will never lead to a transaction being created with a fee less than the minimum network fee (if applicable).  In the case that the caller provides both a max fee and a suggested fee multiplier, the max fee will set an upper bound on the suggested fee (regardless of the multiplier provided). 
 **/
@Schema(description = "ConstructionPreprocessRequest is passed to the `/construction/preprocess` endpoint so that a Rosetta implementation can determine which metadata it needs to request for construction.  Metadata provided in this object should NEVER be a product of live data (i.e. the caller must follow some network-specific data fetching strategy outside of the Construction API to populate required Metadata). If live data is required for construction, it MUST be fetched in the call to `/construction/metadata`.  The caller can provide a max fee they are willing to pay for a transaction. This is an array in the case fees must be paid in multiple currencies.  The caller can also provide a suggested fee multiplier to indicate that the suggested fee should be scaled. This may be used to set higher fees for urgent transactions or to pay lower fees when there is less urgency. It is assumed that providing a very low multiplier (like 0.0001) will never lead to a transaction being created with a fee less than the minimum network fee (if applicable).  In the case that the caller provides both a max fee and a suggested fee multiplier, the max fee will set an upper bound on the suggested fee (regardless of the multiplier provided). ")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaInflectorServerCodegen", date = "2020-10-15T17:54:45.833Z[GMT]")
public class ConstructionPreprocessRequest   {
  @JsonProperty("network_identifier")
  private NetworkIdentifier networkIdentifier = null;
  @JsonProperty("operations")
  private List<Operation> operations = new ArrayList<>();
  @JsonProperty("metadata")
  private Object metadata = null;
  @JsonProperty("max_fee")
  private List<Amount> maxFee = null;
  @JsonProperty("suggested_fee_multiplier")
  private Double suggestedFeeMultiplier = null;
  /**
   **/
  public ConstructionPreprocessRequest networkIdentifier(NetworkIdentifier networkIdentifier) {
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
  public ConstructionPreprocessRequest operations(List<Operation> operations) {
    this.operations = operations;
    return this;
  }

  
  @Schema(required = true, description = "")
  @JsonProperty("operations")
  public List<Operation> getOperations() {
    return operations;
  }
  public void setOperations(List<Operation> operations) {
    this.operations = operations;
  }

  /**
   **/
  public ConstructionPreprocessRequest metadata(Object metadata) {
    this.metadata = metadata;
    return this;
  }

  
  @Schema(description = "")
  @JsonProperty("metadata")
  public Object getMetadata() {
    return metadata;
  }
  public void setMetadata(Object metadata) {
    this.metadata = metadata;
  }

  /**
   **/
  public ConstructionPreprocessRequest maxFee(List<Amount> maxFee) {
    this.maxFee = maxFee;
    return this;
  }

  
  @Schema(description = "")
  @JsonProperty("max_fee")
  public List<Amount> getMaxFee() {
    return maxFee;
  }
  public void setMaxFee(List<Amount> maxFee) {
    this.maxFee = maxFee;
  }

  /**
   * minimum: 0
   **/
  public ConstructionPreprocessRequest suggestedFeeMultiplier(Double suggestedFeeMultiplier) {
    this.suggestedFeeMultiplier = suggestedFeeMultiplier;
    return this;
  }

  
  @Schema(description = "")
  @JsonProperty("suggested_fee_multiplier")
  public Double getSuggestedFeeMultiplier() {
    return suggestedFeeMultiplier;
  }
  public void setSuggestedFeeMultiplier(Double suggestedFeeMultiplier) {
    this.suggestedFeeMultiplier = suggestedFeeMultiplier;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ConstructionPreprocessRequest constructionPreprocessRequest = (ConstructionPreprocessRequest) o;
    return Objects.equals(networkIdentifier, constructionPreprocessRequest.networkIdentifier) &&
        Objects.equals(operations, constructionPreprocessRequest.operations) &&
        Objects.equals(metadata, constructionPreprocessRequest.metadata) &&
        Objects.equals(maxFee, constructionPreprocessRequest.maxFee) &&
        Objects.equals(suggestedFeeMultiplier, constructionPreprocessRequest.suggestedFeeMultiplier);
  }

  @Override
  public int hashCode() {
    return Objects.hash(networkIdentifier, operations, metadata, maxFee, suggestedFeeMultiplier);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ConstructionPreprocessRequest {\n");
    sb.append("    networkIdentifier: ").append(toIndentedString(networkIdentifier)).append("\n");
    sb.append("    operations: ").append(toIndentedString(operations)).append("\n");
    sb.append("    metadata: ").append(toIndentedString(metadata)).append("\n");
    sb.append("    maxFee: ").append(toIndentedString(maxFee)).append("\n");
    sb.append("    suggestedFeeMultiplier: ").append(toIndentedString(suggestedFeeMultiplier)).append("\n");
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
