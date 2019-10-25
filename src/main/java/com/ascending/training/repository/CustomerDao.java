package com.ascending.training.repository;

import com.ascending.training.model.Customer;
import java.util.List;

public interface CustomerDao {

    boolean save(Customer customer);
    boolean update(Customer customer);
    boolean delete(String customertName);
    List<Customer> getCustomers();
//    List<Top> getTopsWithChildren();
//    Top getTopByName(String topName);
//    List<Object[]> getTopAndEmployees(String topName);
//    List<Object[]> getTopAndEmployeesAndAccounts(String topName);

}