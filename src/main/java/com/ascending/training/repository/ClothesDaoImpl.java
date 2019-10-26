package com.ascending.training.repository;

import com.ascending.training.model.Clothes;
import com.ascending.training.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.slf4j.Logger;

import java.util.List;
import java.util.stream.Collectors;

public class ClothesDaoImpl implements  ClothesDao {

    private Logger logger;

    public boolean save(Clothes clothes) {
        Transaction transaction = null;
        boolean isSuccess = true;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(clothes);
            transaction.commit();
        } catch (Exception e) {
            isSuccess = false;
            if (transaction != null) transaction.rollback();
            logger.error(e.getMessage());
        }

        if (isSuccess) logger.debug(String.format("The clothes %s was inserted into the table.", clothes.toString()));

        return isSuccess;
    }

    public boolean update(Clothes clothes) {
        Transaction transaction = null;
        boolean isSuccess = true;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(clothes);
            transaction.commit();
        }
        catch (Exception e) {
            isSuccess = false;
            if (transaction != null) transaction.rollback();
            logger.error(e.getMessage());
        }

        if (isSuccess) logger.debug(String.format("The clothes %s was updated.", clothes.toString()));

        return isSuccess;
    }

    public List<Clothes> getClothess() {

        String hql = "FROM Clothes";
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Clothes> query = session.createQuery(hql);
            return query.list().stream().distinct().collect(Collectors.toList());
//
//        }
    }


    public boolean delete(String clothesType) {
        String hql = "DELETE Clothes where type = :clothesType";
        int deletedCount = 0;
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Query<Clothes> query = session.createQuery(hql);
            query.setParameter("clothesType", clothesType);
            deletedCount = query.executeUpdate();
        Clothes clo = getClothesByType(clothesType);
            session.delete(clo);
            transaction.commit();
            deletedCount = 1;
        }
        catch (Exception e) {
            if (transaction != null) transaction.rollback();
            logger.error(e.getMessage());
        }

        logger.debug(String.format("The clothes %s was deleted", clothesType));

        return deletedCount >= 1 ? true : false;
    }

//        public Clothes getClothesByType(String clothesType) {
//            if (clothesType == null) return null;
//            String hql = "FROM Department as dept left join fetch dept.employees as em left join " +
//                    "fetch em.accounts where lower(dept.name) = :name";
//            //String hql = "FROM Department as dept where lower(dept.name) = :name";
//
//            try (Session session = HibernateUtil.getSessionFactory().openSession()) {
//                Query<Department> query = session.createQuery(hql);
//                query.setParameter("name", deptName.toLowerCase());
//
//                return query.uniqueResult();
//            }
//        }


    }

