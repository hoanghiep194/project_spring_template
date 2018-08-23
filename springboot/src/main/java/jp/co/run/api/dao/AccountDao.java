package jp.co.run.api.dao;

import jp.co.run.api.dto.account.AccountDto;
import jp.co.run.api.entity.AccountEntity;
import jp.co.run.api.request.data.AccountRegistRequest;

public interface AccountDao {
    public AccountDto getAccountLogin(final String userName) throws Exception;
    public void insert (final AccountEntity accountEntity) throws Exception;
    public int insert(final AccountRegistRequest accountRegistRequest) throws Exception;
    public int select(final AccountRegistRequest accountRegistRequest) throws Exception;
}
