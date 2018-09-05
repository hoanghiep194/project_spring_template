package jp.co.run.api.services.impl;

import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.run.api.dao.AccountDao;
import jp.co.run.api.dto.account.AccountDto;
import jp.co.run.api.exception.CheckPasswordFailureException;
import jp.co.run.api.exception.InsertDataAlreadyExistException;
import jp.co.run.api.exception.InsertFailureException;
import jp.co.run.api.request.data.AccountRegistRequest;
import jp.co.run.api.request.data.LoginRequest;
import jp.co.run.api.response.data.AccountResponeData;
import jp.co.run.api.response.data.CommonListResponseData;
import jp.co.run.api.services.AccountService;
import jp.co.run.api.services.SessionInfoService;

/**
 * The Class AccountServiceImpl.
 */
@Service
public class AccountServiceImpl implements AccountService {

    /** The account dao. */
    @Autowired
    private AccountDao accountDao;

    @Autowired
    private SessionInfoService sessioService;
    
    /** The md. */
    private static MessageDigest md = null;

    /* (non-Javadoc)
     * @see jp.co.run.api.services.AccountService#login(jp.co.run.api.request.data.LoginRequest)
     */
    @Override
    public CommonListResponseData login(LoginRequest loginRequest) throws Exception {

        String userName = loginRequest.getUserName();
        String password = loginRequest.getPassword();
        // Get record when login
        AccountDto accountDto = accountDao.getAccountLogin(userName);
        // Check password when login
        boolean checkPass = checkPassword(changeHash(password), accountDto.getPassword());
        
        if (!checkPass) {
            throw new CheckPasswordFailureException("aa");
        }
        
        String token = createToken(userName);
        // Insert token
        sessioService.registToken(loginRequest, token);
        
        List<AccountResponeData> listAccount = new ArrayList<AccountResponeData>();
        AccountResponeData responeData = new AccountResponeData();
        responeData.setSessionToken(token);
        
        BeanUtils.copyProperties(accountDto, responeData);
        listAccount.add(responeData);
        
        CommonListResponseData responseData = new CommonListResponseData();
        responseData.setResultList(listAccount);
        return responseData;
    }

    /* (non-Javadoc)
     * @see jp.co.run.api.services.AccountService#regist(jp.co.run.api.request.data.AccountRegistRequest)
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int regist(AccountRegistRequest request) throws Exception {

        // Check record exists
        int record = accountDao.select(request);
        if (record > 0) {
            throw new InsertDataAlreadyExistException("ユーザー名" + request.getUserName() + "は、既に登録されています。");
        }

        // Check password
        boolean isCheckPass = checkPassword(request.getPassword(), request.getConfirmPassword());

        if (isCheckPass) {
            // Encode for password
            String password = changeHash(request.getPassword());
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

    /**
     * Change hash.
     *
     * @param data the data
     * @return the string
     */
    private String changeHash(String data) {
        StringBuilder sb = new StringBuilder();
        try {
            if (md == null) {
                md = MessageDigest.getInstance("SHA-256");
            }
            data += "cafe";
            md.update(data.getBytes());
            byte[] hash = md.digest();
            for (byte b : hash) {
                sb.append(String.format("%02x", b));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        String dataHash = sb.toString();
        return dataHash;
    }

    /**
     * Check password.
     *
     * @param password the password
     * @param confirmPassword the confirm password
     * @return true, if successful
     */
    private boolean checkPassword(String password, String confirmPassword) {

        if (password == null || confirmPassword == null) {
            return false;
        } else {
            if (password.equals(confirmPassword)) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * token生成
     * @param loginId
     * @return
     */
    private String createToken(String userName) {
        // loginId+日付をhash化
        Date dt = new Date();
        String nowTime = String.valueOf(dt.getTime());
        String tokenTmp = userName + nowTime;
        return changeHash(tokenTmp);
    }
}
