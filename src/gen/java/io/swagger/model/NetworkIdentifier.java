package io.swagger.model;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.model.SubNetworkIdentifier;
import io.swagger.v3.oas.annotations.media.Schema;


/**
 * The network_identifier specifies which network a particular object is associated with.
 **/
@Schema(description = "The network_identifier specifies which network a particular object is associated with.")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaInflectorServerCodegen", date = "2020-11-12T07:15:46.859Z[GMT]")
public class NetworkIdentifier   {
  @JsonProperty("blockchain")
  private String blockchain = null;
  @JsonProperty("network")
  private String network = null;
  @JsonProperty("sub_network_identifier")
  private SubNetworkIdentifier subNetworkIdentifier = null;
  /**
   **/
  public NetworkIdentifier blockchain(String blockchain) {
    this.blockchain = blockchain;
    return this;
  }

  
  @Schema(example = "bitcoin", required = true, description = "")
  @JsonProperty("blockchain")
  public String getBlockchain() {
    return blockchain;
  }
  public void setBlockchain(String blockchain) {
    this.blockchain = blockchain;
  }

  /**
   * If a blockchain has a specific chain-id or network identifier, it should go in this field. It is up to the client to determine which network-specific identifier is mainnet or testnet.
   **/
  public NetworkIdentifier network(String network) {
    this.network = network;
    return this;
  }

  
  @Schema(example = "mainnet", required = true, description = "If a blockchain has a specific chain-id or network identifier, it should go in this field. It is up to the client to determine which network-specific identifier is mainnet or testnet.")
  @JsonProperty("network")
  public String getNetwork() {
    return network;
  }
  public void setNetwork(String network) {
    this.network = network;
  }

  /**
   **/
  public NetworkIdentifier subNetworkIdentifier(SubNetworkIdentifier subNetworkIdentifier) {
    this.subNetworkIdentifier = subNetworkIdentifier;
    return this;
  }

  
  @Schema(description = "")
  @JsonProperty("sub_network_identifier")
  public SubNetworkIdentifier getSubNetworkIdentifier() {
    return subNetworkIdentifier;
  }
  public void setSubNetworkIdentifier(SubNetworkIdentifier subNetworkIdentifier) {
    this.subNetworkIdentifier = subNetworkIdentifier;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NetworkIdentifier networkIdentifier = (NetworkIdentifier) o;
    return Objects.equals(blockchain, networkIdentifier.blockchain) &&
        Objects.equals(network, networkIdentifier.network) &&
        Objects.equals(subNetworkIdentifier, networkIdentifier.subNetworkIdentifier);
  }

  @Override
  public int hashCode() {
    return Objects.hash(blockchain, network, subNetworkIdentifier);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NetworkIdentifier {\n");
    sb.append("    blockchain: ").append(toIndentedString(blockchain)).append("\n");
    sb.append("    network: ").append(toIndentedString(network)).append("\n");
    sb.append("    subNetworkIdentifier: ").append(toIndentedString(subNetworkIdentifier)).append("\n");
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
