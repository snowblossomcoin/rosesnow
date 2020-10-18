package io.swagger.model;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.model.BlockIdentifier;
import io.swagger.model.Peer;
import io.swagger.model.SyncStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


/**
 * NetworkStatusResponse contains basic information about the node&#x27;s view of a blockchain network. It is assumed that any BlockIdentifier.Index less than or equal to CurrentBlockIdentifier.Index can be queried.  If a Rosetta implementation prunes historical state, it should populate the optional &#x60;oldest_block_identifier&#x60; field with the oldest block available to query. If this is not populated, it is assumed that the &#x60;genesis_block_identifier&#x60; is the oldest queryable block.  If a Rosetta implementation performs some pre-sync before it is possible to query blocks, sync_status should be populated so that clients can still monitor healthiness. Without this field, it may appear that the implementation is stuck syncing and needs to be terminated. 
 **/
@Schema(description = "NetworkStatusResponse contains basic information about the node's view of a blockchain network. It is assumed that any BlockIdentifier.Index less than or equal to CurrentBlockIdentifier.Index can be queried.  If a Rosetta implementation prunes historical state, it should populate the optional `oldest_block_identifier` field with the oldest block available to query. If this is not populated, it is assumed that the `genesis_block_identifier` is the oldest queryable block.  If a Rosetta implementation performs some pre-sync before it is possible to query blocks, sync_status should be populated so that clients can still monitor healthiness. Without this field, it may appear that the implementation is stuck syncing and needs to be terminated. ")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaInflectorServerCodegen", date = "2020-10-15T17:54:45.833Z[GMT]")
public class NetworkStatusResponse   {
  @JsonProperty("current_block_identifier")
  private BlockIdentifier currentBlockIdentifier = null;
  @JsonProperty("current_block_timestamp")
  private Timestamp currentBlockTimestamp = null;
  @JsonProperty("genesis_block_identifier")
  private BlockIdentifier genesisBlockIdentifier = null;
  @JsonProperty("oldest_block_identifier")
  private BlockIdentifier oldestBlockIdentifier = null;
  @JsonProperty("sync_status")
  private SyncStatus syncStatus = null;
  @JsonProperty("peers")
  private List<Peer> peers = new ArrayList<>();
  /**
   **/
  public NetworkStatusResponse currentBlockIdentifier(BlockIdentifier currentBlockIdentifier) {
    this.currentBlockIdentifier = currentBlockIdentifier;
    return this;
  }

  
  @Schema(required = true, description = "")
  @JsonProperty("current_block_identifier")
  public BlockIdentifier getCurrentBlockIdentifier() {
    return currentBlockIdentifier;
  }
  public void setCurrentBlockIdentifier(BlockIdentifier currentBlockIdentifier) {
    this.currentBlockIdentifier = currentBlockIdentifier;
  }

  /**
   **/
  public NetworkStatusResponse currentBlockTimestamp(Timestamp currentBlockTimestamp) {
    this.currentBlockTimestamp = currentBlockTimestamp;
    return this;
  }

  
  @Schema(required = true, description = "")
  @JsonProperty("current_block_timestamp")
  public Timestamp getCurrentBlockTimestamp() {
    return currentBlockTimestamp;
  }
  public void setCurrentBlockTimestamp(Timestamp currentBlockTimestamp) {
    this.currentBlockTimestamp = currentBlockTimestamp;
  }

  /**
   **/
  public NetworkStatusResponse genesisBlockIdentifier(BlockIdentifier genesisBlockIdentifier) {
    this.genesisBlockIdentifier = genesisBlockIdentifier;
    return this;
  }

  
  @Schema(required = true, description = "")
  @JsonProperty("genesis_block_identifier")
  public BlockIdentifier getGenesisBlockIdentifier() {
    return genesisBlockIdentifier;
  }
  public void setGenesisBlockIdentifier(BlockIdentifier genesisBlockIdentifier) {
    this.genesisBlockIdentifier = genesisBlockIdentifier;
  }

  /**
   **/
  public NetworkStatusResponse oldestBlockIdentifier(BlockIdentifier oldestBlockIdentifier) {
    this.oldestBlockIdentifier = oldestBlockIdentifier;
    return this;
  }

  
  @Schema(description = "")
  @JsonProperty("oldest_block_identifier")
  public BlockIdentifier getOldestBlockIdentifier() {
    return oldestBlockIdentifier;
  }
  public void setOldestBlockIdentifier(BlockIdentifier oldestBlockIdentifier) {
    this.oldestBlockIdentifier = oldestBlockIdentifier;
  }

  /**
   **/
  public NetworkStatusResponse syncStatus(SyncStatus syncStatus) {
    this.syncStatus = syncStatus;
    return this;
  }

  
  @Schema(description = "")
  @JsonProperty("sync_status")
  public SyncStatus getSyncStatus() {
    return syncStatus;
  }
  public void setSyncStatus(SyncStatus syncStatus) {
    this.syncStatus = syncStatus;
  }

  /**
   **/
  public NetworkStatusResponse peers(List<Peer> peers) {
    this.peers = peers;
    return this;
  }

  
  @Schema(required = true, description = "")
  @JsonProperty("peers")
  public List<Peer> getPeers() {
    return peers;
  }
  public void setPeers(List<Peer> peers) {
    this.peers = peers;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NetworkStatusResponse networkStatusResponse = (NetworkStatusResponse) o;
    return Objects.equals(currentBlockIdentifier, networkStatusResponse.currentBlockIdentifier) &&
        Objects.equals(currentBlockTimestamp, networkStatusResponse.currentBlockTimestamp) &&
        Objects.equals(genesisBlockIdentifier, networkStatusResponse.genesisBlockIdentifier) &&
        Objects.equals(oldestBlockIdentifier, networkStatusResponse.oldestBlockIdentifier) &&
        Objects.equals(syncStatus, networkStatusResponse.syncStatus) &&
        Objects.equals(peers, networkStatusResponse.peers);
  }

  @Override
  public int hashCode() {
    return Objects.hash(currentBlockIdentifier, currentBlockTimestamp, genesisBlockIdentifier, oldestBlockIdentifier, syncStatus, peers);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NetworkStatusResponse {\n");
    sb.append("    currentBlockIdentifier: ").append(toIndentedString(currentBlockIdentifier)).append("\n");
    sb.append("    currentBlockTimestamp: ").append(toIndentedString(currentBlockTimestamp)).append("\n");
    sb.append("    genesisBlockIdentifier: ").append(toIndentedString(genesisBlockIdentifier)).append("\n");
    sb.append("    oldestBlockIdentifier: ").append(toIndentedString(oldestBlockIdentifier)).append("\n");
    sb.append("    syncStatus: ").append(toIndentedString(syncStatus)).append("\n");
    sb.append("    peers: ").append(toIndentedString(peers)).append("\n");
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
