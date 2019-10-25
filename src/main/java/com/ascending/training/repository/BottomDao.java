package com.ascending.training.repository;

import com.ascending.training.model.Bottom;

import java.util.List;

public interface BottomDao {
    boolean save(Bottom bottom);
    boolean update(Bottom bottom);
    boolean delete(String bottomtName);
    List<Bottom> getBottoms();
//    List<Top> getTopsWithChildren();
//    Top getTopByName(String topName);
//    List<Object[]> getTopAndEmployees(String topName);
//    List<Object[]> getTopAndEmployeesAndAccounts(String topName);

}