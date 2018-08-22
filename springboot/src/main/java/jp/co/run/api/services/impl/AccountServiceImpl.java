package jp.co.run.api.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.run.api.dao.AccountDao;
import jp.co.run.api.request.data.LoginRequest;
import jp.co.run.api.services.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    @Override
    public boolean login(LoginRequest loginRequest) {
        try {
            int result = accountDao.getAccountLogin(loginRequest);
            if (result > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
