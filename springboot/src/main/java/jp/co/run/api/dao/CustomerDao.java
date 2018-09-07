package jp.co.run.api.dao;

import jp.co.run.api.request.data.AccountRegistRequest;

/**
 * The Interface CustomerDao.
 */
public interface CustomerDao {

    /**
     * Insert customer.
     *
     * @param request the request
     * @param customerId the customer id
     * @return the int
     * @throws Exception the exception
     */
    public int insertCustomer(final AccountRegistRequest request, final String customerId) throws Exception;

    /**
     * Count customer.
     *
     * @return the int
     * @throws Exception the exception
     */
    public int countCustomer() throws Exception;

}
