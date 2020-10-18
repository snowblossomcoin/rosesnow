package io.swagger.model;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.model.CurveType;
import io.swagger.v3.oas.annotations.media.Schema;


/**
 * PublicKey contains a public key byte array for a particular CurveType encoded in hex. Note that there is no PrivateKey struct as this is NEVER the concern of an implementation.
 **/
@Schema(description = "PublicKey contains a public key byte array for a particular CurveType encoded in hex. Note that there is no PrivateKey struct as this is NEVER the concern of an implementation.")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaInflectorServerCodegen", date = "2020-10-18T05:48:04.106Z[GMT]")
public class PublicKey   {
  @JsonProperty("hex_bytes")
  private String hexBytes = null;
  @JsonProperty("curve_type")
  private CurveType curveType = null;
  /**
   * Hex-encoded public key bytes in the format specified by the CurveType.
   **/
  public PublicKey hexBytes(String hexBytes) {
    this.hexBytes = hexBytes;
    return this;
  }

  
  @Schema(required = true, description = "Hex-encoded public key bytes in the format specified by the CurveType.")
  @JsonProperty("hex_bytes")
  public String getHexBytes() {
    return hexBytes;
  }
  public void setHexBytes(String hexBytes) {
    this.hexBytes = hexBytes;
  }

  /**
   **/
  public PublicKey curveType(CurveType curveType) {
    this.curveType = curveType;
    return this;
  }

  
  @Schema(required = true, description = "")
  @JsonProperty("curve_type")
  public CurveType getCurveType() {
    return curveType;
  }
  public void setCurveType(CurveType curveType) {
    this.curveType = curveType;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PublicKey publicKey = (PublicKey) o;
    return Objects.equals(hexBytes, publicKey.hexBytes) &&
        Objects.equals(curveType, publicKey.curveType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(hexBytes, curveType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PublicKey {\n");
    sb.append("    hexBytes: ").append(toIndentedString(hexBytes)).append("\n");
    sb.append("    curveType: ").append(toIndentedString(curveType)).append("\n");
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
