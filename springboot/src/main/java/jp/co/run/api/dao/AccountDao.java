package jp.co.run.api.dao;

import java.util.List;

import jp.co.run.api.dto.account.AccountDto;
import jp.co.run.api.dto.account.UserInfoDto;
import jp.co.run.api.entity.AccountEntity;
import jp.co.run.api.request.data.AccountRegistRequest;

/**
 * The Interface AccountDao.
 */
public interface AccountDao {

    /**
     * Gets the account login.
     *
     * @param userName the user name
     * @return the account login
     * @throws Exception the exception
     */
    public AccountDto getAccountLogin(final String userName) throws Exception;

    /**
     * Insert.
     *
     * @param accountEntity the account entity
     * @throws Exception the exception
     */
    public void insert (final AccountEntity accountEntity) throws Exception;

    /**
     * Insert account.
     *
     * @param userName the user name
     * @return the int
     * @throws Exception the exception
     */
    public int insertAccount(final AccountRegistRequest request, final String customerId) throws Exception;

    /**
     * Select.
     *
     * @param accountRegistRequest the account regist request
     * @return the int
     * @throws Exception the exception
     */
    public int getAccountByUserName(final AccountRegistRequest accountRegistRequest) throws Exception;

    /**
     * Gets the list account.
     *
     * @return the list account
     * @throws Exception the exception
     */
    public List<AccountDto> getListAccount() throws Exception;

    public UserInfoDto getDetailUserInfo(final String userName) throws Exception;
}
