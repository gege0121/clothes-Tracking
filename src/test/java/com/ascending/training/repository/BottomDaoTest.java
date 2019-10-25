package com.ascending.training.repository;

import com.ascending.training.model.Bottom;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class BottomDaoTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private BottomDao bottomDao;

    @Before
    public void init() {
        bottomDao = new BottomDaoImpl();
    }

    @Test
    public void getBottoms() {
        List<Bottom> bottoms = bottomDao.getBottoms();
        int expectedNumOfBottom = 4;

        bottoms.forEach(bottom -> System.out.println(bottom));
        Assert.assertEquals(expectedNumOfBottom, bottoms.size());
    }
}