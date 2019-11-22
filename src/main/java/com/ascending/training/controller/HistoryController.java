package com.ascending.training.controller;

import com.ascending.training.model.History;
import com.ascending.training.service.HistoryService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = {"/history","/historys"})
public class HistoryController {
    @Autowired private Logger logger;
    @Autowired private HistoryService historyService;


    @RequestMapping(value = "", method = RequestMethod.GET, produces={MediaType.APPLICATION_JSON_VALUE})
    public List<History> getHistorys(){ return historyService.getHistorys(); }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public History getHistoryById(@PathVariable int id){
        return historyService.getHistoryById(id);
    }


    //  /history/5 DELETE
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity delete(@PathVariable int id){
        Map<String,Boolean> result = new HashMap<>();
        Boolean boo = historyService.deleteHistoryById(id);
        result.put("result",boo);
        return ResponseEntity.status(HttpServletResponse.SC_OK).body(result);
    }

}
