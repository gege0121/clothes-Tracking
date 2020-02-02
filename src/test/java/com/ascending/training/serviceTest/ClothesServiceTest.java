package com.ascending.training.serviceTest;

import com.ascending.training.ApplicationBoot;
import com.ascending.training.model.Clothes;
import com.ascending.training.service.ClothesService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApplicationBoot.class)
public class ClothesServiceTest {
    @Autowired
    private ClothesService clothesService;
    Clothes clo=new Clothes();
    @Before
    public void init(){

        clo.setColor("white");
        clo.setSize("m");
        clo.setTag("party");
        clo.setType("dress");

    }

    @Test
    public void saveTest(){
        clothesService.save(clo);
        System.out.println(">>>>> id: " + clo.getId());
        Assert.assertNotEquals(clo.getId(),0);
    }

    @Test
    public void updateTest(){
        clothesService.update(clo);
        System.out.println(">>>>> id: " + clo.getId());
        Assert.assertNotEquals(clo.getId(),0);
    }

    @Test
    public void getClothessAll(){
        clothesService.getClothessAll();
    }

    @Test
    public void deleteByType( ){

       boolean result= clothesService.deleteByType("dress");
        Assert.assertTrue(result);
    }

    @Test
    public void getClothesById( ){
        Clothes result=clothesService.getClothesById(1);
        Assert.assertEquals(1,result.getId());
    }

    @Test
    public void getAllClothessWithHistory(){
        List<Clothes> result=clothesService.getAllClothessWithHistory();
        Assert.assertNotEquals(result.size(),0);
    }

}
