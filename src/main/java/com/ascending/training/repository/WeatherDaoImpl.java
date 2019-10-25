package com.ascending.training.repository;

import com.ascending.training.model.Weather;
import com.ascending.training.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.Collectors;

public class WeatherDaoImpl implements WeatherDao {
    private Logger logger= LoggerFactory.getLogger(this.getClass());

    @Override
    public boolean save(Weather weather) {
        Transaction transaction = null;
        boolean isSuccess = true;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(weather);
            transaction.commit();
        }
        catch (Exception e) {
            isSuccess = false;
            if (transaction != null) transaction.rollback();
            logger.error(e.getMessage());
        }

        if (isSuccess) logger.debug(String.format("The weather %s was inserted into the table.", weather.toString()));

        return isSuccess;
    }

    @Override
    public boolean update(Weather weather) {
        Transaction transaction = null;
        boolean isSuccess = true;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(weather);
            transaction.commit();
        }
        catch (Exception e) {
            isSuccess = false;
            if (transaction != null) transaction.rollback();
            logger.error(e.getMessage());
        }

        if (isSuccess) logger.debug(String.format("The weather %s was updated.", weather.toString()));

        return isSuccess;
    }

    @Override
    public boolean delete(String weatherName) {
        String hql = "DELETE Weather where name = :weatherName";
        int deletedCount = 0;
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Query<Weather> query = session.createQuery(hql);
            query.setParameter("weatherName", weatherName);
            deletedCount = query.executeUpdate();
            //Department dept = getDepartmentByName(deptName);
            //session.delete(dept);
            transaction.commit();
            deletedCount = 1;
        }
        catch (Exception e) {
            if (transaction != null) transaction.rollback();
            logger.error(e.getMessage());
        }

        logger.debug(String.format("The weather %s was deleted", weatherName));

        return deletedCount >= 1 ? true : false;
    }

    @Override
    public List<Weather> getWeathers() {
        //String hql = "FROM Department as dept left join fetch dept.employees as em left join fetch em.accounts";
        //String hql = "FROM Department as dept left join fetch dept.employees";
        String hql = "FROM Weather";
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Weather> query = session.createQuery(hql);
            //return query.list();
            return query.list().stream().distinct().collect(Collectors.toList());
            //return query.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
        }
    }

}