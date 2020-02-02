package com.ascending.training.service;

import com.ascending.training.model.Clothes;
import com.ascending.training.repository.ClothesDao;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClothesService {
    @Autowired
    private ClothesDao clothesDao;
    @Autowired
    private Logger logger;

    public boolean save(Clothes Clo){
        return clothesDao.save(Clo);
    }

    public boolean update(Clothes Clo){
        return clothesDao.update(Clo);
    }

    public List<Clothes> getClothessAll(){
        return clothesDao.getClothessAll();
    }

    public boolean deleteByType(String clothesType){
        return clothesDao.deleteByType(clothesType);
    }

    public Clothes getClothesById(int id){ return clothesDao.getClothesById(id); }

    public List<Clothes> getAllClothessWithHistory(){
        return clothesDao.getAllClothessWithHistory();
    }
}
