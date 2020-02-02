package com.ascending.training.serviceTest;


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

import java.time.LocalDate;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApplicationBoot.class)
public class HistoryServiceTest {
    @Autowired private HistoryService historyService;
    History history=new History();

    @Before
    public void init() {
        history.setTemperature(86);
        history.setDate(LocalDate.parse("2019-07-07"));
    }

    @Test
    public void saveTest(){
        historyService.save(history);
        System.out.println(">>>>>id"+history.getId());
        Assert.assertNotEquals(history.getId(),0);
    }

    @Test
    public void updateTest(){
        historyService.update(history);
        System.out.println(">>>>>id"+history.getId());
        Assert.assertNotEquals(history.getId(),0);
    }

    @Test
    public void getHistorysTest(){
        historyService.getHistorys();
    }

    @Test
    public void getHistoryByIdTest(){
        History result=historyService.getHistoryById(2);
        Assert.assertEquals(result.getId(),2);
    }

    @Test
    public void deleteHistoryByIdTest(){
        boolean result=historyService.deleteHistoryById(2);
        Assert.assertTrue(result);
    }

    @Test
    public void delete(){
        boolean result=historyService.delete(LocalDate.parse("2019-07-07"));
        Assert.assertTrue(result);
    }




}
