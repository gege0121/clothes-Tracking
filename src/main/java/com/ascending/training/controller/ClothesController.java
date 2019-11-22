package com.ascending.training.controller;

import com.ascending.training.model.Clothes;
import com.ascending.training.service.ClothesService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = {"/clothes","clo"})
public class ClothesController {
    @Autowired private Logger logger;
    @Autowired private ClothesService clothesService;
    // /clothes GET
    @RequestMapping(value = "", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Clothes> getClothesAll() {
        return clothesService.getClothessAll();
    }

    // /clothes/5 GET
    @RequestMapping(value = "/{id}",method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public Clothes getClothesById(@PathVariable int id){
        return clothesService.getClothesById(id);
    }

    @RequestMapping(value="/clothes/history}",method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Clothes> getAllClothessWithHistory(){
        return clothesService.getAllClothessWithHistory();
    }



}
