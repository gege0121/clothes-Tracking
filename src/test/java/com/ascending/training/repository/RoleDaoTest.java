package com.ascending.training.repository;

import com.ascending.training.ApplicationBoot;
import com.ascending.training.model.Customer;
import com.ascending.training.model.Role;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.*;
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
    @Autowired
    private CustomerDao customerDao;
    @Autowired
    private RoleDao roleDao;
    private String email;
    private List<Role> roles = new ArrayList();
    private Customer gg;
    @Before
    public void init() {
        gg=new Customer();
        gg.setEmail("gege0121@gmail.com");
        gg.setAge(88);
        gg.setName("gg");
        roles.add(roleDao.getRoleByName("Manager"));
        roles.add(roleDao.getRoleByName("User"));
        gg.setRoles(roles);


    }

    @After
    public void teardown(){
        customerDao.delete("gg");
    }



    @Test
    public void getUserByEmail() {
        customerDao.save(gg);
        Customer user = customerDao.getCustomerByEmail("gege0121@gmail.com");
        Assert.assertNotNull(user);
        logger.debug(user.toString());
    }

    //@Ignore
    @Test
    public void createUser() {
        boolean result = customerDao.save(gg);
        Assert.assertTrue(result);

    }


    @Test
    public void encryptPassword() {
        logger.debug("Hashed Password: " + DigestUtils.md5Hex("123456789"));
    }

}
