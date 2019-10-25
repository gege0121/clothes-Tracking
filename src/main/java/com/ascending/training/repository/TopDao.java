package com.ascending.training.repository;

import com.ascending.training.model.Clothes;

import java.util.List;

public interface TopDao {
    boolean save(Clothes top);
    boolean update(Clothes top);
    boolean delete(String toptName);
    List<Clothes> getTops();
    List<Clothes> getTopsWithChildren();
    Clothes getTopByName(String topName);
    List<Object[]> getTopAndEmployees(String topName);
    List<Object[]> getTopAndEmployeesAndAccounts(String topName);

}
