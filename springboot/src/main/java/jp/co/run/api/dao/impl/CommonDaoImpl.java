package jp.co.run.api.dao.impl;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jp.co.run.api.common.LoggerUtils;
import jp.co.run.api.dao.CommonDao;
import jp.co.run.api.exception.InsertFailureException;
import jp.co.run.api.exception.UpdateFailureException;

/**
 * The Class CommonDaoImpl.
 */
@Component
public class CommonDaoImpl implements CommonDao {

    /** The session factory. */
    @Autowired
    private SessionFactory sessionFactory;

    /*
     * (non-Javadoc)
     *
     * @see jp.co.run.api.dao.CommonDao#insert(java.lang.Object)
     */
    @Override
    public <T> void insert(T entity) throws Exception {

        try {
            Session session = sessionFactory.getCurrentSession();
            // Insert data to DB
            session.save(entity);
        } catch (Exception e) {
            e.printStackTrace();
            LoggerUtils.logError(this, e);
            throw new InsertFailureException("Failed by insert error");
        }
    }

    @SuppressWarnings({ "deprecation", "unchecked" })
    @Override
    public <T> int insert(String sqlQuery, Class<T> clzz, Map<String, Object> param) throws Exception {

        try {
            Session session = sessionFactory.getCurrentSession();
            Query<T> query = session.createNativeQuery(sqlQuery).setResultTransformer(Transformers.aliasToBean(clzz));

            for (Map.Entry<String, Object> map : param.entrySet()) {
                // Set value for parameter
                query.setParameter(map.getKey(), map.getValue());
            }

            return query.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            LoggerUtils.logError(this, e);
            throw new InsertFailureException("Failed by insert error");
        }
    }

    /*
     * (non-Javadoc)
     *
     * @see jp.co.run.api.dao.CommonDao#select(java.lang.String, java.lang.Class,
     * java.util.Map)
     */
    @Override
    @SuppressWarnings({ "unchecked", "deprecation" })
    public <T> List<T> select(String sqlQuery, Class<T> clzz, Map<String, Object> param) throws Exception {

        Session session = sessionFactory.getCurrentSession();
        Query<T> query = session.createNativeQuery(sqlQuery).setResultTransformer(Transformers.aliasToBean(clzz));

        for (Map.Entry<String, Object> map : param.entrySet()) {
            // Set value for parameter
            query.setParameter(map.getKey(), map.getValue());
        }
        List<T> result = query.getResultList();

        return result;
    }

    /*
     * (non-Javadoc)
     *
     * @see jp.co.run.api.dao.CommonDao#select(java.lang.String, java.util.Map)
     */
    @Override
    @SuppressWarnings("unchecked")
    public <T> int select(String sqlQuery, Map<String, Object> param) throws Exception {

        Session session = sessionFactory.getCurrentSession();
        Query<BigInteger> query = session.createNativeQuery(sqlQuery);

        for (Map.Entry<String, Object> map : param.entrySet()) {
            // Set value for parameter
            query.setParameter(map.getKey(), map.getValue());
        }

        List<BigInteger> resultList = query.getResultList();
        if (resultList.size() == 0) {
            return 0;
        }

        return resultList.get(0).intValue();
    }

    @SuppressWarnings({ "unchecked", "deprecation" })
    @Override
    public <T> int update(String sqlQuery, Class<T> clzz, Map<String, Object> param) throws Exception {

        try {
            Session session = sessionFactory.getCurrentSession();
            Query<T> query = session.createNativeQuery(sqlQuery).setResultTransformer(Transformers.aliasToBean(clzz));

            for (Map.Entry<String, Object> map : param.entrySet()) {
                // Set value for parameter
                query.setParameter(map.getKey(), map.getValue());
            }

            return query.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            LoggerUtils.logError(this, e);
            throw new UpdateFailureException("Failed by update error");
        }
    }

}
