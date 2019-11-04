package com.ascending.training.repository;

import com.ascending.training.model.Clothes;
import com.ascending.training.model.History;
import com.ascending.training.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Repository

public class HistoryDaoImpl implements HistoryDao {

    private Logger logger= LoggerFactory.getLogger(this.getClass());

    public boolean save(History history) {
        Transaction transaction = null;
        boolean isSuccess = true;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(history);
            transaction.commit();
        } catch (Exception e) {
            isSuccess = false;
            if (transaction != null) transaction.rollback();
            logger.error(e.getMessage());
        }

        if (isSuccess) logger.debug(String.format("The history %s was inserted into the table.", history.toString()));

        return isSuccess;
    }

    public boolean update(History history) {
        Transaction transaction = null;
        boolean isSuccess = true;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(history);
            transaction.commit();
        }
        catch (Exception e) {
            isSuccess = false;
            if (transaction != null) transaction.rollback();
            logger.error(e.getMessage());
        }

        if (isSuccess) logger.debug(String.format("The history %s was updated.", history.toString()));

        return isSuccess;
    }

    public List<History> getHistorys() {

        String hql = "FROM History";
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<History> query = session.createQuery(hql);
            return query.list().stream().distinct().collect(Collectors.toList());

        }

    }

    public History getHistoryById(int id) {
        String hql = "FROM History where id = :id";

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<History> query = session.createQuery(hql);
            query.setParameter("id", id);
            return query.uniqueResult();
        }
    }


    public boolean delete(Date historyDate) {
        String hql = "DELETE History where date = :ct";
        int deletedCount = 0;
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Query<History> query = session.createQuery(hql);
            query.setParameter("ct", historyDate);
            deletedCount = query.executeUpdate();
//        Clothes clo = getClothesByType(clothesType);
//            session.delete(clo);
            transaction.commit();
            deletedCount = 1;
        }
        catch (Exception e) {
            if (transaction != null) transaction.rollback();
            logger.error(e.getMessage());
        }

        logger.debug(String.format("The history %s was deleted", historyDate));

        return deletedCount >= 1 ? true : false;
    }

    public boolean deleteHistoryById(int id){
        String hql="DELETE History where id =:id";
        int deletedCount=0;
        Transaction transaction=null;
        Session session=null;
        try{
            session= HibernateUtil.getSessionFactory().openSession();
            transaction =session.beginTransaction();
            Query<History> query=session.createQuery(hql);
            query.setParameter("id",id);
            deletedCount= query.executeUpdate();
            transaction.commit();
    }
        catch(Exception e){
            e.printStackTrace();
            if (transaction != null) transaction.rollback();
            logger.error(e.getMessage());
        }
        finally {
            if(session!=null) session.close();
        }
        logger.debug(String.format("The historys %s was deleted %d ", id, deletedCount));

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
