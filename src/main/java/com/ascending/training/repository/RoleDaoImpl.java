package com.ascending.training.repository;

import com.ascending.training.model.Customer;
import com.ascending.training.model.Role;
import com.ascending.training.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RoleDaoImpl implements RoleDao{

@Autowired
private Logger logger;
@Autowired
private SessionFactory sessionFactory;

    public boolean save(Role role) {
        Transaction transaction = null;
        boolean isSuccess = true;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(role);
            transaction.commit();
        } catch (Exception e) {
            isSuccess = false;
            if (transaction != null) transaction.rollback();
            logger.error(e.getMessage());
        }

        if (isSuccess) logger.debug(String.format("The roles %s was inserted into the table.", role.toString()));

        return isSuccess;
    }


    public Role getRoleByName(String name) {
        String hql = "FROM Role as r where lower(r.name) = :name";

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Role> query = session.createQuery(hql);
            query.setParameter("name", name.toLowerCase());

            return query.uniqueResult();
        }
    }

    public boolean update(Role role) {
        Transaction transaction = null;
        boolean isSuccess = true;

        try{
            Session session = sessionFactory.getCurrentSession();
            transaction = session.beginTransaction();
            session.saveOrUpdate(role);
            transaction.commit();
        } catch (Exception e) {
            isSuccess = false;
            if (transaction != null) transaction.rollback();
            logger.error(e.getMessage());
        }

        if (isSuccess) logger.debug(String.format("The role %s is updated", role.toString()));
        return isSuccess;
    }

    public boolean deleteRoleByName(String roleName) {
        String hql = "DELETE Role where name = :roleName";
        int delectedCount = 0;
        Transaction transaction = null;

        try {
            Session session = sessionFactory.getCurrentSession();
            transaction = session.beginTransaction();
            Query<Role> query = session.createQuery(hql);
            query.setParameter("roleName", roleName);
            delectedCount = query.executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            logger.error(e.getMessage());
        }

        logger.debug(String.format("The role %s is deleted", roleName));
        return delectedCount >= 1 ? true : false;
    }

}
