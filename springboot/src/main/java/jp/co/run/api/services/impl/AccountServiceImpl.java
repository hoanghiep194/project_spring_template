package jp.co.run.api.services.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.run.api.common.HmacSHA1Encryption;
import jp.co.run.api.dao.AccountDao;
import jp.co.run.api.dto.account.AccountDto;
import jp.co.run.api.entity.AccountEntity;
import jp.co.run.api.request.data.AccountRegistRequest;
import jp.co.run.api.request.data.LoginRequest;
import jp.co.run.api.services.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    @Override
    public AccountDto login(LoginRequest loginRequest) {

        AccountDto accountDto = null;
        try {
            accountDto = accountDao.getAccountLogin(loginRequest.getUserName());
            return accountDto;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return accountDto;
    }

    @Override
    public int regist(AccountRegistRequest request) throws Exception {

        // Encode for password
        String password = HmacSHA1Encryption.generateStorngPasswordHash(request.getPassword());

        // Set value for entity
        AccountEntity accountEntity = new AccountEntity();
        accountEntity.setUserName(request.getUserName());
        accountEntity.setPassword(password);
        accountEntity.setMailAddress(request.getMailAddress());
        accountEntity.setExpiryDate(new Date());
        accountEntity.setRoleId(1);
        accountEntity.setRegisterUser("admin");

        // Insert
        accountDao.insert(accountEntity);

        return 0;
    }
}
