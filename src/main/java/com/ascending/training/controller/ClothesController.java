package com.ascending.training.controller;

import com.ascending.training.model.Clothes;
import com.ascending.training.service.ClothesService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = {"/clothes","clo"})
public class ClothesController {
    @Autowired private Logger logger;
    @Autowired private ClothesService clothesService;
    @RequestMapping(value = "", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Clothes> getClothess() {
        return clothesService.getClothes();
    }

}
