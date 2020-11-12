package io.swagger.model;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.model.BlockIdentifier;
import io.swagger.model.Coin;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;


/**
 * AccountCoinsResponse is returned on the /account/coins endpoint and includes all unspent Coins owned by an AccountIdentifier.
 **/
@Schema(description = "AccountCoinsResponse is returned on the /account/coins endpoint and includes all unspent Coins owned by an AccountIdentifier.")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaInflectorServerCodegen", date = "2020-11-12T07:15:46.859Z[GMT]")
public class AccountCoinsResponse   {
  @JsonProperty("block_identifier")
  private BlockIdentifier blockIdentifier = null;
  @JsonProperty("coins")
  private List<Coin> coins = new ArrayList<Coin>();
  @JsonProperty("metadata")
  private Object metadata = null;
  /**
   **/
  public AccountCoinsResponse blockIdentifier(BlockIdentifier blockIdentifier) {
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
   * If a blockchain is UTXO-based, all unspent Coins owned by an account_identifier should be returned alongside the balance. It is highly recommended to populate this field so that users of the Rosetta API implementation don't need to maintain their own indexer to track their UTXOs.
   **/
  public AccountCoinsResponse coins(List<Coin> coins) {
    this.coins = coins;
    return this;
  }

  
  @Schema(required = true, description = "If a blockchain is UTXO-based, all unspent Coins owned by an account_identifier should be returned alongside the balance. It is highly recommended to populate this field so that users of the Rosetta API implementation don't need to maintain their own indexer to track their UTXOs.")
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
  public AccountCoinsResponse metadata(Object metadata) {
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
    AccountCoinsResponse accountCoinsResponse = (AccountCoinsResponse) o;
    return Objects.equals(blockIdentifier, accountCoinsResponse.blockIdentifier) &&
        Objects.equals(coins, accountCoinsResponse.coins) &&
        Objects.equals(metadata, accountCoinsResponse.metadata);
  }

  @Override
  public int hashCode() {
    return Objects.hash(blockIdentifier, coins, metadata);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AccountCoinsResponse {\n");
    sb.append("    blockIdentifier: ").append(toIndentedString(blockIdentifier)).append("\n");
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
