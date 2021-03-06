package jp.co.run.api.dao.impl;

import java.math.BigInteger;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import jp.co.run.api.dao.AccountDao;
import jp.co.run.api.dao.CommonDao;
import jp.co.run.api.dto.account.AccountDto;
import jp.co.run.api.dto.account.UserInfoDto;
import jp.co.run.api.entity.AccountEntity;
import jp.co.run.api.exception.InsertDataAlreadyExistException;
import jp.co.run.api.request.data.AccountRegistRequest;
import jp.co.run.api.util.SqlFileReaderUtil;

/**
 * The Class AccountDaoImpl.
 */
@Component
public class AccountDaoImpl implements AccountDao {

    /** The common dao. */
    @Autowired
    private CommonDao commonDao;

    /** The Constant SQL_GET_ACCOUNT. */
    private static final String SQL_SELECT_ACCOUNT = "/account/select_account.sql";

    /** The Constant SQL_SELECT_ACCOUNT_BY_USER_NAME. */
    private static final String SQL_SELECT_ACCOUNT_BY_USER_NAME = "/account/select_account_by_user_name.sql";

    /** The Constant SQL_INSERT_ACCOUNT. */
    private static final String SQL_INSERT_ACCOUNT = "/account/insert_account.sql";

    private static final String SQL_SELECT_ALL_ACCOUNT = "/account/select_all_account.sql";

    private static final String SQL_SELECT_USER_INFO = "/account/select_user_info.sql";
    /*
     * (non-Javadoc)
     *
     * @see jp.co.run.api.dao.AccountDao#getAccountLogin(java.lang.String)
     */
    @Override
    public AccountDto getAccountLogin(String userName) throws Exception {

        // Get content of sql
        String sqlQuery = SqlFileReaderUtil.getSql(SQL_SELECT_ACCOUNT);

        AccountDto accountDto = null;
        Map<String, Object> mapParam = new HashMap<String, Object>();
        mapParam.put("userName", userName);

        List<AccountDto> listAccount = commonDao.select(sqlQuery, AccountDto.class, mapParam);
        if(listAccount.size() > 0) {
            accountDto = listAccount.get(0);
        }
        return accountDto;
    }

    /*
     * (non-Javadoc)
     *
     * @see jp.co.run.api.dao.AccountDao#insert(jp.co.run.api.entity.AccountEntity)
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insert(AccountEntity accountEntity) throws Exception {

        Map<String, Object> mapParam = new HashMap<String, Object>();
        mapParam.put("userName", accountEntity.getUserName());

        int count = commonDao.select(SQL_SELECT_ACCOUNT_BY_USER_NAME, mapParam);
        // Check data already exist
        if (count > 0) {
            throw new InsertDataAlreadyExistException("ユーザー名" + accountEntity.getUserName() + "は、既に登録されています。");
        }

        // Insert data
        commonDao.insert(accountEntity);
    }

    /*
     * (non-Javadoc)
     *
     * @see jp.co.run.api.dao.AccountDao#insertAccount(java.lang.String)
     */
    @Override
    public int insertAccount(AccountRegistRequest request, String customerId) throws Exception {

        // Get content of sql
        String sqlQuery = SqlFileReaderUtil.getSql(SQL_INSERT_ACCOUNT);

        Map<String, Object> mapParam = new HashMap<String, Object>();
        mapParam.put("customerId", customerId);
        mapParam.put("userName", request.getUserName());
        mapParam.put("password", request.getPassword());
        mapParam.put("expiryDate", new Date());
        mapParam.put("deleteExpiredAccount", null);
        mapParam.put("roleId", 1);
        mapParam.put("registerUser", customerId);
        mapParam.put("registerTime", new Date());
        mapParam.put("updateUser", null);
        mapParam.put("updateTime", null);
        mapParam.put("deleteFlag", 0);

        return commonDao.insert(sqlQuery, BigInteger.class, mapParam);
    }

    /*
     * (non-Javadoc)
     *
     * @see jp.co.run.api.dao.AccountDao#select(jp.co.run.api.request.data.
     * AccountRegistRequest)
     */
    @Override
    public int getAccountByUserName(AccountRegistRequest accountRegistRequest) throws Exception {

        Map<String, Object> mapParam = new HashMap<String, Object>();
        mapParam.put("userName", accountRegistRequest.getUserName());

        return commonDao.select(SQL_SELECT_ACCOUNT_BY_USER_NAME, mapParam);
    }

    @Override
    public List<AccountDto> getListAccount() throws Exception {

        // Get content of sql
        String sqlQuery = SqlFileReaderUtil.getSql(SQL_SELECT_ALL_ACCOUNT);
        Map<String, Object> mapParam = new HashMap<String, Object>();
        return commonDao.select(sqlQuery, AccountDto.class, mapParam);
    }

    @Override
    public UserInfoDto getDetailUserInfo(String userName) throws Exception {

        // Get content of sql
        String sqlQuery = SqlFileReaderUtil.getSql(SQL_SELECT_USER_INFO);
        Map<String, Object> mapParam = new HashMap<String, Object>();
        mapParam.put("userName", userName);

        List<UserInfoDto> userInfoList = commonDao.select(sqlQuery, UserInfoDto.class, mapParam);
        if(userInfoList.size() > 0) {
            return userInfoList.get(0);
        }
        return null;
    }

}
