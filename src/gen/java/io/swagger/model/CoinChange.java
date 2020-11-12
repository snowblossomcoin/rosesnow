package io.swagger.model;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.model.CoinAction;
import io.swagger.model.CoinIdentifier;
import io.swagger.v3.oas.annotations.media.Schema;


/**
 * CoinChange is used to represent a change in state of a some coin identified by a coin_identifier. This object is part of the Operation model and must be populated for UTXO-based blockchains. Coincidentally, this abstraction of UTXOs allows for supporting both account-based transfers and UTXO-based transfers on the same blockchain (when a transfer is account-based, don&#x27;t populate this model).
 **/
@Schema(description = "CoinChange is used to represent a change in state of a some coin identified by a coin_identifier. This object is part of the Operation model and must be populated for UTXO-based blockchains. Coincidentally, this abstraction of UTXOs allows for supporting both account-based transfers and UTXO-based transfers on the same blockchain (when a transfer is account-based, don't populate this model).")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaInflectorServerCodegen", date = "2020-11-12T07:15:46.859Z[GMT]")
public class CoinChange   {
  @JsonProperty("coin_identifier")
  private CoinIdentifier coinIdentifier = null;
  @JsonProperty("coin_action")
  private CoinAction coinAction = null;
  /**
   **/
  public CoinChange coinIdentifier(CoinIdentifier coinIdentifier) {
    this.coinIdentifier = coinIdentifier;
    return this;
  }

  
  @Schema(required = true, description = "")
  @JsonProperty("coin_identifier")
  public CoinIdentifier getCoinIdentifier() {
    return coinIdentifier;
  }
  public void setCoinIdentifier(CoinIdentifier coinIdentifier) {
    this.coinIdentifier = coinIdentifier;
  }

  /**
   **/
  public CoinChange coinAction(CoinAction coinAction) {
    this.coinAction = coinAction;
    return this;
  }

  
  @Schema(required = true, description = "")
  @JsonProperty("coin_action")
  public CoinAction getCoinAction() {
    return coinAction;
  }
  public void setCoinAction(CoinAction coinAction) {
    this.coinAction = coinAction;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CoinChange coinChange = (CoinChange) o;
    return Objects.equals(coinIdentifier, coinChange.coinIdentifier) &&
        Objects.equals(coinAction, coinChange.coinAction);
  }

  @Override
  public int hashCode() {
    return Objects.hash(coinIdentifier, coinAction);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CoinChange {\n");
    sb.append("    coinIdentifier: ").append(toIndentedString(coinIdentifier)).append("\n");
    sb.append("    coinAction: ").append(toIndentedString(coinAction)).append("\n");
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
