package jp.co.run.api.services;

import jp.co.run.api.dto.account.AccountDto;
import jp.co.run.api.request.data.AccountRegistRequest;
import jp.co.run.api.request.data.LoginRequest;

/**
 * The Interface AccountService.
 */
public interface AccountService {

    /**
     * Login.
     *
     * @param loginRequest the login request
     * @return the account dto
     * @throws Exception the exception
     */
    public AccountDto login(final LoginRequest loginRequest) throws Exception;

    /**
     * Regist.
     *
     * @param request the request
     * @return the int
     * @throws Exception the exception
     */
    public int regist (final AccountRegistRequest request) throws Exception;
}
