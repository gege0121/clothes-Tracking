package com.ascending.training.serviceTest;

import com.ascending.training.ApplicationBoot;
import com.ascending.training.model.Customer;
import com.ascending.training.model.Role;
import com.ascending.training.repository.CustomerDao;
import com.ascending.training.service.CustomerService;
import com.ascending.training.service.RoleService;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApplicationBoot.class)
public class CustomerServiceTest {

    @Autowired
    private CustomerService customerService;
    @Autowired
    private RoleService roleService;
    Customer customer=new Customer();

    @Before
    public void init(){
        customer.setName("Mila");
        customer.setEmail("mila@gmail.com");
        customer.setPassword("milamila");
        customer.setGender(0);
        customer.setPrimer(2);
        customer.setWeight(150);
        customer.setHeight(187);
        customer.setAge(27);
    }

    @After
    public  void teardown(){
        customerService.delete("Mila");
    }

    @Test
    public void saveTest(){
        customerService.save(customer);
        System.out.println(">>>>>id:"+customer.getId());
        Assert.assertNotEquals(customer.getId(),0);
    }

    @Test
    public void updateTest(){
        customerService.update(customer);
        System.out.println(">>>>>id:"+customer.getId());
        Assert.assertNotEquals(customer.getId(),0);
    }



    @Test
    public void getCustomersTest(){
        customerService.getCustomers();
        Assert.assertNotNull(customer);
    }

    @Test
    public void getCustomersByIdTest(){
        Customer result=customerService.getCustomersById(2);
        Assert.assertEquals(2,result.getId());
    }

    @Test
    public void getCustomersByEmailTest(){
        Customer result=customerService.getCustomersByEmail("wanggege0121@gmail.com");
        Assert.assertEquals("wanggege0121@gmail.com", result.getEmail());
    }

    @Test
    public void  deleteTest(){
    boolean result=customerService.delete("Mila");
    Assert.assertTrue(result);
    }

//    @Test
//    public void getCustomerByCredentialsTest(){
//        Customer result=customerService.getCustomerByCredentials("wanggege0121@gmail.com", "202cb962ac59075b964b07152d234b70");
//
//        System.out.println(result.getRoles());
//        Assert.assertNotNull(result);
//    }

    @Test
    public void saveUserWithRoles(){
            List<Role> roles = new ArrayList<>();
            roles.add(roleService.getRoleByName("Manager"));
            roles.add(roleService.getRoleByName("User"));
            customer=customerService.getCustomersByEmail("wanggege0121@gmail.com");
            customer.setRoles(roles);
            customerService.save(customer);

//        User user1 = userDAO.getUserByAccount(user.getAccount());
//        Assert.assertEquals(user1.getRoles().size(),roles.size());
//        userDAO.deleteUserById(user1.getId());
            Assert.assertEquals(customer.getRoles().size(),roles.size());
            //userDAO.deleteUserById(user.getId());
        }
    }

