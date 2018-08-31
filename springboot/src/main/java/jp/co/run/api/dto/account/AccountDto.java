package jp.co.run.api.dto.account;

import lombok.Data;

/**
 * Instantiates a new account dto.
 */
@Data
public class AccountDto {

    /** The user name. */
    private String userName;

    /** The role id. */
    private int roleId;

}
