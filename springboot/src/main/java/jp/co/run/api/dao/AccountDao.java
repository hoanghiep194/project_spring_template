package jp.co.run.api.dao;

import jp.co.run.api.entity.AccountEntity;
import jp.co.run.api.request.data.AccountRegistRequest;
import jp.co.run.api.response.data.AccountRespone;

public interface AccountDao {
    public AccountRespone getAccountLogin(final String userName) throws Exception;
    public void insert (final AccountEntity accountEntity) throws Exception;
    public int insertUserInfo(final AccountRegistRequest accountRegistRequest) throws Exception;
    public int insertAccount(final String userName) throws Exception;
    public int select(final AccountRegistRequest accountRegistRequest) throws Exception;
}
