package io.swagger.model;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.model.AccountIdentifier;
import io.swagger.v3.oas.annotations.media.Schema;


/**
 * ConstructionDeriveResponse is returned by the &#x60;/construction/derive&#x60; endpoint.
 **/
@Schema(description = "ConstructionDeriveResponse is returned by the `/construction/derive` endpoint.")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaInflectorServerCodegen", date = "2020-10-18T05:48:04.106Z[GMT]")
public class ConstructionDeriveResponse   {
  @JsonProperty("address")
  private String address = null;
  @JsonProperty("account_identifier")
  private AccountIdentifier accountIdentifier = null;
  @JsonProperty("metadata")
  private Object metadata = null;
  /**
   * [DEPRECATED by `account_identifier` in `v1.4.4`] Address in network-specific format.
   **/
  public ConstructionDeriveResponse address(String address) {
    this.address = address;
    return this;
  }

  
  @Schema(description = "[DEPRECATED by `account_identifier` in `v1.4.4`] Address in network-specific format.")
  @JsonProperty("address")
  public String getAddress() {
    return address;
  }
  public void setAddress(String address) {
    this.address = address;
  }

  /**
   **/
  public ConstructionDeriveResponse accountIdentifier(AccountIdentifier accountIdentifier) {
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
  public ConstructionDeriveResponse metadata(Object metadata) {
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
    ConstructionDeriveResponse constructionDeriveResponse = (ConstructionDeriveResponse) o;
    return Objects.equals(address, constructionDeriveResponse.address) &&
        Objects.equals(accountIdentifier, constructionDeriveResponse.accountIdentifier) &&
        Objects.equals(metadata, constructionDeriveResponse.metadata);
  }

  @Override
  public int hashCode() {
    return Objects.hash(address, accountIdentifier, metadata);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ConstructionDeriveResponse {\n");
    sb.append("    address: ").append(toIndentedString(address)).append("\n");
    sb.append("    accountIdentifier: ").append(toIndentedString(accountIdentifier)).append("\n");
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
