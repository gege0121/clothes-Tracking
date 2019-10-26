package com.ascending.training.jdbc;

import com.ascending.training.model.Customer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class CustomerDaoTest {

    private CustomerDao customerDao;

    @Before
    public void init() {
        customerDao = new CustomerDao();
    }

    @Test
    public void getCustomersTest() {
        List<Customer> customers = customerDao.getcustomers();
        int expectedNumOfCustomer = 3;

        for (Customer customer : customers) {
            System.out.println(customer);
        }

        Assert.assertEquals(expectedNumOfCustomer, customers.size());
    }
}