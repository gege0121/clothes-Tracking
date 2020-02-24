package com.ascending.training.jdbc;

import com.ascending.training.model.Clothes;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class ClothesDaoTest {

    private ClothesDao clothesDao;

    @Before
    public void init() {
        clothesDao = new ClothesDao();
    }

    @Test
    public void getClothessTest() {
        List<Clothes> clothess = clothesDao.getclothess();
        Assert.assertNotNull(clothess);

    }
}