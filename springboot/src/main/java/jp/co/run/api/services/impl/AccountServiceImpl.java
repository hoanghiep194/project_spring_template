package jp.co.run.api.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.run.api.common.SHA1Encryption;
import jp.co.run.api.dao.AccountDao;
import jp.co.run.api.dto.account.AccountDto;
import jp.co.run.api.exception.CheckPasswordFailureException;
import jp.co.run.api.exception.InsertDataAlreadyExistException;
import jp.co.run.api.exception.InsertFailureException;
import jp.co.run.api.request.data.AccountRegistRequest;
import jp.co.run.api.request.data.LoginRequest;
import jp.co.run.api.services.AccountService;
import jp.co.run.api.util.CommonUitl;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    @Override
    public AccountDto login(LoginRequest loginRequest) throws Exception {

        AccountDto accountDto = null;
        // Get record when login
        accountDto = accountDao.getAccountLogin(loginRequest.getUserName());
        // Check password when login
        boolean checkPass = SHA1Encryption.validatePassword(loginRequest.getPassword(), accountDto.getPassword());
        if (!checkPass) {
            throw new CheckPasswordFailureException("");
        }
        return accountDto;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int regist(AccountRegistRequest request) throws Exception {

        // Check record exists
        int record = accountDao.select(request);
        if (record > 0) {
            throw new InsertDataAlreadyExistException("ユーザー名" + request.getUserName() + "は、既に登録されています。");
        }

        // Check password
        boolean isCheckPass = CommonUitl.checkPassword(request.getPassword(), request.getConfirmPassword());

        if (isCheckPass) {
            // Encode for password
            String password = SHA1Encryption.generateStorngPasswordHash(request.getPassword());
            request.setPassword(password);

            // Insert data to table userInfo
            int countUserInfo = accountDao.insertUserInfo(request);
            if (countUserInfo == 0) {
                throw new InsertFailureException("Failed by insert error");
            }
            // Insert data to table account
            int countAccount = accountDao.insertAccount(request.getUserName());
            if (countAccount == 0) {
                throw new InsertFailureException("Failed by insert error");
            }
            return countAccount;
        }
        throw new InsertFailureException("Password with confirm password have diffrent.");
    }
}
