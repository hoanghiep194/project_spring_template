package jp.co.run.api.dao;

import jp.co.run.api.request.data.LoginRequest;

/**
 * The Interface SessionInfoDao.
 */
public interface SessionInfoDao {
    
    /**
     * Regist token.
     *
     * @param request the request
     * @param token the token
     * @return the int
     * @throws Exception the exception
     */
    public int registToken(final LoginRequest request, final String token) throws Exception;

    /**
     * Update token.
     *
     * @param request the request
     * @param token the token
     * @return the int
     * @throws Exception the exception
     */
    public int updateToken(final LoginRequest request, final String token) throws Exception;

    /**
     * Gets the token by user.
     *
     * @param request the request
     * @return the token by user
     * @throws Exception the exception
     */
    public int getTokenByUser(final LoginRequest request) throws Exception;
}
