package jp.co.run.api.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.run.api.common.HmacSHA1Encryption;
import jp.co.run.api.dao.AccountDao;
import jp.co.run.api.dto.account.AccountDto;
import jp.co.run.api.exception.InsertDataAlreadyExistException;
import jp.co.run.api.exception.InsertFailureException;
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
    @Transactional(rollbackFor = Exception.class)
    public int regist(AccountRegistRequest request) throws Exception {

        int record = accountDao.select(request);
        // Check record exists
        if (record > 0) {
            throw new InsertDataAlreadyExistException("ユーザー名" + request.getUserName() + "は、既に登録されています。");
        }

        int result = 0;
        // Encode for password
        String password = HmacSHA1Encryption.generateStorngPasswordHash(request.getPassword());
        request.setPassword(password);

        try {
            // Insert
            result = accountDao.insert(request);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            throw new InsertFailureException("Failed by insert error");
        }
    }
}
