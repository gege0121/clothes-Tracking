package com.ascending.training.serviceTest;


import com.amazonaws.services.dynamodbv2.xspec.L;
import com.ascending.training.ApplicationBoot;
import com.ascending.training.model.Customer;
import com.ascending.training.model.History;
import com.ascending.training.service.HistoryService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.awt.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApplicationBoot.class)
public class HistoryServiceTest {
    @Autowired
    private HistoryService historyService;
    History history1 = new History();
    History history2 = new History();

    @Before
    public void init() {
        history1.setTemperature(86);
        history1.setDate(LocalDate.parse("2019-07-07"));
//        history1.setId(1);
//        history2.setId(2);
        history2.setTemperature(99);
        history2.setDate(LocalDate.parse("2019-07-08"));
    }

    @Test
    public void saveTest() {
        historyService.save(history1);
        historyService.save(history2);
        System.out.println(">>>>>id" + history1.getId());
        System.out.println(">>>>>id" + history2.getId());
        Assert.assertNotNull(history1.getId());
    }

    @Test
    public void updateTest() {
        historyService.save(history1);
        history1.setTemperature(22);
        historyService.update(history1);
        Assert.assertEquals(history1.getTemperature().toString(), "22");
    }

    @Test
    public void getHistorysTest() {
        List<History> historyList = new ArrayList<>(historyService.getHistorys());
        Assert.assertNotNull(historyList);
//        historyService.getHistorys();

    }

    @Test
    public void getHistoryByIdTest() {
        historyService.save(history1);
        Integer id = history1.getId();
        System.out.println(">>>>>id" + id);
        History history = historyService.getHistoryById(id);
        Assert.assertNotNull(history);
    }

    @Test
    public void deleteHistoryByIdTest() {
        historyService.save(history1);
        int id = history1.getId();
        boolean result = historyService.deleteHistoryById(id);
        Assert.assertTrue(result);
    }

    @Test
    public void deleteByDate() {
        historyService.save(history1);
        LocalDate date = history1.getDate();
        boolean result = historyService.delete(date);
        Assert.assertTrue(result);
    }


}
