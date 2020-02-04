package com.ascending.training.repository;

import com.ascending.training.ApplicationBoot;
import com.ascending.training.model.Customer;
import com.ascending.training.model.Role;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
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
public class RoleDaoTest {
    @Autowired
    private Logger logger;
    @Autowired private CustomerDao userDao;
    @Autowired private RoleDao roleDao;
    private String email;
    private List<Role> roles = new ArrayList();

    @Before
    public void init() {
        Customer customer=new Customer();
        email = "wanggege0121@gmail.com";
        roles.add(roleDao.getRoleByName("Manager"));
        roles.add(roleDao.getRoleByName("User"));
        customer.setRoles(roles);

    }

    @Test
    public void getUserByEmail() {
        Customer user = userDao.getCustomerByEmail("wanggege0121@gmail.com");
        Assert.assertNotNull(user);
        logger.debug(user.toString());
    }

    //@Ignore
    @Test
    public void createUser() {
        Customer user = new Customer();
        user.setRoles(roles);
        user.setName("John");
        user.setEmail("jfang@ascending.com");
        user.setPassword("jfang123!@#$");
        boolean result = userDao.save(user);
        Assert.assertTrue(result);
    }

    @Test
    public void setUsersRole(){
        Customer user=userDao.getCustomerByEmail("wanggege0121@gmail.com");
        List<Role> role = new ArrayList();
        role.add(roleDao.getRoleByName("user"));
        user.setRoles(role);
        userDao.update(user);

        Customer user1=userDao.getCustomerByEmail("huang@gmail.com");
        List<Role> role1 = new ArrayList();
        role1.add(roleDao.getRoleByName("Admin"));
        user1.setRoles(role1);
        userDao.update(user1);

        Customer user3=userDao.getCustomerByEmail("yutongchen@gmail.com");
        List<Role> role3 = new ArrayList();
        role3.add(roleDao.getRoleByName("Manager"));
        user3.setRoles(role3);
        userDao.update(user3);
    }

    @Test
    public void encryptPassword() {
        logger.debug("Hashed Password: " + DigestUtils.md5Hex("123456789"));
    }

}
