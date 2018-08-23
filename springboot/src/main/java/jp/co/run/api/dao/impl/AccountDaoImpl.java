package jp.co.run.api.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import jp.co.run.api.dao.AccountDao;
import jp.co.run.api.dao.CommonDao;
import jp.co.run.api.dto.account.AccountDto;
import jp.co.run.api.entity.AccountEntity;
import jp.co.run.api.exception.InsertDataAlreadyExistException;
import jp.co.run.api.util.SqlFileReaderUtil;

@Component
public class AccountDaoImpl implements AccountDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private CommonDao commonDao;

    private static final String SQL_GET_ACCOUNT = "/account/get_account.sql";

    private static final String SQL_SELECT_ACCOUNT_BY_USER_NAME = "/account/select_account_by_user_name.sql";

    @Override
    @Transactional(rollbackFor = Exception.class)
    @SuppressWarnings({ "unchecked", "deprecation" })
    public AccountDto getAccountLogin(String userName) throws Exception {

        AccountDto accountDto = null;
        // Get content of sql
        String sqlQuery = SqlFileReaderUtil.getSql(SQL_GET_ACCOUNT);
        Session session = sessionFactory.getCurrentSession();

        Query<AccountDto> query = session.createNativeQuery(sqlQuery)
                .setResultTransformer(Transformers.aliasToBean(AccountDto.class));
        // Set parameter
        query.setParameter("userName", userName);
        List<AccountDto> result = query.getResultList();
        if (result.size() > 0) {
            accountDto = result.get(0);
        }

        return accountDto;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insert(AccountEntity accountEntity) throws Exception {
        Map<String, Object> mapParam = new HashMap<String, Object>();
        mapParam.put("userName", accountEntity.getUserName());

        int count = commonDao.select(SQL_SELECT_ACCOUNT_BY_USER_NAME, mapParam);
        // Check data already exist
        if(count > 0) {
            throw new InsertDataAlreadyExistException("ユーザー名" + accountEntity.getUserName() + "は、既に登録されています。");
        }
        try {
            // Insert data
            commonDao.insert(accountEntity);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
