package com.ascending.training.service;

import com.ascending.training.model.Clothes;
import com.ascending.training.repository.ClothesDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClothesService {
    @Autowired
    private ClothesDao clothesDao;

    public Clothes save(Clothes Clo){
        clothesDao.save(Clo);
        return Clo;
    }

    public List<Clothes> getClothes(){
        return clothesDao.getClothessAll();
    }
}
