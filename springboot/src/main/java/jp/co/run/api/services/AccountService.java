package jp.co.run.api.services;

import jp.co.run.api.request.data.AccountRegistRequest;
import jp.co.run.api.request.data.LoginRequest;
import jp.co.run.api.response.data.CommonListResponseData;

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
    public CommonListResponseData login(final LoginRequest loginRequest) throws Exception;

    /**
     * Regist.
     *
     * @param request the request
     * @return the int
     * @throws Exception the exception
     */
    public int regist (final AccountRegistRequest request) throws Exception;
}
