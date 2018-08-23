package jp.co.run.api.dao;

import jp.co.run.api.dto.account.AccountDto;
import jp.co.run.api.entity.AccountEntity;

public interface AccountDao {
    public AccountDto getAccountLogin(final String userName) throws Exception;
    public void insert (final AccountEntity accountEntity) throws Exception;
}
