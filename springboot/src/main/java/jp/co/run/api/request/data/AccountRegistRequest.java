package jp.co.run.api.request.data;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * Instantiates a new account regist request.
 */
@Data
public class AccountRegistRequest {

    /** The login id. */
    @JsonProperty("user_name")
    private String userName;

    /** The first name. */
    @JsonProperty("first_name")
    private String firstName;

    /** The last name. */
    @JsonProperty("last_name")
    private String lastName;

    /** The password. */
    @JsonProperty("password")
    private String password;

    /** The confirm password. */
    @JsonProperty("confirm_password")
    private String confirmPassword;

    /** The mail address. */
    @JsonProperty("email_address")
    private String emailAddress;

    /** The birthday. */
    @JsonProperty("birthday")
    private String birthday;

    /** The sex. */
    @JsonProperty("sex")
    private int sex;

    /** The address. */
    @JsonProperty("address")
    private String address;

    /** The phone. */
    @JsonProperty("phone")
    private String phone;
}
