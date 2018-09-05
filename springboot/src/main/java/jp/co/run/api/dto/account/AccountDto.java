package jp.co.run.api.dto.account;

import lombok.Data;

/**
 * Instantiates a new account dto.
 */
@Data
public class AccountDto {

    /** The user name. */
    private String userName;

    private String password;
    
    /** The first name. */
    private String firstName;

    /** The last name. */
    private String lastName;
    
    /** The role id. */
    private int roleId;

}
