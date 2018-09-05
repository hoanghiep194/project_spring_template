package jp.co.run.api.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.run.api.dao.SessionInfoDao;
import jp.co.run.api.dto.session.SessionInfoDto;
import jp.co.run.api.exception.InsertFailureException;
import jp.co.run.api.request.data.LoginRequest;
import jp.co.run.api.services.SessionInfoService;

@Service
public class SessionInfoServiceImpl implements SessionInfoService {

    @Autowired
    private SessionInfoDao sessionDao;

    @Override
    public SessionInfoDto authByToken(String sessionToken) throws Exception {
        return null;
    }

    @Override
    public int registToken(LoginRequest request, String token) throws Exception {

        int result = sessionDao.registToken(request, token);

        if (result == 0) {
            throw new InsertFailureException("Failed by insert error");
        }
        return result;
    }

    @Override
    public int updateToken(LoginRequest request, String token) throws Exception {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public boolean getTokenByUser(LoginRequest request) throws Exception {
        // TODO Auto-generated method stub
        return false;
    }

}
