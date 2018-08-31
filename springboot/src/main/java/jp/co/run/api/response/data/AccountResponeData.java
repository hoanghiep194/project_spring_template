package jp.co.run.api.response.data;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class AccountResponeData {
    /** The user name. */
    @JsonProperty("user_name")
    private String userName;

    /** The password. */
    @JsonProperty("password")
    private String password;

    /** The role id. */
    @JsonProperty("role_id")
    private int roleId;

    /** The first name. */
    @JsonProperty("first_name")
    private String firstName;

    /** The last name. */
    @JsonProperty("last_name")
    private String lastName;
}
