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

    @RequestMapping(value = "", method = RequestMethod.PUT, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public String updateClothes(@RequestBody Clothes clothes) {
        logger.debug("Clothes: " + clothes.toString());
        String msg = "The clothes was updated.";
        boolean isSuccess = clothesService.update(clothes);
        if (!isSuccess) msg = "The clothes was not updated.";

        return msg;
    }

    @RequestMapping(value = "/{clothesType}", method = RequestMethod.DELETE, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public String deleteClothesByType(@PathVariable String clothesType) {
        logger.debug("Clothes  name: " + clothesType);
        String msg = "The clothes was deleted.";
        boolean isSuccess = clothesService.deleteByType(clothesType);
        if (!isSuccess) msg = "The clothes was not deleted.";

        return msg;
    }


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

    @RequestMapping(value="/history}",method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Clothes> getAllClothessWithHistory(){
        return clothesService.getAllClothessWithHistory();
    }



}
