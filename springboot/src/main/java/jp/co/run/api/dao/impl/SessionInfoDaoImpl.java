package jp.co.run.api.dao.impl;

import java.math.BigInteger;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jp.co.run.api.dao.CommonDao;
import jp.co.run.api.dao.SessionInfoDao;
import jp.co.run.api.request.data.LoginRequest;
import jp.co.run.api.util.SqlFileReaderUtil;

@Component
public class SessionInfoDaoImpl implements SessionInfoDao {

    /** The common dao. */
    @Autowired
    private CommonDao commonDao;

    private static final String SQL_INSERT_SESSION_INFO = "/session_info/insert_session_info.sql";

    @Override
    public int registToken(LoginRequest request, String token) throws Exception {

        // Get content of sql
        String sqlQuery = SqlFileReaderUtil.getSql(SQL_INSERT_SESSION_INFO);

        Date nowDate = new Date();
        Long nowDateLong = nowDate.getTime();
        Long expiredAtLong = nowDateLong;

        Map<String, Object> mapParam = new HashMap<String, Object>();
        mapParam.put("userName", request.getUserName());
        mapParam.put("sessionToken", token);
        mapParam.put("sessionExpired", expiredAtLong);
        mapParam.put("registUser", request.getUserName());
        mapParam.put("registTime", nowDate);
        mapParam.put("updateUser", null);
        mapParam.put("updateTime", null);
        mapParam.put("deleteFlag", 0);

        return commonDao.insert(sqlQuery, BigInteger.class, mapParam);
    }

    @Override
    public int updateToken(LoginRequest request, String token) throws Exception {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int getTokenByUser(LoginRequest request) throws Exception {
        // TODO Auto-generated method stub
        return 0;
    }

}
