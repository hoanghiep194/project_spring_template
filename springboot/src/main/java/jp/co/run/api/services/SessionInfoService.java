package jp.co.run.api.services;

import jp.co.run.api.dto.session.SessionInfoDto;
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
    public SessionInfoDto authByToken(String sessionToken) throws Exception;

    /**
     * Regist token.
     *
     * @param request the request
     * @param token the token
     * @return the int
     * @throws Exception the exception
     */
    public int registToken(LoginRequest request, String token) throws Exception;

    /**
     * Update token.
     *
     * @param request the request
     * @param token the token
     * @return the int
     * @throws Exception the exception
     */
    public int updateToken(LoginRequest request, String token) throws Exception;

    /**
     * Gets the token by user.
     *
     * @param request the request
     * @return the token by user
     * @throws Exception the exception
     */
    public boolean getTokenByUser(final LoginRequest request) throws Exception;
}
