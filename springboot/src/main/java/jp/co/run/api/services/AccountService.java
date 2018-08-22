package jp.co.run.api.services;

import jp.co.run.api.request.data.LoginRequest;

public interface AccountService {
    public boolean login(final LoginRequest loginRequest);
}
