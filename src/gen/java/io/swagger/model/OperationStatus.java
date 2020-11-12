package io.swagger.model;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;


/**
 * OperationStatus is utilized to indicate which Operation status are considered successful.
 **/
@Schema(description = "OperationStatus is utilized to indicate which Operation status are considered successful.")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaInflectorServerCodegen", date = "2020-11-12T07:15:46.859Z[GMT]")
public class OperationStatus   {
  @JsonProperty("status")
  private String status = null;
  @JsonProperty("successful")
  private Boolean successful = null;
  /**
   * The status is the network-specific status of the operation.
   **/
  public OperationStatus status(String status) {
    this.status = status;
    return this;
  }

  
  @Schema(required = true, description = "The status is the network-specific status of the operation.")
  @JsonProperty("status")
  public String getStatus() {
    return status;
  }
  public void setStatus(String status) {
    this.status = status;
  }

  /**
   * An Operation is considered successful if the Operation.Amount should affect the Operation.Account. Some blockchains (like Bitcoin) only include successful operations in blocks but other blockchains (like Ethereum) include unsuccessful operations that incur a fee. To reconcile the computed balance from the stream of Operations, it is critical to understand which Operation.Status indicate an Operation is successful and should affect an Account.
   **/
  public OperationStatus successful(Boolean successful) {
    this.successful = successful;
    return this;
  }

  
  @Schema(required = true, description = "An Operation is considered successful if the Operation.Amount should affect the Operation.Account. Some blockchains (like Bitcoin) only include successful operations in blocks but other blockchains (like Ethereum) include unsuccessful operations that incur a fee. To reconcile the computed balance from the stream of Operations, it is critical to understand which Operation.Status indicate an Operation is successful and should affect an Account.")
  @JsonProperty("successful")
  public Boolean isSuccessful() {
    return successful;
  }
  public void setSuccessful(Boolean successful) {
    this.successful = successful;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OperationStatus operationStatus = (OperationStatus) o;
    return Objects.equals(status, operationStatus.status) &&
        Objects.equals(successful, operationStatus.successful);
  }

  @Override
  public int hashCode() {
    return Objects.hash(status, successful);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OperationStatus {\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    successful: ").append(toIndentedString(successful)).append("\n");
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
