package com.ascending.training.repository;

import com.ascending.training.model.Bottom;
import com.ascending.training.model.Clothes;
import com.ascending.training.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.Collectors;


public class BottomDaoImpl implements BottomDao {
    private Logger logger= LoggerFactory.getLogger(this.getClass());

    @Override
    public boolean save(Bottom bottom) {
        Transaction transaction = null;
        boolean isSuccess = true;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(bottom);
            transaction.commit();
        }
        catch (Exception e) {
            isSuccess = false;
            if (transaction != null) transaction.rollback();
            logger.error(e.getMessage());
        }

        if (isSuccess) logger.debug(String.format("The bottom %s was inserted into the table.", bottom.toString()));

        return isSuccess;
    }

    @Override
    public boolean update(Bottom bottom) {
        Transaction transaction = null;
        boolean isSuccess = true;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(bottom);
            transaction.commit();
        }
        catch (Exception e) {
            isSuccess = false;
            if (transaction != null) transaction.rollback();
            logger.error(e.getMessage());
        }

        if (isSuccess) logger.debug(String.format("The bottom %s was updated.", bottom.toString()));

        return isSuccess;
    }

    @Override
    public boolean delete(String bottomName) {
        String hql = "DELETE Top where name = :bottomName";
        int deletedCount = 0;
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Query<Clothes> query = session.createQuery(hql);
            query.setParameter("bottomName", bottomName);
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

        logger.debug(String.format("The bottom %s was deleted", bottomName));

        return deletedCount >= 1 ? true : false;
    }

    @Override
    public List<Bottom> getBottoms() {
        //String hql = "FROM Department as dept left join fetch dept.employees as em left join fetch em.accounts";
        //String hql = "FROM Department as dept left join fetch dept.employees";
        String hql = "FROM Bottom";
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Bottom> query = session.createQuery(hql);
            //return query.list();
            return query.list().stream().distinct().collect(Collectors.toList());
            //return query.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
        }
    }

}
