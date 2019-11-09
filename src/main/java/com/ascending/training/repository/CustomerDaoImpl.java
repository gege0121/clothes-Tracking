package com.ascending.training.repository;

import com.ascending.training.model.Customer;
import com.ascending.training.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CustomerDaoImpl  implements CustomerDao {

    private Logger logger= LoggerFactory.getLogger(getClass());

    public boolean save(Customer customer) {
        Transaction transaction = null;
        boolean isSuccess = true;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(customer);
            transaction.commit();
        } catch (Exception e) {
            isSuccess = false;
            if (transaction != null) transaction.rollback();
            logger.error(e.getMessage());
        }

        if (isSuccess) logger.debug(String.format("The customer %s was inserted into the table.", customer.toString()));

        return isSuccess;
    }

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

    public List<Customer> getCustomers() {

        String hql = "FROM Customer";
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Customer> query = session.createQuery(hql);
            return query.list().stream().distinct().collect(Collectors.toList());

        }
    }

    public Customer getCustomersById(int id) {
        String hql = "FROM Customer where id = :id";

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Customer> query = session.createQuery(hql);
            query.setParameter("id", id);

            return query.uniqueResult();
        }
    }

   public Customer getCustomersByEmail(String email){
        String hql="FROM Customer as c where lower(c.email) = :email";

        try(Session session =HibernateUtil.getSessionFactory().openSession()){
            Query<Customer> query=session.createQuery(hql);
            query.setParameter("email",email.toLowerCase());
            return query.uniqueResult();
        }
   }

    public boolean delete(String customerName) {
        String hql = "DELETE Customer where name = :name";
        int deletedCount = 0;
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Query<Customer> query = session.createQuery(hql);
            query.setParameter("name", customerName);
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

        logger.debug(String.format("The customer %s was deleted", customerName));

        return deletedCount >= 1 ? true : false;
    }
//
//    public List<Customer> getCustomersWithClothes() {
//        String hql = "FROM Customer as c left join fetch c.clothes as clo";
//        //String hql = "FROM Department as dept left join fetch dept.employees";
//        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
//            Query<Customer> query = session.createQuery(hql);
//            //return query.list();
//            //return query.list().stream().distinct().collect(Collectors.toList());
////            return query.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
//            return query.list();
//        }
//    }
    public List<Customer> getAllCustomersWithClothes(){
        String hql = "FROM Customer as c left join fetch c.clothes as clo";
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Customer> query = session.createQuery(hql);
            return query.list();
        }
    }


    public Customer getCustomerByCredentials(String email, String password){
        String hql = "FROM Customer as c where lower(c.email) = :email and c.password = :password";
        logger.debug(String.format("Customer email: %s, password: %s", email, password));

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Customer> query = session.createQuery(hql);
            query.setParameter("email", email.toLowerCase().trim());
            query.setParameter("password", password);

            return query.uniqueResult();
        }
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