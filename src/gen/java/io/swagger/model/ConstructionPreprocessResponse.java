package io.swagger.model;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.model.AccountIdentifier;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;


/**
 * ConstructionPreprocessResponse contains &#x60;options&#x60; that will be sent unmodified to &#x60;/construction/metadata&#x60;. If it is not necessary to make a request to &#x60;/construction/metadata&#x60;, &#x60;options&#x60; should be omitted.  Some blockchains require the PublicKey of particular AccountIdentifiers to construct a valid transaction. To fetch these PublicKeys, populate &#x60;required_public_keys&#x60; with the AccountIdentifiers associated with the desired PublicKeys. If it is not necessary to retrieve any PublicKeys for construction, &#x60;required_public_keys&#x60; should be omitted.
 **/
@Schema(description = "ConstructionPreprocessResponse contains `options` that will be sent unmodified to `/construction/metadata`. If it is not necessary to make a request to `/construction/metadata`, `options` should be omitted.  Some blockchains require the PublicKey of particular AccountIdentifiers to construct a valid transaction. To fetch these PublicKeys, populate `required_public_keys` with the AccountIdentifiers associated with the desired PublicKeys. If it is not necessary to retrieve any PublicKeys for construction, `required_public_keys` should be omitted.")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaInflectorServerCodegen", date = "2020-10-18T05:48:04.106Z[GMT]")
public class ConstructionPreprocessResponse   {
  @JsonProperty("options")
  private Object options = null;
  @JsonProperty("required_public_keys")
  private List<AccountIdentifier> requiredPublicKeys = null;
  /**
   * The options that will be sent directly to `/construction/metadata` by the caller.
   **/
  public ConstructionPreprocessResponse options(Object options) {
    this.options = options;
    return this;
  }

  
  @Schema(description = "The options that will be sent directly to `/construction/metadata` by the caller.")
  @JsonProperty("options")
  public Object getOptions() {
    return options;
  }
  public void setOptions(Object options) {
    this.options = options;
  }

  /**
   **/
  public ConstructionPreprocessResponse requiredPublicKeys(List<AccountIdentifier> requiredPublicKeys) {
    this.requiredPublicKeys = requiredPublicKeys;
    return this;
  }

  
  @Schema(description = "")
  @JsonProperty("required_public_keys")
  public List<AccountIdentifier> getRequiredPublicKeys() {
    return requiredPublicKeys;
  }
  public void setRequiredPublicKeys(List<AccountIdentifier> requiredPublicKeys) {
    this.requiredPublicKeys = requiredPublicKeys;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ConstructionPreprocessResponse constructionPreprocessResponse = (ConstructionPreprocessResponse) o;
    return Objects.equals(options, constructionPreprocessResponse.options) &&
        Objects.equals(requiredPublicKeys, constructionPreprocessResponse.requiredPublicKeys);
  }

  @Override
  public int hashCode() {
    return Objects.hash(options, requiredPublicKeys);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ConstructionPreprocessResponse {\n");
    sb.append("    options: ").append(toIndentedString(options)).append("\n");
    sb.append("    requiredPublicKeys: ").append(toIndentedString(requiredPublicKeys)).append("\n");
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
