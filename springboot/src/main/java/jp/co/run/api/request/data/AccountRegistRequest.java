package jp.co.run.api.request.data;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class AccountRegistRequest {

    /** The login id. */
    @JsonProperty("user_name")
    private String userName;
    
    /** The password. */
    @JsonProperty("password")
    private String password;
    
    @JsonProperty("mail_address")
    private String mailAddress;
}
