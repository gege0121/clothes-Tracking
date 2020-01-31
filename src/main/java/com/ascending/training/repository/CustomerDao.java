package com.ascending.training.repository;
import com.ascending.training.model.Customer;

import java.util.List;

public interface CustomerDao {
    boolean save(Customer customer);
    boolean update(Customer customer);
    boolean delete(String  customerName);
    List<Customer> getCustomers();
    List<Customer> getAllCustomersWithClothes();
    Customer getCustomersById(int id);
    Customer getCustomerByEmail(String email);
    Customer getCustomerByCredentials(String email, String password);
}
