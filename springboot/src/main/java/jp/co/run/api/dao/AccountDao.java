package jp.co.run.api.dao;

import jp.co.run.api.request.data.LoginRequest;

public interface AccountDao {
    public int getAccountLogin(final LoginRequest loginRequest) throws Exception;
}
