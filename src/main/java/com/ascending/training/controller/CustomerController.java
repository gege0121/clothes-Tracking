package com.ascending.training.controller;

import com.ascending.training.model.Customer;
import com.ascending.training.service.CustomerService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = {"/customer"})
public class CustomerController {
    @Autowired private Logger logger;
    @Autowired private CustomerService customerService;

    @RequestMapping(value = "", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Customer> getCustomers(){
        List<Customer> customers = customerService.getCustomers();
        logger.info(">>>>> customers: " + customers.toString());
        return customers;
    }

    //TODO discuss with Ryo /customer?clothes=true
    @RequestMapping(value = "/with-clothes",method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Customer> getAllCustomersWithClothes(){
        return customerService.getAllCustomersWithClothes();
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public Customer getCustomersById(@PathVariable int id){
        return customerService.getCustomersById(id);
    }

    @RequestMapping(value = "/{email}",method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public Customer getCustomersByEmail(@PathVariable String email){
        return customerService.getCustomersByEmail(email);
    }

//    @RequestMapping(value = "/{email}/{password}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
//    public Customer getCustomerByCredentials(@PathVariable String email, @PathVariable String password){
//        return customerService.getCustomerByCredentials(email, password);
//    }

}
