package com.ascending.training.service;

import com.ascending.training.model.Customer;
import com.ascending.training.repository.CustomerDao;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerDao customerDao;
    private Logger logger;

    public Customer getCustomerByCredentials(String email, String password){
        return customerDao.getCustomerByCredentials(email, password);
    }

    public boolean save(Customer customer){
        return customerDao.save(customer);
    }

    public boolean update(Customer customer){
        return customerDao.update(customer);
    }

    public List<Customer> getCustomers(){
        return customerDao.getCustomers();
    }

    public Customer getCustomersById(int id){
        return customerDao.getCustomersById(id);
    }

    public Customer getCustomersByEmail(String email){
        return customerDao.getCustomerByEmail(email);
    }

    public boolean delete(String customerName){
        return customerDao.delete(customerName);
    }

    public List<Customer> getAllCustomersWithClothes(){
        return customerDao.getAllCustomersWithClothes();
    }



}
