package jp.co.run.api.services.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.run.api.dao.SessionInfoDao;
import jp.co.run.api.dto.session.SessionInfoDto;
import jp.co.run.api.exception.CheckAuthInvalidException;
import jp.co.run.api.exception.CheckTokenExpiredException;
import jp.co.run.api.exception.InsertFailureException;
import jp.co.run.api.request.data.LoginRequest;
import jp.co.run.api.services.SessionInfoService;

@Service
public class SessionInfoServiceImpl implements SessionInfoService {

    @Autowired
    private SessionInfoDao sessionDao;

    @Override
    public void authByToken(String sessionToken) throws Exception {

        SessionInfoDto sessionInfoDto = sessionDao.getSessionInfoByToken(sessionToken);

        if(sessionInfoDto == null) {
            throw new CheckAuthInvalidException("sessionToken is empty.");
        }

        Date currentDate = new Date();
        Date expiredAt = sessionInfoDto.getSessionExpired();

        // Check token
        if(currentDate.compareTo(expiredAt) <= 0) {
            throw new CheckTokenExpiredException("sessionToken has expired.");
        }
    }

    @Override
    public int registToken(LoginRequest request, String token, Date expiredAt) throws Exception {

        int result = sessionDao.registToken(request, token, expiredAt);

        if (result == 0) {
            throw new InsertFailureException("Failed by insert error");
        }

        return result;
    }

    @Override
    public int updateToken(LoginRequest request, String token, Date expiredAt) throws Exception {
        return sessionDao.updateToken(request, token, expiredAt);
    }

    @Override
    public boolean getTokenByUser(String userName) throws Exception {

        if (sessionDao.getTokenByUser(userName) == 0) {
            return false;
        }

        return true;
    }

}
