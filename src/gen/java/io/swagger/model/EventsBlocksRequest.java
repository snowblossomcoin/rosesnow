package io.swagger.model;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.model.NetworkIdentifier;
import io.swagger.v3.oas.annotations.media.Schema;


/**
 * EventsBlocksRequest is utilized to fetch a sequence of BlockEvents indicating which blocks were added and removed from storage to reach the current state.
 **/
@Schema(description = "EventsBlocksRequest is utilized to fetch a sequence of BlockEvents indicating which blocks were added and removed from storage to reach the current state.")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaInflectorServerCodegen", date = "2020-11-12T07:15:46.859Z[GMT]")
public class EventsBlocksRequest   {
  @JsonProperty("network_identifier")
  private NetworkIdentifier networkIdentifier = null;
  @JsonProperty("offset")
  private Long offset = null;
  @JsonProperty("limit")
  private Long limit = null;
  /**
   **/
  public EventsBlocksRequest networkIdentifier(NetworkIdentifier networkIdentifier) {
    this.networkIdentifier = networkIdentifier;
    return this;
  }

  
  @Schema(required = true, description = "")
  @JsonProperty("network_identifier")
  public NetworkIdentifier getNetworkIdentifier() {
    return networkIdentifier;
  }
  public void setNetworkIdentifier(NetworkIdentifier networkIdentifier) {
    this.networkIdentifier = networkIdentifier;
  }

  /**
   * offset is the offset into the event stream to sync events from. If this field is not populated, we return the limit events backwards from tip. If this is set to 0, we start from the beginning.
   * minimum: 0
   **/
  public EventsBlocksRequest offset(Long offset) {
    this.offset = offset;
    return this;
  }

  
  @Schema(example = "5", description = "offset is the offset into the event stream to sync events from. If this field is not populated, we return the limit events backwards from tip. If this is set to 0, we start from the beginning.")
  @JsonProperty("offset")
  public Long getOffset() {
    return offset;
  }
  public void setOffset(Long offset) {
    this.offset = offset;
  }

  /**
   * limit is the maximum number of events to fetch in one call. The implementation may return <= limit events.
   * minimum: 0
   **/
  public EventsBlocksRequest limit(Long limit) {
    this.limit = limit;
    return this;
  }

  
  @Schema(example = "5", description = "limit is the maximum number of events to fetch in one call. The implementation may return <= limit events.")
  @JsonProperty("limit")
  public Long getLimit() {
    return limit;
  }
  public void setLimit(Long limit) {
    this.limit = limit;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EventsBlocksRequest eventsBlocksRequest = (EventsBlocksRequest) o;
    return Objects.equals(networkIdentifier, eventsBlocksRequest.networkIdentifier) &&
        Objects.equals(offset, eventsBlocksRequest.offset) &&
        Objects.equals(limit, eventsBlocksRequest.limit);
  }

  @Override
  public int hashCode() {
    return Objects.hash(networkIdentifier, offset, limit);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EventsBlocksRequest {\n");
    sb.append("    networkIdentifier: ").append(toIndentedString(networkIdentifier)).append("\n");
    sb.append("    offset: ").append(toIndentedString(offset)).append("\n");
    sb.append("    limit: ").append(toIndentedString(limit)).append("\n");
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
