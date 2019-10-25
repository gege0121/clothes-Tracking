package com.ascending.training.repository;

import com.ascending.training.model.Weather;

import java.util.List;

public interface WeatherDao {
    boolean save(Weather weather);
    boolean update(Weather weather);
    boolean delete(String weatherName);
    List<Weather> getWeathers();
//    List<Top> getTopsWithChildren();
//    Top getTopByName(String topName);
//    List<Object[]> getTopAndEmployees(String topName);
//    List<Object[]> getTopAndEmployeesAndAccounts(String topName);

}