package com.ascending.training.repository;

import com.ascending.training.model.Customer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class CustomerDaoTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private CustomerDao customerDao;

    @Before
    public void init() {
        customerDao = new CustomerDaoImpl();
    }

    @Test
    public void getCustomers() {
        List<Customer> customers = customerDao.getCustomers();
        int expectedNumOfTop = 4;

        customers.forEach(customer -> System.out.println(customer));
        Assert.assertEquals(expectedNumOfTop, customers.size());
    }
}
