package com.ascending.training.repository;

import com.ascending.training.model.Accessory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class AccessoryDaoTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private AccessoryDao accessoryDao;

    @Before
    public void init() {
        accessoryDao = new AccessoryDaoImpl();
    }

    @Test
    public void getAccessories() {
        List<Accessory> accessories = accessoryDao.getAccessories();
        int expectedNumOfAccessory = 4;

        accessories.forEach(accessory -> System.out.println(accessory));
        Assert.assertEquals(expectedNumOfAccessory, accessories.size());
    }
}