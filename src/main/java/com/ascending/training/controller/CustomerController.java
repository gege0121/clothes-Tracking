package com.ascending.training.controller;

import com.ascending.training.model.Customer;
import com.ascending.training.service.CustomerService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

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
        List<Customer> customers = customerService.getAllCustomersWithClothes();
        return customers;
    }
//  /customer/2
//   @RequestMapping(value = "/{id}",method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
//    public Customer getCustomersById(@PathVariable int id){
//        return customerService.getCustomersById(id);
//    }
// /customer/ryo.hang@gmail.com
    @RequestMapping(value = "/email",method = RequestMethod.GET, params ="emailName", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Customer getCustomersByEmail(@RequestParam(name = "emailName") String emailName){
        return customerService.getCustomersByEmail(emailName);
    }


    @RequestMapping(value = "", method = RequestMethod.PUT, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public String updateCustomer(@RequestBody Customer customer) {
        logger.debug("Customer: " + customer.toString());
        String msg = "The customer was updated.";
        boolean isSuccess = customerService.update(customer);
        if (!isSuccess) msg = "The customer was not updated.";

        return msg;
    }

    @RequestMapping(value = "/{customerName}", method = RequestMethod.DELETE, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public String deleteCustomer(@PathVariable String customerName) {
        logger.debug("Customer name: " + customerName);
        String msg = "The Customer was deleted.";
        boolean isSuccess = customerService.delete(customerName);
        if (!isSuccess) msg = "The customer was not deleted.";

        return msg;
    }

}
