package io.swagger.model;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;


/**
 * SyncStatus is used to provide additional context about an implementation&#x27;s sync status. It is often used to indicate that an implementation is healthy when it cannot be queried  until some sync phase occurs. If an implementation is immediately queryable, this model is often not populated.
 **/
@Schema(description = "SyncStatus is used to provide additional context about an implementation's sync status. It is often used to indicate that an implementation is healthy when it cannot be queried  until some sync phase occurs. If an implementation is immediately queryable, this model is often not populated.")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaInflectorServerCodegen", date = "2020-11-12T07:15:46.859Z[GMT]")
public class SyncStatus   {
  @JsonProperty("current_index")
  private Long currentIndex = null;
  @JsonProperty("target_index")
  private Long targetIndex = null;
  @JsonProperty("stage")
  private String stage = null;
  /**
   * CurrentIndex is the index of the last synced block in the current stage.
   **/
  public SyncStatus currentIndex(Long currentIndex) {
    this.currentIndex = currentIndex;
    return this;
  }

  
  @Schema(example = "100", required = true, description = "CurrentIndex is the index of the last synced block in the current stage.")
  @JsonProperty("current_index")
  public Long getCurrentIndex() {
    return currentIndex;
  }
  public void setCurrentIndex(Long currentIndex) {
    this.currentIndex = currentIndex;
  }

  /**
   * TargetIndex is the index of the block that the implementation is attempting to sync to in the current stage.
   **/
  public SyncStatus targetIndex(Long targetIndex) {
    this.targetIndex = targetIndex;
    return this;
  }

  
  @Schema(example = "150", description = "TargetIndex is the index of the block that the implementation is attempting to sync to in the current stage.")
  @JsonProperty("target_index")
  public Long getTargetIndex() {
    return targetIndex;
  }
  public void setTargetIndex(Long targetIndex) {
    this.targetIndex = targetIndex;
  }

  /**
   * Stage is the phase of the sync process.
   **/
  public SyncStatus stage(String stage) {
    this.stage = stage;
    return this;
  }

  
  @Schema(example = "header sync", description = "Stage is the phase of the sync process.")
  @JsonProperty("stage")
  public String getStage() {
    return stage;
  }
  public void setStage(String stage) {
    this.stage = stage;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SyncStatus syncStatus = (SyncStatus) o;
    return Objects.equals(currentIndex, syncStatus.currentIndex) &&
        Objects.equals(targetIndex, syncStatus.targetIndex) &&
        Objects.equals(stage, syncStatus.stage);
  }

  @Override
  public int hashCode() {
    return Objects.hash(currentIndex, targetIndex, stage);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SyncStatus {\n");
    sb.append("    currentIndex: ").append(toIndentedString(currentIndex)).append("\n");
    sb.append("    targetIndex: ").append(toIndentedString(targetIndex)).append("\n");
    sb.append("    stage: ").append(toIndentedString(stage)).append("\n");
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
