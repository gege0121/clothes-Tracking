package com.ascending.training.jdbc;

import com.ascending.training.model.Bottom;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class BottomDaoTest {

    private BottomDao bottomDao;
    @Before
    public void inint(){
        bottomDao =new BottomDao();
    }
    @After
    public void tearDown(){
        bottomDao =new BottomDao();
    }
    @Test
    public void getBottomsTest(){
        List<Bottom> bottoms= bottomDao.getBottoms();
        int expectedNumOfBottoms =4;
        for (Bottom bottom : bottoms){
            System.out.println(bottom);
        }
        Assert.assertEquals(expectedNumOfBottom, bottoms.size());
    }
}