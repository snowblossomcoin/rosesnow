package io.swagger.model;
import java.util.Objects;
import io.swagger.v3.oas.annotations.media.Schema;
import com.fasterxml.jackson.annotation.JsonValue;


/**
 * SignatureType is the type of a cryptographic signature. * ecdsa: &#x60;r (32-bytes) || s (32-bytes)&#x60; - &#x60;64 bytes&#x60; * ecdsa_recovery: &#x60;r (32-bytes) || s (32-bytes) || v (1-byte)&#x60; - &#x60;65 bytes&#x60; * ed25519: &#x60;R (32-byte) || s (32-bytes)&#x60; - &#x60;64 bytes&#x60; * schnorr_1: &#x60;r (32-bytes) || s (32-bytes)&#x60; - &#x60;64 bytes&#x60;  (schnorr signature implemented by Zilliqa where both &#x60;r&#x60; and &#x60;s&#x60; are scalars encoded as &#x60;32-bytes&#x60; values, most significant byte first.) * schnorr_poseidon: &#x60;r (32-bytes) || s (32-bytes)&#x60; where s &#x3D; Hash(1st pk || 2nd pk || r) - &#x60;64 bytes&#x60;  (schnorr signature w/ Poseidon hash function implemented by O(1) Labs where both &#x60;r&#x60; and &#x60;s&#x60; are scalars encoded as &#x60;32-bytes&#x60; values, least significant byte first. https://github.com/CodaProtocol/signer-reference/blob/master/schnorr.ml )
 **/
import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * SignatureType is the type of a cryptographic signature. * ecdsa: `r (32-bytes) || s (32-bytes)` - `64 bytes` * ecdsa_recovery: `r (32-bytes) || s (32-bytes) || v (1-byte)` - `65 bytes` * ed25519: `R (32-byte) || s (32-bytes)` - `64 bytes` * schnorr_1: `r (32-bytes) || s (32-bytes)` - `64 bytes`  (schnorr signature implemented by Zilliqa where both `r` and `s` are scalars encoded as `32-bytes` values, most significant byte first.) * schnorr_poseidon: `r (32-bytes) || s (32-bytes)` where s = Hash(1st pk || 2nd pk || r) - `64 bytes`  (schnorr signature w/ Poseidon hash function implemented by O(1) Labs where both `r` and `s` are scalars encoded as `32-bytes` values, least significant byte first. https://github.com/CodaProtocol/signer-reference/blob/master/schnorr.ml )
 */
public enum SignatureType {
  ECDSA("ecdsa"),
  
  ECDSA_RECOVERY("ecdsa_recovery"),
  
  ED25519("ed25519"),
  
  SCHNORR_1("schnorr_1"),
  
  SCHNORR_POSEIDON("schnorr_poseidon");

  private String value;

  SignatureType(String value) {
    this.value = value;
  }

  @Override
  @JsonValue
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static SignatureType fromValue(String text) {
    for (SignatureType b : SignatureType.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }
}
