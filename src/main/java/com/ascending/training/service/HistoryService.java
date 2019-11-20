package com.ascending.training.service;

import com.ascending.training.model.History;
import com.ascending.training.repository.HistoryDao;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class HistoryService {
    @Autowired
    private HistoryDao historyDao;
    private Logger logger;

    public boolean save(History history){
        return historyDao.save(history);
    }

    public boolean update(History history){
        return historyDao.update(history);
    }

    public List<History> getHistorys(){
        return historyDao.getHistorys();
    }

    public History getHistoryById(int id){
        return historyDao.getHistoryById(id);
    }

    public boolean delete(LocalDate historyDate){
        return historyDao.delete(historyDate);
    }

    public boolean deleteHistoryById(int id){
        return historyDao.deleteHistoryById(id);
    }
}
