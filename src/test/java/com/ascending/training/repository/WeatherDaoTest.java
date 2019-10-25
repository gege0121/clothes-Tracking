package com.ascending.training.repository;
import com.ascending.training.model.Weather;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class WeatherDaoTest {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private WeatherDao weatherDao;

    @Before
    public void init() {
        weatherDao = new WeatherDaoImpl();
    }

    @Test
    public void getWeathers() {
        List<Weather> weathers = weatherDao.getWeathers();
        int expectedNumOfWeather = 4;

        weathers.forEach(weather -> System.out.println(weather));
        Assert.assertEquals(expectedNumOfWeather, weathers.size());
    }
}