package com.ascending.training.jdbc;
import com.ascending.training.model.History;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class HistoryDaoTest {

        private HistoryDao historyDao;

        @Before
        public void init() {
            historyDao = new HistoryDao();
        }

        @Test
        public void getHistorysTest() {
            List<History> historys = historyDao.gethistorys();
            int expectedNumOfHistory = 3;

            for (History history : historys) {
                System.out.println(history);
            }

            Assert.assertEquals(expectedNumOfHistory, historys.size());
        }
    }