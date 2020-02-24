package com.ascending.training.repository;

import com.ascending.training.ApplicationBoot;
import com.ascending.training.model.Clothes;
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
@SpringBootTest(classes = {ApplicationBoot.class})
public class ClothesDaoTest {
    @Autowired
    private ClothesDao clothesDao;
    @Autowired
    private Logger logger;
    private Clothes testData;

    @Before
    public void init() {
        testData=new Clothes();
        testData.setColor("white");
        testData.setSize("s");
        testData.setTag("school");
        testData.setType("shirt");
        clothesDao.save(testData);
    }

    @After
    public void tearDown(){
    clothesDao.deleteByType("shirt");
    }

    @Test
    public void getClothessAll() {
        List<Clothes> clothess = clothesDao.getClothessAll();
        Assert.assertNotNull(clothess);
    }

    @Test
    public void save(){
        Clothes clothes=new Clothes();
        clothes.setColor("white");
        clothes.setSize("s");
        clothes.setTag("party");
        clothes.setType("shirt");
       boolean result=clothesDao.save(clothes);
       Assert.assertTrue(result);
    }

    @Test
    public void update(){
        testData.setType("blouse");
        boolean result=clothesDao.update(testData);
        Assert.assertTrue(result);
    }

    @Test
    public void deleteClothesById(){
        Integer id=testData.getId();
        boolean result=clothesDao.deleteClothesById(id);
        Assert.assertTrue(result);
    }

    @Test
    public void getClothesWithHistoryTest(){
        List<Clothes> clothess= clothesDao.getAllClothessWithHistory();
        Assert.assertNotNull(clothess);
    }

}