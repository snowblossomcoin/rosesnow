package io.swagger.model;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;


/**
 * Currency is composed of a canonical Symbol and Decimals. This Decimals value is used to convert an Amount.Value from atomic units (Satoshis) to standard units (Bitcoins).
 **/
@Schema(description = "Currency is composed of a canonical Symbol and Decimals. This Decimals value is used to convert an Amount.Value from atomic units (Satoshis) to standard units (Bitcoins).")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaInflectorServerCodegen", date = "2020-10-18T05:48:04.106Z[GMT]")
public class Currency   {
  @JsonProperty("symbol")
  private String symbol = null;
  @JsonProperty("decimals")
  private Integer decimals = null;
  @JsonProperty("metadata")
  private Object metadata = null;
  /**
   * Canonical symbol associated with a currency.
   **/
  public Currency symbol(String symbol) {
    this.symbol = symbol;
    return this;
  }

  
  @Schema(example = "BTC", required = true, description = "Canonical symbol associated with a currency.")
  @JsonProperty("symbol")
  public String getSymbol() {
    return symbol;
  }
  public void setSymbol(String symbol) {
    this.symbol = symbol;
  }

  /**
   * Number of decimal places in the standard unit representation of the amount. For example, BTC has 8 decimals. Note that it is not possible to represent the value of some currency in atomic units that is not base 10.
   * minimum: 0
   **/
  public Currency decimals(Integer decimals) {
    this.decimals = decimals;
    return this;
  }

  
  @Schema(example = "8", required = true, description = "Number of decimal places in the standard unit representation of the amount. For example, BTC has 8 decimals. Note that it is not possible to represent the value of some currency in atomic units that is not base 10.")
  @JsonProperty("decimals")
  public Integer getDecimals() {
    return decimals;
  }
  public void setDecimals(Integer decimals) {
    this.decimals = decimals;
  }

  /**
   * Any additional information related to the currency itself. For example, it would be useful to populate this object with the contract address of an ERC-20 token.
   **/
  public Currency metadata(Object metadata) {
    this.metadata = metadata;
    return this;
  }

  
  @Schema(example = "{\"Issuer\":\"Satoshi\"}", description = "Any additional information related to the currency itself. For example, it would be useful to populate this object with the contract address of an ERC-20 token.")
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
    Currency currency = (Currency) o;
    return Objects.equals(symbol, currency.symbol) &&
        Objects.equals(decimals, currency.decimals) &&
        Objects.equals(metadata, currency.metadata);
  }

  @Override
  public int hashCode() {
    return Objects.hash(symbol, decimals, metadata);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Currency {\n");
    sb.append("    symbol: ").append(toIndentedString(symbol)).append("\n");
    sb.append("    decimals: ").append(toIndentedString(decimals)).append("\n");
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
