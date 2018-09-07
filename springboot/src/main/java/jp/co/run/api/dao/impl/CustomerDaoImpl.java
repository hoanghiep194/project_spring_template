package jp.co.run.api.dao.impl;

import java.math.BigInteger;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jp.co.run.api.common.Constants;
import jp.co.run.api.dao.CommonDao;
import jp.co.run.api.dao.CustomerDao;
import jp.co.run.api.request.data.AccountRegistRequest;
import jp.co.run.api.util.CommonUitl;
import jp.co.run.api.util.SqlFileReaderUtil;

/**
 * The Class CustomerDaoImpl.
 */
@Component
public class CustomerDaoImpl implements CustomerDao {

    /** The common dao. */
    @Autowired
    private CommonDao commonDao;

    /** The Constant SQL_INSERT_USER_INFO. */
    private static final String SQL_INSERT_CUSTOMER = "/customer/insert_customer.sql";

    /** The Constant SQL_INSERT_USER_INFO. */
    private static final String SQL_SELECT_ALL_CUSTOMER = "/customer/select_all_customer.sql";

    /*
     * (non-Javadoc)
     *
     * @see jp.co.run.api.dao.CustomerDao#insertCustomer(jp.co.run.api.request.data.
     * AccountRegistRequest)
     */
    @Override
    public int insertCustomer(AccountRegistRequest request, String customerId) throws Exception {

        // Get content of sql
        String sqlQuery = SqlFileReaderUtil.getSql(SQL_INSERT_CUSTOMER);

        Map<String, Object> mapParam = new HashMap<String, Object>();
        mapParam.put("customerId", customerId);
        mapParam.put("firstName", request.getFirstName());
        mapParam.put("lastName", request.getLastName());
        mapParam.put("sex", request.getSex());
        mapParam.put("birthday",
                CommonUitl.convertStringToDate(request.getBirthday(), Constants.CONST_FORMAT_DATE_YYYY_MM_DD));
        mapParam.put("address", request.getAddress());
        mapParam.put("email", request.getEmail());
        mapParam.put("phone", request.getPhone());
        mapParam.put("registUser", request.getUserName());
        mapParam.put("registTime", new Date());
        mapParam.put("updateUser", null);
        mapParam.put("updateTime", null);
        mapParam.put("deleteFlag", 0);

        return commonDao.insert(sqlQuery, BigInteger.class, mapParam);
    }

    /*
     * (non-Javadoc)
     *
     * @see jp.co.run.api.dao.CustomerDao#countCustomer()
     */
    @Override
    public int countCustomer() throws Exception {

        // Get content of sql
        String sqlQuery = SqlFileReaderUtil.getSql(SQL_SELECT_ALL_CUSTOMER);
        Map<String, Object> mapParam = new HashMap<String, Object>();

        return commonDao.select(sqlQuery, mapParam);
    }

}
