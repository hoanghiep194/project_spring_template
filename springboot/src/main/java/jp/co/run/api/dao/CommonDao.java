package jp.co.run.api.dao;

import java.util.List;
import java.util.Map;

/**
 * The Interface CommonDao.
 */
public interface CommonDao {

    /**
     * Insert.
     *
     * @param <T>
     *            the generic type
     * @param entity
     *            the entity
     * @throws Exception
     *             the exception
     */
    public <T> void insert(final T entity) throws Exception;

    /**
     * Insert.
     *
     * @param <T> the generic type
     * @param sqlQuery the sql query
     * @param clzz the clzz
     * @param param the param
     * @return the int
     * @throws Exception the exception
     */
    public <T> int insert(final String sqlQuery, final Class<T> clzz, final Map<String, Object> param) throws Exception;

    /**
     * Select list data from database.
     *
     * @param <T>            the generic type
     * @param sqlQuery the sql query
     * @param clzz            the clzz
     * @param param            the param
     * @return the list
     * @throws Exception             the exception
     */
    public <T> List<T> select(final String sqlQuery, final Class<T> clzz, final Map<String, Object> param) throws Exception;

    /**
     * Count data from database.
     *
     * @param <T>            the generic type
     * @param sqlQuery the sql query
     * @param param            the param
     * @return the int
     * @throws Exception             the exception
     */
    public <T> int select(final String sqlQuery, final Map<String, Object> param) throws Exception;

    /**
     * Update.
     *
     * @param <T> the generic type
     * @param sqlQuery the sql query
     * @param clzz the clzz
     * @param param the param
     * @return the int
     * @throws Exception the exception
     */
    public <T> int update(final String sqlQuery, final Class<T> clzz, final Map<String, Object> param) throws Exception;

}
