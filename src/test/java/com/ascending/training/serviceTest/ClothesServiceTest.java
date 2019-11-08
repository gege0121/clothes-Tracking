package com.ascending.training.serviceTest;

import com.ascending.training.ApplicationBoot;
import com.ascending.training.model.Clothes;
import com.ascending.training.service.ClothesService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.beans.AppletInitializer;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApplicationBoot.class)
public class ClothesServiceTest {
    @Autowired
    private ClothesService clothesService;
    @Test
    public void saveTest(){
        Clothes clo=new Clothes();
        clo.setColor("white");
        clo.setSize("m");
        clo.setTag("party");
        clo.setType("dress");
       clo=clothesService.save(clo);

        Assert.assertNotEquals(clo.getId(),0);

    }
}
