package com.ascending.training.service;

import com.ascending.training.repository.HistoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HistoryService {
    @Autowired
    private HistoryDao historyDao;
}
