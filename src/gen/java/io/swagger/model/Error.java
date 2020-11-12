package io.swagger.model;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;


/**
 * Instead of utilizing HTTP status codes to describe node errors (which often do not have a good analog), rich errors are returned using this object. Both the code and message fields can be individually used to correctly identify an error. Implementations MUST use unique values for both fields.
 **/
@Schema(description = "Instead of utilizing HTTP status codes to describe node errors (which often do not have a good analog), rich errors are returned using this object. Both the code and message fields can be individually used to correctly identify an error. Implementations MUST use unique values for both fields.")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaInflectorServerCodegen", date = "2020-11-12T07:15:46.859Z[GMT]")
public class Error   {
  @JsonProperty("code")
  private Integer code = null;
  @JsonProperty("message")
  private String message = null;
  @JsonProperty("description")
  private String description = null;
  @JsonProperty("retriable")
  private Boolean retriable = null;
  @JsonProperty("details")
  private Object details = null;
  /**
   * Code is a network-specific error code. If desired, this code can be equivalent to an HTTP status code.
   * minimum: 0
   **/
  public Error code(Integer code) {
    this.code = code;
    return this;
  }

  
  @Schema(example = "12", required = true, description = "Code is a network-specific error code. If desired, this code can be equivalent to an HTTP status code.")
  @JsonProperty("code")
  public Integer getCode() {
    return code;
  }
  public void setCode(Integer code) {
    this.code = code;
  }

  /**
   * Message is a network-specific error message. The message MUST NOT change for a given code. In particular, this means that any contextual information should be included in the details field.
   **/
  public Error message(String message) {
    this.message = message;
    return this;
  }

  
  @Schema(example = "Invalid account format", required = true, description = "Message is a network-specific error message. The message MUST NOT change for a given code. In particular, this means that any contextual information should be included in the details field.")
  @JsonProperty("message")
  public String getMessage() {
    return message;
  }
  public void setMessage(String message) {
    this.message = message;
  }

  /**
   * Description allows the implementer to optionally provide additional information about an error. In many cases, the content of this field will be a copy-and-paste from existing developer documentation. Description can ONLY be populated with generic information about a particular type of error. It MUST NOT be populated with information about a particular instantiation of an error (use `details` for this). Whereas the content of Error.Message should stay stable across releases, the content of Error.Description will likely change across releases (as implementers improve error documentation). For this reason, the content in this field is not part of any type assertion (unlike Error.Message).
   **/
  public Error description(String description) {
    this.description = description;
    return this;
  }

  
  @Schema(example = "This error is returned when the requested AccountIdentifier is improperly formatted.", description = "Description allows the implementer to optionally provide additional information about an error. In many cases, the content of this field will be a copy-and-paste from existing developer documentation. Description can ONLY be populated with generic information about a particular type of error. It MUST NOT be populated with information about a particular instantiation of an error (use `details` for this). Whereas the content of Error.Message should stay stable across releases, the content of Error.Description will likely change across releases (as implementers improve error documentation). For this reason, the content in this field is not part of any type assertion (unlike Error.Message).")
  @JsonProperty("description")
  public String getDescription() {
    return description;
  }
  public void setDescription(String description) {
    this.description = description;
  }

  /**
   * An error is retriable if the same request may succeed if submitted again.
   **/
  public Error retriable(Boolean retriable) {
    this.retriable = retriable;
    return this;
  }

  
  @Schema(required = true, description = "An error is retriable if the same request may succeed if submitted again.")
  @JsonProperty("retriable")
  public Boolean isRetriable() {
    return retriable;
  }
  public void setRetriable(Boolean retriable) {
    this.retriable = retriable;
  }

  /**
   * Often times it is useful to return context specific to the request that caused the error (i.e. a sample of the stack trace or impacted account) in addition to the standard error message.
   **/
  public Error details(Object details) {
    this.details = details;
    return this;
  }

  
  @Schema(example = "{\"address\":\"0x1dcc4de8dec75d7aab85b567b6\",\"error\":\"not base64\"}", description = "Often times it is useful to return context specific to the request that caused the error (i.e. a sample of the stack trace or impacted account) in addition to the standard error message.")
  @JsonProperty("details")
  public Object getDetails() {
    return details;
  }
  public void setDetails(Object details) {
    this.details = details;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Error error = (Error) o;
    return Objects.equals(code, error.code) &&
        Objects.equals(message, error.message) &&
        Objects.equals(description, error.description) &&
        Objects.equals(retriable, error.retriable) &&
        Objects.equals(details, error.details);
  }

  @Override
  public int hashCode() {
    return Objects.hash(code, message, description, retriable, details);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Error {\n");
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    retriable: ").append(toIndentedString(retriable)).append("\n");
    sb.append("    details: ").append(toIndentedString(details)).append("\n");
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
