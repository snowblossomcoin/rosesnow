package io.swagger.model;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.model.Amount;
import io.swagger.model.CoinIdentifier;
import io.swagger.v3.oas.annotations.media.Schema;


/**
 * Coin contains its unique identifier and the amount it represents.
 **/
@Schema(description = "Coin contains its unique identifier and the amount it represents.")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaInflectorServerCodegen", date = "2020-11-12T07:15:46.859Z[GMT]")
public class Coin   {
  @JsonProperty("coin_identifier")
  private CoinIdentifier coinIdentifier = null;
  @JsonProperty("amount")
  private Amount amount = null;
  /**
   **/
  public Coin coinIdentifier(CoinIdentifier coinIdentifier) {
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
  public Coin amount(Amount amount) {
    this.amount = amount;
    return this;
  }

  
  @Schema(required = true, description = "")
  @JsonProperty("amount")
  public Amount getAmount() {
    return amount;
  }
  public void setAmount(Amount amount) {
    this.amount = amount;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Coin coin = (Coin) o;
    return Objects.equals(coinIdentifier, coin.coinIdentifier) &&
        Objects.equals(amount, coin.amount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(coinIdentifier, amount);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Coin {\n");
    sb.append("    coinIdentifier: ").append(toIndentedString(coinIdentifier)).append("\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
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
