package jp.co.run.api.dao;

import java.util.Date;

import jp.co.run.api.dto.session.SessionInfoDto;
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
    public int registToken(final LoginRequest request, final String token, final Date expiredAt) throws Exception;

    /**
     * Update token.
     *
     * @param request the request
     * @param token the token
     * @return the int
     * @throws Exception the exception
     */
    public int updateToken(final LoginRequest request, final String token, final Date expiredAt) throws Exception;

    /**
     * Gets the token by user.
     *
     * @param request the request
     * @return the token by user
     * @throws Exception the exception
     */
    public int getTokenByUser(final String userName) throws Exception;

    public SessionInfoDto getSessionInfoByToken (final String token) throws Exception;
}
