package io.swagger.model;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.model.AccountIdentifier;
import io.swagger.model.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;


/**
 * ConstructionParseResponse contains an array of operations that occur in a transaction blob. This should match the array of operations provided to &#x60;/construction/preprocess&#x60; and &#x60;/construction/payloads&#x60;. 
 **/
@Schema(description = "ConstructionParseResponse contains an array of operations that occur in a transaction blob. This should match the array of operations provided to `/construction/preprocess` and `/construction/payloads`. ")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaInflectorServerCodegen", date = "2020-10-15T17:54:45.833Z[GMT]")
public class ConstructionParseResponse   {
  @JsonProperty("operations")
  private List<Operation> operations = new ArrayList<>();
  @JsonProperty("signers")
  private List<String> signers = null;
  @JsonProperty("account_identifier_signers")
  private List<AccountIdentifier> accountIdentifierSigners = null;
  @JsonProperty("metadata")
  private Object metadata = null;
  /**
   **/
  public ConstructionParseResponse operations(List<Operation> operations) {
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
   * [DEPRECATED by `account_identifier_signers` in `v1.4.4`] All signers (addresses) of a particular transaction. If the transaction is unsigned, it should be empty. 
   **/
  public ConstructionParseResponse signers(List<String> signers) {
    this.signers = signers;
    return this;
  }

  
  @Schema(description = "[DEPRECATED by `account_identifier_signers` in `v1.4.4`] All signers (addresses) of a particular transaction. If the transaction is unsigned, it should be empty. ")
  @JsonProperty("signers")
  public List<String> getSigners() {
    return signers;
  }
  public void setSigners(List<String> signers) {
    this.signers = signers;
  }

  /**
   **/
  public ConstructionParseResponse accountIdentifierSigners(List<AccountIdentifier> accountIdentifierSigners) {
    this.accountIdentifierSigners = accountIdentifierSigners;
    return this;
  }

  
  @Schema(description = "")
  @JsonProperty("account_identifier_signers")
  public List<AccountIdentifier> getAccountIdentifierSigners() {
    return accountIdentifierSigners;
  }
  public void setAccountIdentifierSigners(List<AccountIdentifier> accountIdentifierSigners) {
    this.accountIdentifierSigners = accountIdentifierSigners;
  }

  /**
   **/
  public ConstructionParseResponse metadata(Object metadata) {
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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ConstructionParseResponse constructionParseResponse = (ConstructionParseResponse) o;
    return Objects.equals(operations, constructionParseResponse.operations) &&
        Objects.equals(signers, constructionParseResponse.signers) &&
        Objects.equals(accountIdentifierSigners, constructionParseResponse.accountIdentifierSigners) &&
        Objects.equals(metadata, constructionParseResponse.metadata);
  }

  @Override
  public int hashCode() {
    return Objects.hash(operations, signers, accountIdentifierSigners, metadata);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ConstructionParseResponse {\n");
    sb.append("    operations: ").append(toIndentedString(operations)).append("\n");
    sb.append("    signers: ").append(toIndentedString(signers)).append("\n");
    sb.append("    accountIdentifierSigners: ").append(toIndentedString(accountIdentifierSigners)).append("\n");
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
