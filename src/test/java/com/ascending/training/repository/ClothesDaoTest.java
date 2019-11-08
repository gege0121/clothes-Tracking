package com.ascending.training.repository;

import com.ascending.training.model.Clothes;
import com.ascending.training.model.Customer;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class ClothesDaoTest {

    private ClothesDao clothesDao;
    private Clothes testData;
    private Logger logger= LoggerFactory.getLogger(this.getClass());

    @Before
    public void init() {
        clothesDao=new ClothesDaoImpl();
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
        int expectedNumOfClothes = 4;
        clothess.forEach(acct -> logger.debug(acct.toString()));
        Assert.assertEquals(expectedNumOfClothes, clothess.size());
    }
    @Test
    public void save(){
        Clothes clothes=new Clothes();
        clothes.setColor("white");
        clothes.setSize("s");
        clothes.setTag("school");
        clothes.setType("shirt");
       boolean result=clothesDao.save(clothes);
       Assert.assertTrue(result);
    }

    @Test
    public void update(){
//        Clothes clothes=new Clothes();
//        clothes.setType("zhang3");
//        clothesDao.save(clothes);
        testData=clothesDao.getClothesById(17);

        testData.setType("blouse");
        boolean result=clothesDao.update(testData);
        Assert.assertTrue(result);
    }

    @Test
    public void deleteClothesById(){
        boolean result=clothesDao.deleteClothesById(3);
        Assert.assertTrue(result);
    }

    @Test
    public void getCkothesWithHistoryTest(){
        List<Clothes> clothess= clothesDao.getAllClothessWithHistory();
        int expectedNum = 1;
        clothess.forEach(acct -> logger.debug(acct.toString()));
        Assert.assertEquals(expectedNum, clothess.size());
    }

}