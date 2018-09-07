package jp.co.run.api.dao.impl;

import java.math.BigInteger;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jp.co.run.api.dao.CommonDao;
import jp.co.run.api.dao.SessionInfoDao;
import jp.co.run.api.dto.session.SessionInfoDto;
import jp.co.run.api.request.data.LoginRequest;
import jp.co.run.api.util.SqlFileReaderUtil;

@Component
public class SessionInfoDaoImpl implements SessionInfoDao {

    /** The common dao. */
    @Autowired
    private CommonDao commonDao;

    private static final String SQL_INSERT_SESSION_INFO = "/session_info/insert_session_info.sql";

    private static final String SQL_SELECT_SESSION_TOKEN_BY_USER = "/session_info/select_session_token_by_user.sql";

    private static final String SQL_UPDATE_SESSION_TOKEN = "/session_info/update_session_token.sql";

    private static final String SQL_SELECT_SESSION_INFO_BY_TOKEN = "/session_info/select_session_info_by_token.sql";

    @Override
    public int registToken(LoginRequest request, String token, Date expiredAt) throws Exception {

        // Get content of sql
        String sqlQuery = SqlFileReaderUtil.getSql(SQL_INSERT_SESSION_INFO);

        Map<String, Object> mapParam = new HashMap<String, Object>();
        mapParam.put("userName", request.getUserName());
        mapParam.put("sessionToken", token);
        mapParam.put("sessionExpired", expiredAt);
        mapParam.put("registUser", request.getUserName());
        mapParam.put("registTime", new Date());
        mapParam.put("updateUser", null);
        mapParam.put("updateTime", null);
        mapParam.put("deleteFlag", 0);

        return commonDao.insert(sqlQuery, BigInteger.class, mapParam);
    }

    @Override
    public int updateToken(LoginRequest request, String token, Date expiredAt) throws Exception {

        // Get content of sql
        String sqlQuery = SqlFileReaderUtil.getSql(SQL_UPDATE_SESSION_TOKEN);

        Map<String, Object> mapParam = new HashMap<String, Object>();
        mapParam.put("userName", request.getUserName());
        mapParam.put("token", token);
        mapParam.put("expiredAt", expiredAt);

        return commonDao.update(sqlQuery, BigInteger.class, mapParam);
    }

    @Override
    public int getTokenByUser(String userName) throws Exception {

        // Get content of sql
        String sqlQuery = SqlFileReaderUtil.getSql(SQL_SELECT_SESSION_TOKEN_BY_USER);

        Map<String, Object> mapParam = new HashMap<String, Object>();
        mapParam.put("userName", userName);

        return commonDao.select(sqlQuery, mapParam);
    }

    @Override
    public SessionInfoDto getSessionInfoByToken(String token) throws Exception {

        SessionInfoDto sessionInfoDto = null;
        // Get content of sql
        String sqlQuery = SqlFileReaderUtil.getSql(SQL_SELECT_SESSION_INFO_BY_TOKEN);

        Map<String, Object> mapParam = new HashMap<String, Object>();
        mapParam.put("token", token);

        List<SessionInfoDto> sessionInfoList = commonDao.select(sqlQuery, SessionInfoDto.class, mapParam);

        if(sessionInfoList.size() == 0) {
            return sessionInfoDto;
        }

        return sessionInfoList.get(0);
    }

}
