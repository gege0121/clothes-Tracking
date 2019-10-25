package com.ascending.training.repository;

import com.ascending.training.model.Customer;
import com.ascending.training.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.Collectors;

public class CustomerDaoImpl implements CustomerDao {
    private Logger logger= LoggerFactory.getLogger(this.getClass());

    @Override
    public boolean save(Customer customer) {
        Transaction transaction = null;
        boolean isSuccess = true;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(customer);
            transaction.commit();
        }
        catch (Exception e) {
            isSuccess = false;
            if (transaction != null) transaction.rollback();
            logger.error(e.getMessage());
        }

        if (isSuccess) logger.debug(String.format("The customer %s was inserted into the table.", customer.toString()));

        return isSuccess;
    }

    @Override
    public boolean update(Customer customer) {
        Transaction transaction = null;
        boolean isSuccess = true;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(customer);
            transaction.commit();
        }
        catch (Exception e) {
            isSuccess = false;
            if (transaction != null) transaction.rollback();
            logger.error(e.getMessage());
        }

        if (isSuccess) logger.debug(String.format("The customer %s was updated.", customer.toString()));

        return isSuccess;
    }

    @Override
    public boolean delete(String customerName) {
        String hql = "DELETE Customer where name = :customerName";
        int deletedCount = 0;
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Query<Customer> query = session.createQuery(hql);
            query.setParameter("customerName", customerName);
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

        logger.debug(String.format("The customer %s was deleted", customerName));

        return deletedCount >= 1 ? true : false;
    }

    @Override
    public List<Customer> getCustomers() {
        //String hql = "FROM Department as dept left join fetch dept.employees as em left join fetch em.accounts";
        //String hql = "FROM Department as dept left join fetch dept.employees";
        String hql = "FROM Customer";
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Customer> query = session.createQuery(hql);
            //return query.list();
            return query.list().stream().distinct().collect(Collectors.toList());
            //return query.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
        }
    }

}