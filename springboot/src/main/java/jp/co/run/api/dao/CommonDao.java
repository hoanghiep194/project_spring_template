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
    public <T> void insert(T entity) throws Exception;

    public <T> int insert(String pathSql, Class<T> clzz, Map<String, Object> param) throws Exception;

    /**
     * Select list data from database
     *
     * @param <T>
     *            the generic type
     * @param pathSql
     *            the path sql
     * @param clzz
     *            the clzz
     * @param param
     *            the param
     * @return the list
     * @throws Exception
     *             the exception
     */
    public <T> List<T> select(String pathSql, Class<T> clzz, Map<String, Object> param) throws Exception;

    /**
     * Count data from database
     *
     * @param <T>
     *            the generic type
     * @param pathSql
     *            the path sql
     * @param param
     *            the param
     * @return the int
     * @throws Exception
     *             the exception
     */
    public <T> int select(String pathSql, Map<String, Object> param) throws Exception;

}
