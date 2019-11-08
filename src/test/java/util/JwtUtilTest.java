package util;

import com.ascending.training.model.Customer;
import com.ascending.training.model.Role;
import com.ascending.training.util.JwtUtil;
import io.jsonwebtoken.Claims;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class JwtUtilTest {
    @Test
    public void gengeratetokenTest(){
        Customer c=new Customer();
        c.setAge(14);
        c.setHeight(165);
        c.setWeight(67);
        c.setName("wee");
        c.setPrimer(2);
        c.setGender(1);
        Role r= new Role();
        r.setName("gg");
        r.setAllowedCreate(true);
        r.setAllowedDelete(true);
        r.setAllowedResource("/customer");
        r.setAllowedUpdate(false);
        List<Role> roles= new ArrayList<Role>();
        roles.add(r);
        c.setRoles(roles);
        String token = JwtUtil.generateToken(c);
        System.out.println(token);
        Claims actualResult = JwtUtil.decodeJwtToken(token);
        Assert.assertEquals(actualResult.getId(), String.valueOf(c.getId()));
        Assert.assertNotNull(token);
    }
}
