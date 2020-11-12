package io.swagger.model;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.model.AccountIdentifier;
import io.swagger.model.SignatureType;
import io.swagger.v3.oas.annotations.media.Schema;


/**
 * SigningPayload is signed by the client with the keypair associated with an AccountIdentifier using the specified SignatureType. SignatureType can be optionally populated if there is a restriction on the signature scheme that can be used to sign the payload.
 **/
@Schema(description = "SigningPayload is signed by the client with the keypair associated with an AccountIdentifier using the specified SignatureType. SignatureType can be optionally populated if there is a restriction on the signature scheme that can be used to sign the payload.")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaInflectorServerCodegen", date = "2020-11-12T07:15:46.859Z[GMT]")
public class SigningPayload   {
  @JsonProperty("address")
  private String address = null;
  @JsonProperty("account_identifier")
  private AccountIdentifier accountIdentifier = null;
  @JsonProperty("hex_bytes")
  private String hexBytes = null;
  @JsonProperty("signature_type")
  private SignatureType signatureType = null;
  /**
   * [DEPRECATED by `account_identifier` in `v1.4.4`] The network-specific address of the account that should sign the payload.
   **/
  public SigningPayload address(String address) {
    this.address = address;
    return this;
  }

  
  @Schema(description = "[DEPRECATED by `account_identifier` in `v1.4.4`] The network-specific address of the account that should sign the payload.")
  @JsonProperty("address")
  public String getAddress() {
    return address;
  }
  public void setAddress(String address) {
    this.address = address;
  }

  /**
   **/
  public SigningPayload accountIdentifier(AccountIdentifier accountIdentifier) {
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
  public SigningPayload hexBytes(String hexBytes) {
    this.hexBytes = hexBytes;
    return this;
  }

  
  @Schema(required = true, description = "")
  @JsonProperty("hex_bytes")
  public String getHexBytes() {
    return hexBytes;
  }
  public void setHexBytes(String hexBytes) {
    this.hexBytes = hexBytes;
  }

  /**
   **/
  public SigningPayload signatureType(SignatureType signatureType) {
    this.signatureType = signatureType;
    return this;
  }

  
  @Schema(description = "")
  @JsonProperty("signature_type")
  public SignatureType getSignatureType() {
    return signatureType;
  }
  public void setSignatureType(SignatureType signatureType) {
    this.signatureType = signatureType;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SigningPayload signingPayload = (SigningPayload) o;
    return Objects.equals(address, signingPayload.address) &&
        Objects.equals(accountIdentifier, signingPayload.accountIdentifier) &&
        Objects.equals(hexBytes, signingPayload.hexBytes) &&
        Objects.equals(signatureType, signingPayload.signatureType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(address, accountIdentifier, hexBytes, signatureType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SigningPayload {\n");
    sb.append("    address: ").append(toIndentedString(address)).append("\n");
    sb.append("    accountIdentifier: ").append(toIndentedString(accountIdentifier)).append("\n");
    sb.append("    hexBytes: ").append(toIndentedString(hexBytes)).append("\n");
    sb.append("    signatureType: ").append(toIndentedString(signatureType)).append("\n");
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
