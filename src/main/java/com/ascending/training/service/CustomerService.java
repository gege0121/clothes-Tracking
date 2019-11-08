package com.ascending.training.service;

import com.ascending.training.model.Customer;
import com.ascending.training.repository.CustomerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    @Autowired
    private CustomerDao customerDao;
    public Customer getCustomerByCredentials(String email, String password){
        return customerDao.getCustomerByCredentials(email, password);
    }
}
