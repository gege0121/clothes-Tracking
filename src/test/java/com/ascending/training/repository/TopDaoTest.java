package com.ascending.training.repository;

import com.ascending.training.model.Clothes;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class TopDaoTest {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private TopDao topDao;

    @Before
    public void init() {
        topDao = new TopDaoImpl();
    }

    @Test
    public void getTops() {
        List<Clothes> tops = topDao.getTops();
        int expectedNumOfTop = 4;

        tops.forEach(t -> System.out.println(t));
//        for(Top t:tops){
//            System.out.println(t)
//        }
        Assert.assertEquals(expectedNumOfTop, tops.size());
    }
    @Test
    public void getTopByNameTest(){

    }
//
//    @Test
//    public void getDepartmentByName() {
//        String deptName = "HR";
//        Department department = departmentService.getDepartmentByName(deptName);
//
//        logger.info(department.toString());
//        logger.info(department.getEmployees().toString());
//        logger.info(department.getEmployees().stream().findFirst().get().getAccounts().toString());
//
//        Assert.assertEquals(deptName, department.getName());
//    }
//
//    @Test
//    public void updateDepartmentLocation() {
//        String deptName = "R&D";
//        String location = "11126 Fairhaven Court, Fairfax, VA";
//        Department department = departmentService.getDepartmentByName(deptName);
//        department.setLocation(location);
//        departmentService.update(department);
//        department = departmentService.getDepartmentByName(deptName);
//        Assert.assertEquals(location, department.getLocation());
//    }
}