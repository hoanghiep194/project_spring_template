package jp.co.run.api.dto.account;

import java.util.Date;

import lombok.Data;

/**
 * Instantiates a new user info dto.
 */
@Data
public class UserInfoDto {

    /** The user name. */
    private String userName;

    /** The first name. */
    private String firstName;

    /** The last name. */
    private String lastName;

    /** The birthday. */
    private Date birthday;

    /** The sex. */
    private int sex;

    /** The email address. */
    private String emailAddress;

    /** The address. */
    private String address;

    /** The phone. */
    private String phone;
}
