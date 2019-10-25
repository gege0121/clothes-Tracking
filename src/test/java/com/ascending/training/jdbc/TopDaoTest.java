package com.ascending.training.jdbc;

import com.ascending.training.model.Clothes;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class TopDaoTest {
    private TopDao topDao;
    @Before
    public void inint(){
        topDao =new TopDao();
    }
    @After
    public void tearDown(){
        topDao =new TopDao();
    }
    @Test
    public void getTopsTest(){
        List<Clothes> tops= topDao.getTops();
        int expectedNumOfTop =4;
        for (Clothes top : tops){
            System.out.println(top);
        }
        Assert.assertEquals(expectedNumOfTop, tops.size());
    }
}
