package com.ascending.training.repository;

import com.ascending.training.model.History;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.List;

public class HistoryDaoTest {

    private HistoryDao historyDao;
    private History testData;
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    Date date = new Date(2019 - 10 - 31);

    @Before
    public void init() {
        historyDao = new HistoryDaoImpl();
        testData = new History();
        testData.setTemperature(89);
        testData.setDate(date);
        historyDao.save(testData);
    }

    @After
    public void tearDown() {
        historyDao.delete(date);
    }

    @Test
    public void getHistorysTest() {
        List<History> historys = historyDao.getHistorys();
        logger.info(historys.toString());

    }

    @Test
    public void delete() {
        boolean result = historyDao.delete(date);
        Assert.assertTrue(result);
    }

    @Test
    public void deleteHistoryById() {
        boolean result = historyDao.deleteHistoryById(3);
        Assert.assertTrue(result);
    }

    @Test
    public void update() {
        testData = historyDao.getHistoryById(2);
        testData.setDate(new Date());
        testData.setTemperature(55);
        boolean result = historyDao.update(testData);
        Assert.assertTrue(result);

    }

}
