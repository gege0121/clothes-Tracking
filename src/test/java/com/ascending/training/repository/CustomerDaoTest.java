package com.ascending.training.repository;

import com.ascending.training.ApplicationBoot;
import com.ascending.training.model.Clothes;
import com.ascending.training.model.Customer;
import com.ascending.training.model.Role;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest(classes = ApplicationBoot.class)
@RunWith(SpringRunner.class)
public class CustomerDaoTest {

    public List<Role> roles = new ArrayList<>();

    @Autowired
    public RoleDao roleDao;
    @Autowired
    public CustomerDao customerDao;
    @Autowired
    public ClothesDao clothesDao;
    @Autowired
    private Logger logger;

    private Customer customer;

    @Before
    public void setup(){
        //create customer instance
        customer = new Customer();
        customer.setEmail("ww@gmail");
        customer.setPassword("123");
        customer.setGender(0);
        customer.setPrimer(1);
        customer.setName("ab");
        customer.setWeight(124);
        customer.setHeight(187);
        customer.setAge(22);
        customerDao.save(customer);
        logger.info("customer id is: ",customer.getId());

    }

    @After
    public void tearDown(){
    customerDao.delete("ab");
    }

    @Test
    public void getCustomersWithClothesTest(){
        List<Customer> customers = customerDao.getAllCustomersWithClothes();
       int expectedNum = 5;
       //customers.forEach(acct -> logger.debug(acct.toString()));
       Assert.assertEquals(expectedNum, customers.size());
    }

    @Test
    public void getCustomersByEmailTest(){
        Customer customer=customerDao.getCustomerByEmail("ww@gmail");
        Assert.assertNotNull(customer);
        //logger.debug(customer.toString());

    }



}
