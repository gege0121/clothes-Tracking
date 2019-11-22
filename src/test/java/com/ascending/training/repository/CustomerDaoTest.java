package com.ascending.training.repository;

import com.ascending.training.ApplicationBoot;
import com.ascending.training.model.Clothes;
import com.ascending.training.model.Customer;
import com.ascending.training.model.Role;
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
    public CustomerDao customerDao;
    public ClothesDao clothesDao;
    private Logger logger;


    @Before
    public void setup(){
        //create customer instance
        customerDao=new CustomerDaoImpl();
//        Customer customer = new Customer();
//        customer.setEmail("wanggege0121@gmail.com");
//        customer.setPassword("123");
//        customer.setGender(0);
//        customer.setPrimer(1);
//        customer.setName("ab");
//        customer.setWeight(124);
//        customer.setHeight(187);
//        customer.setAge(22);
//        customerDao.save(customer);
//        logger.info("customer id is: ",customer.getId());
//        Clothes c = new Clothes();
//        ///xxxx
//        c.setCustomer(customer);
//        clothesDao.save(c);



        // add
        //find role add add roles
//        Role manager = roleDao.findByName("Manager");
//        Role user = roleDao.findByName("user");
//        roles.add(manager);
//        roles.add(user);
    }

//    @Test
//    public void getCustomerWithRoleTest(){
//        Customer customer= new Customer();
//        List<Role> roles = new ArrayList<>();
//        customer.setRoles(roles);
//        customerDao.save(customer);
//        List<Customer> customers = customerDao.getCustomers();
//    }


    @Test
    public void getCustomersWithClothesTest(){
        List<Customer> customers = customerDao.getAllCustomersWithClothes();
       int expectedNum = 7;
       customers.forEach(acct -> logger.debug(acct.toString()));
       Assert.assertEquals(expectedNum, customers.size());
    }

    @Test
    public void getCustomersByEmailTest(){
        Customer customer=customerDao.getCustomersByEmail("wanggege0121@gmail.com");
        Assert.assertNotNull(customer);
        logger.debug(customer.toString());

    }

    @Test
    public void saveTest(){
        Customer customer=new Customer();
        customer.setEmail("gege0121@gmail.com");
        customer.setPassword("123456");
        Role r=new Role();
        r.setId(1);
        List<Role> roles=new ArrayList<>();
        roles.add(r);
        customer.setRoles(roles);
        customerDao.save(customer);
    }
}
