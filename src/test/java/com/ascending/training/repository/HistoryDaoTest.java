package com.ascending.training.repository;

import com.ascending.training.ApplicationBoot;
import com.ascending.training.model.History;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ApplicationBoot.class})
public class HistoryDaoTest {
    @Autowired
    private HistoryDao historyDao;
    private History testData;
    @Autowired
    private Logger logger;
    LocalDate date = LocalDate.parse("2019-10-31");

    @Before
    public void init() {
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
        Assert.assertNotNull(historys);
        //  check logger information if sth wrong
       // logger.info(historys.toString());
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
        testData.setDate(date);
        testData.setTemperature(55);
        boolean result = historyDao.update(testData);
        Assert.assertTrue(result);

    }

}
