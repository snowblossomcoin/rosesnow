package io.swagger.model;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.model.Amount;
import io.swagger.model.BlockIdentifier;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;


/**
 * An AccountBalanceResponse is returned on the /account/balance endpoint. If an account has a balance for each AccountIdentifier describing it (ex: an ERC-20 token balance on a few smart contracts), an account balance request must be made with each AccountIdentifier. The &#x60;coins&#x60; field was removed and replaced by by &#x60;/account/coins&#x60; in &#x60;v1.4.7&#x60;.
 **/
@Schema(description = "An AccountBalanceResponse is returned on the /account/balance endpoint. If an account has a balance for each AccountIdentifier describing it (ex: an ERC-20 token balance on a few smart contracts), an account balance request must be made with each AccountIdentifier. The `coins` field was removed and replaced by by `/account/coins` in `v1.4.7`.")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaInflectorServerCodegen", date = "2020-11-12T07:15:46.859Z[GMT]")
public class AccountBalanceResponse   {
  @JsonProperty("block_identifier")
  private BlockIdentifier blockIdentifier = null;
  @JsonProperty("balances")
  private List<Amount> balances = new ArrayList<Amount>();
  @JsonProperty("metadata")
  private Object metadata = null;
  /**
   **/
  public AccountBalanceResponse blockIdentifier(BlockIdentifier blockIdentifier) {
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
   * A single account may have a balance in multiple currencies.
   **/
  public AccountBalanceResponse balances(List<Amount> balances) {
    this.balances = balances;
    return this;
  }

  
  @Schema(required = true, description = "A single account may have a balance in multiple currencies.")
  @JsonProperty("balances")
  public List<Amount> getBalances() {
    return balances;
  }
  public void setBalances(List<Amount> balances) {
    this.balances = balances;
  }

  /**
   * Account-based blockchains that utilize a nonce or sequence number should include that number in the metadata. This number could be unique to the identifier or global across the account address.
   **/
  public AccountBalanceResponse metadata(Object metadata) {
    this.metadata = metadata;
    return this;
  }

  
  @Schema(example = "{\"sequence_number\":23}", description = "Account-based blockchains that utilize a nonce or sequence number should include that number in the metadata. This number could be unique to the identifier or global across the account address.")
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
    AccountBalanceResponse accountBalanceResponse = (AccountBalanceResponse) o;
    return Objects.equals(blockIdentifier, accountBalanceResponse.blockIdentifier) &&
        Objects.equals(balances, accountBalanceResponse.balances) &&
        Objects.equals(metadata, accountBalanceResponse.metadata);
  }

  @Override
  public int hashCode() {
    return Objects.hash(blockIdentifier, balances, metadata);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AccountBalanceResponse {\n");
    sb.append("    blockIdentifier: ").append(toIndentedString(blockIdentifier)).append("\n");
    sb.append("    balances: ").append(toIndentedString(balances)).append("\n");
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
