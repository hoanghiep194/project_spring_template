package jp.co.run.api.dao.impl;

import java.math.BigInteger;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import jp.co.run.api.dao.AccountDao;
import jp.co.run.api.request.data.LoginRequest;
import jp.co.run.api.util.SqlFileReaderUtil;

@Component
@Transactional
public class AccountDaoImpl implements AccountDao {

    @Autowired
    private SessionFactory sessionFactory;

    private static final String SQL_GET_ACCOUNT = "/account/get_account.sql";

    @Override
    @SuppressWarnings("unchecked")
    public int getAccountLogin(LoginRequest loginRequest) throws Exception {

        // Get content of sql
        String sqlQuery = SqlFileReaderUtil.getSql(SQL_GET_ACCOUNT);

        Session session = sessionFactory.getCurrentSession();

        Query<BigInteger> query = session.createNativeQuery(sqlQuery);
        // Set parameter
        query.setParameter("userName", loginRequest.getLoginId());
        query.setParameter("password", loginRequest.getPassword());

        return query.getResultList().get(0).intValue();
    }

}
