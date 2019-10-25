package com.ascending.training.repository;

import com.ascending.training.model.Accessory;

import java.util.List;

public interface AccessoryDao {
    boolean save(Accessory accessory);
    boolean update(Accessory accessory);
    boolean delete(String accessorytName);
    List<Accessory> getAccessories();
//    List<Top> getTopsWithChildren();
//    Top getTopByName(String topName);
//    List<Object[]> getTopAndEmployees(String topName);
//    List<Object[]> getTopAndEmployeesAndAccounts(String topName);

}