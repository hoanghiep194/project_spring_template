package jp.co.run.api.services;

import java.util.Date;

import jp.co.run.api.request.data.LoginRequest;

/**
 * The Interface SessionInfoService.
 */
public interface SessionInfoService {

    /**
     * Auth by token.
     *
     * @param sessionToken the session token
     * @return the session info dto
     * @throws Exception the exception
     */
    public void authByToken(final String sessionToken) throws Exception;

    /**
     * Regist token.
     *
     * @param request the request
     * @param token the token
     * @return the int
     * @throws Exception the exception
     */
    public int registToken(final LoginRequest request,final String token, final Date expiredAt) throws Exception;

    /**
     * Update token.
     *
     * @param request the request
     * @param token the token
     * @return the int
     * @throws Exception the exception
     */
    public int updateToken(final LoginRequest request,final String token, final Date expiredAt) throws Exception;

    /**
     * Gets the token by user.
     *
     * @param request the request
     * @return the token by user
     * @throws Exception the exception
     */
    public boolean getTokenByUser(final String userName) throws Exception;
}
