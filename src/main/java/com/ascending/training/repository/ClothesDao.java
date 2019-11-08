package com.ascending.training.repository;

import com.ascending.training.model.Clothes;
import com.ascending.training.model.Customer;

import java.util.List;

public interface ClothesDao {

    boolean save(Clothes clothes);
    boolean update(Clothes clothes);
    boolean deleteByType(String  clothesType);
    boolean deleteClothesById(int id);
    List<Clothes> getClothessAll();
    Clothes getClothesById(int id);
    List<Clothes> getAllClothessWithHistory();

}