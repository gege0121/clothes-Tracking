package com.ascending.training.jdbc;

import org.junit.runners.Suite;


    @Suite.SuiteClasses({
            TopDaoTest.class,
            BottomDaoTest.class,
            AccessoryDaoTest.class,
            CustomerDaoTest.class,
            WeatherDaoTest.class
    })
            public class TestAll {

}
