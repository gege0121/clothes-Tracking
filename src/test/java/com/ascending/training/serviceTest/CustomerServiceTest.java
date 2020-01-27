package com.ascending.training.serviceTest;

import com.ascending.training.ApplicationBoot;
import com.ascending.training.model.Customer;
import com.ascending.training.repository.CustomerDao;
import com.ascending.training.service.CustomerService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApplicationBoot.class)
public class CustomerServiceTest {

    @Autowired
    private CustomerService customerService;
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
        Customer result=customerService.getCustomersByEmail("wanggege0121@gamil.com");
        Assert.assertEquals("wanggege0121@gamil.com", result.getEmail());
    }

    @Test
    public void  deleteTest(){
    boolean result=customerService.delete("Mila");
    Assert.assertTrue(result);
    }

    @Test
    public void getCustomerByCredentialsTest(){
        Customer result=customerService.getCustomerByCredentials("wanggege0121@gamil.com", "25f9e794323b453885f5181f1b624d0b");

        System.out.println(result.getRoles());
        Assert.assertNotNull(result);
    }


}
