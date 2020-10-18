package io.swagger.model;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.model.Amount;
import io.swagger.model.BlockIdentifier;
import io.swagger.model.Coin;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;


/**
 * An AccountBalanceResponse is returned on the /account/balance endpoint. If an account has a balance for each AccountIdentifier describing it (ex: an ERC-20 token balance on a few smart contracts), an account balance request must be made with each AccountIdentifier. 
 **/
@Schema(description = "An AccountBalanceResponse is returned on the /account/balance endpoint. If an account has a balance for each AccountIdentifier describing it (ex: an ERC-20 token balance on a few smart contracts), an account balance request must be made with each AccountIdentifier. ")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaInflectorServerCodegen", date = "2020-10-15T17:54:45.833Z[GMT]")
public class AccountBalanceResponse   {
  @JsonProperty("block_identifier")
  private BlockIdentifier blockIdentifier = null;
  @JsonProperty("balances")
  private List<Amount> balances = new ArrayList<>();
  @JsonProperty("coins")
  private List<Coin> coins = null;
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

  
  @Schema(required = true, description = "A single account may have a balance in multiple currencies. ")
  @JsonProperty("balances")
  public List<Amount> getBalances() {
    return balances;
  }
  public void setBalances(List<Amount> balances) {
    this.balances = balances;
  }

  /**
   * If a blockchain is UTXO-based, all unspent Coins owned by an account_identifier should be returned alongside the balance. It is highly recommended to populate this field so that users of the Rosetta API implementation don't need to maintain their own indexer to track their UTXOs. 
   **/
  public AccountBalanceResponse coins(List<Coin> coins) {
    this.coins = coins;
    return this;
  }

  
  @Schema(description = "If a blockchain is UTXO-based, all unspent Coins owned by an account_identifier should be returned alongside the balance. It is highly recommended to populate this field so that users of the Rosetta API implementation don't need to maintain their own indexer to track their UTXOs. ")
  @JsonProperty("coins")
  public List<Coin> getCoins() {
    return coins;
  }
  public void setCoins(List<Coin> coins) {
    this.coins = coins;
  }

  /**
   * Account-based blockchains that utilize a nonce or sequence number should include that number in the metadata. This number could be unique to the identifier or global across the account address. 
   **/
  public AccountBalanceResponse metadata(Object metadata) {
    this.metadata = metadata;
    return this;
  }

  
  @Schema(example = "{\"sequence_number\":23}", description = "Account-based blockchains that utilize a nonce or sequence number should include that number in the metadata. This number could be unique to the identifier or global across the account address. ")
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
        Objects.equals(coins, accountBalanceResponse.coins) &&
        Objects.equals(metadata, accountBalanceResponse.metadata);
  }

  @Override
  public int hashCode() {
    return Objects.hash(blockIdentifier, balances, coins, metadata);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AccountBalanceResponse {\n");
    sb.append("    blockIdentifier: ").append(toIndentedString(blockIdentifier)).append("\n");
    sb.append("    balances: ").append(toIndentedString(balances)).append("\n");
    sb.append("    coins: ").append(toIndentedString(coins)).append("\n");
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
