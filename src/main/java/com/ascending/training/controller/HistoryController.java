package com.ascending.training.controller;

import com.ascending.training.service.HistoryService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

public class HistoryController {
    @Autowired private Logger logger;
    @Autowired private HistoryService historyService;

}
