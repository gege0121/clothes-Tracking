package com.ascending.training.repository;

import com.ascending.training.model.Accessory;
import com.ascending.training.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.Collectors;

public class AccessoryDaoImpl implements AccessoryDao {
    private Logger logger= LoggerFactory.getLogger(this.getClass());

    @Override
    public boolean save(Accessory accessory) {
        Transaction transaction = null;
        boolean isSuccess = true;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(accessory);
            transaction.commit();
        }
        catch (Exception e) {
            isSuccess = false;
            if (transaction != null) transaction.rollback();
            logger.error(e.getMessage());
        }

        if (isSuccess) logger.debug(String.format("The accessory %s was inserted into the table.", accessory.toString()));

        return isSuccess;
    }

    @Override
    public boolean update(Accessory accessory) {
        Transaction transaction = null;
        boolean isSuccess = true;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(accessory);
            transaction.commit();
        }
        catch (Exception e) {
            isSuccess = false;
            if (transaction != null) transaction.rollback();
            logger.error(e.getMessage());
        }

        if (isSuccess) logger.debug(String.format("The accessory %s was updated.", accessory.toString()));

        return isSuccess;
    }

    @Override
    public boolean delete(String accessoryName) {
        String hql = "DELETE Accessory where name = :accessoryName";
        int deletedCount = 0;
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Query<Accessory> query = session.createQuery(hql);
            query.setParameter("accessoryName", accessoryName);
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

        logger.debug(String.format("The accessory %s was deleted", accessoryName));

        return deletedCount >= 1 ? true : false;
    }

    @Override
    public List<Accessory> accessories() {
        //String hql = "FROM Department as dept left join fetch dept.employees as em left join fetch em.accounts";
        //String hql = "FROM Department as dept left join fetch dept.employees";
        String hql = "FROM Accessory";
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Accessory> query = session.createQuery(hql);
            //return query.list();
            return query.list().stream().distinct().collect(Collectors.toList());
            //return query.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
        }
    }


}
