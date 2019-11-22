package com.ascending.training.repository;

import com.ascending.training.model.Clothes;
import com.ascending.training.model.History;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface HistoryDao {
    boolean save(History history);
    boolean update(History history);
    boolean delete(LocalDate HistoryDate);
    List<History> getHistorys();
    boolean deleteHistoryById(int id);
    History getHistoryById(int id);
}