package io.swagger.model;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.model.SubAccountIdentifier;
import io.swagger.v3.oas.annotations.media.Schema;


/**
 * The account_identifier uniquely identifies an account within a network. All fields in the account_identifier are utilized to determine this uniqueness (including the metadata field, if populated).
 **/
@Schema(description = "The account_identifier uniquely identifies an account within a network. All fields in the account_identifier are utilized to determine this uniqueness (including the metadata field, if populated).")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaInflectorServerCodegen", date = "2020-11-12T07:15:46.859Z[GMT]")
public class AccountIdentifier   {
  @JsonProperty("address")
  private String address = null;
  @JsonProperty("sub_account")
  private SubAccountIdentifier subAccount = null;
  @JsonProperty("metadata")
  private Object metadata = null;
  /**
   * The address may be a cryptographic public key (or some encoding of it) or a provided username.
   **/
  public AccountIdentifier address(String address) {
    this.address = address;
    return this;
  }

  
  @Schema(example = "0x3a065000ab4183c6bf581dc1e55a605455fc6d61", required = true, description = "The address may be a cryptographic public key (or some encoding of it) or a provided username.")
  @JsonProperty("address")
  public String getAddress() {
    return address;
  }
  public void setAddress(String address) {
    this.address = address;
  }

  /**
   **/
  public AccountIdentifier subAccount(SubAccountIdentifier subAccount) {
    this.subAccount = subAccount;
    return this;
  }

  
  @Schema(description = "")
  @JsonProperty("sub_account")
  public SubAccountIdentifier getSubAccount() {
    return subAccount;
  }
  public void setSubAccount(SubAccountIdentifier subAccount) {
    this.subAccount = subAccount;
  }

  /**
   * Blockchains that utilize a username model (where the address is not a derivative of a cryptographic public key) should specify the public key(s) owned by the address in metadata.
   **/
  public AccountIdentifier metadata(Object metadata) {
    this.metadata = metadata;
    return this;
  }

  
  @Schema(description = "Blockchains that utilize a username model (where the address is not a derivative of a cryptographic public key) should specify the public key(s) owned by the address in metadata.")
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
    AccountIdentifier accountIdentifier = (AccountIdentifier) o;
    return Objects.equals(address, accountIdentifier.address) &&
        Objects.equals(subAccount, accountIdentifier.subAccount) &&
        Objects.equals(metadata, accountIdentifier.metadata);
  }

  @Override
  public int hashCode() {
    return Objects.hash(address, subAccount, metadata);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AccountIdentifier {\n");
    sb.append("    address: ").append(toIndentedString(address)).append("\n");
    sb.append("    subAccount: ").append(toIndentedString(subAccount)).append("\n");
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
