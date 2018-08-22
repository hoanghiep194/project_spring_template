package jp.co.run.api.request.data;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * Instantiates a new login request.
 */
@Data
public class LoginRequest {
    
    /** The login id. */
    @JsonProperty("login_id")
    private String loginId;
    
    /** The password. */
    @JsonProperty("password")
    private String password;
}
