package com.ascending.training.repository;

import com.ascending.training.model.Clothes;
import com.ascending.training.model.Customer;
import com.ascending.training.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class HibernateMappingTest {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Test
    public void ClothesmappingTest() {
        String hql = "FROM Clothes";
        List<Clothes> clothess = null;

        try (
                Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Clothes> query = session.createQuery(hql);
            clothess = query.list();
        }
        catch (Exception e) {
            logger.error(e.getMessage());
        }

        if(clothess !=null)
        clothess.forEach(clothes -> logger.info(clothes.toString()));

        Assert.assertNotNull(clothess);
    }
    @Test
    public void CustomermappingTest() {
        String hql = "FROM Customer";
        List<Customer> customers = null;

        try (
                Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Customer> query = session.createQuery(hql);
            customers = query.list();
        }
        catch (Exception e) {
            logger.error(e.getMessage());
        }

        if(customers !=null)
            customers.forEach(customer -> logger.info(customer.toString()));

        Assert.assertNotNull(customers);
    }

}
