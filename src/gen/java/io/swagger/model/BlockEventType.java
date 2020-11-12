package io.swagger.model;
import java.util.Objects;
import io.swagger.v3.oas.annotations.media.Schema;
import com.fasterxml.jackson.annotation.JsonValue;


/**
 * BlockEventType determines if a BlockEvent represents the addition or removal of a block.
 **/
import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * BlockEventType determines if a BlockEvent represents the addition or removal of a block.
 */
public enum BlockEventType {
  ADDED("block_added"),
  
  REMOVED("block_removed");

  private String value;

  BlockEventType(String value) {
    this.value = value;
  }

  @Override
  @JsonValue
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static BlockEventType fromValue(String text) {
    for (BlockEventType b : BlockEventType.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }
}
