package com.ascending.training.repository;

import com.ascending.training.model.Customer;
import com.ascending.training.model.Role;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class CustomerDaoTest {

    public List<Role> roles = new ArrayList<>();

    @Autowired
    public RoleDao roleDao;
    public CustomerDao customerDao;


    @Before
    public void setup(){
        //create customer instance
        Customer customer = new Customer();
        customer.setGender(0);
        customer.setPrimer(1);
        customer.setName("ab");
        customer.setWeight(124);
        customer.setHeight(187);
        customer.setAge(22);
        //find role add add roles
        Role manager = roleDao.findByName("Manager");
        Role user = roleDao.findByName("user");
        roles.add(manager);
        roles.add(user);

    }

    @Test
    public void getCustomerWithRoleTest(){
        Customer customer= new Customer();
        List<Role> roles = new ArrayList<>();
        customer.setRoles(roles);
        customerDao.save(customer);
        List<Customer> customers = customerDao.getCustomers();
    }
}
