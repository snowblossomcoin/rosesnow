package io.swagger.model;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;


/**
 * An account may have state specific to a contract address (ERC-20 token) and/or a stake (delegated balance). The sub_account_identifier should specify which state (if applicable) an account instantiation refers to.
 **/
@Schema(description = "An account may have state specific to a contract address (ERC-20 token) and/or a stake (delegated balance). The sub_account_identifier should specify which state (if applicable) an account instantiation refers to.")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaInflectorServerCodegen", date = "2020-11-12T07:15:46.859Z[GMT]")
public class SubAccountIdentifier   {
  @JsonProperty("address")
  private String address = null;
  @JsonProperty("metadata")
  private Object metadata = null;
  /**
   * The SubAccount address may be a cryptographic value or some other identifier (ex: bonded) that uniquely specifies a SubAccount.
   **/
  public SubAccountIdentifier address(String address) {
    this.address = address;
    return this;
  }

  
  @Schema(example = "0x6b175474e89094c44da98b954eedeac495271d0f", required = true, description = "The SubAccount address may be a cryptographic value or some other identifier (ex: bonded) that uniquely specifies a SubAccount.")
  @JsonProperty("address")
  public String getAddress() {
    return address;
  }
  public void setAddress(String address) {
    this.address = address;
  }

  /**
   * If the SubAccount address is not sufficient to uniquely specify a SubAccount, any other identifying information can be stored here. It is important to note that two SubAccounts with identical addresses but differing metadata will not be considered equal by clients.
   **/
  public SubAccountIdentifier metadata(Object metadata) {
    this.metadata = metadata;
    return this;
  }

  
  @Schema(description = "If the SubAccount address is not sufficient to uniquely specify a SubAccount, any other identifying information can be stored here. It is important to note that two SubAccounts with identical addresses but differing metadata will not be considered equal by clients.")
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
    SubAccountIdentifier subAccountIdentifier = (SubAccountIdentifier) o;
    return Objects.equals(address, subAccountIdentifier.address) &&
        Objects.equals(metadata, subAccountIdentifier.metadata);
  }

  @Override
  public int hashCode() {
    return Objects.hash(address, metadata);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SubAccountIdentifier {\n");
    sb.append("    address: ").append(toIndentedString(address)).append("\n");
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
