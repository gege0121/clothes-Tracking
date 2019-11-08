package com.ascending.training.controller;

import com.ascending.training.service.CustomerService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

public class CustomerController {
    @Autowired private Logger logger;
    @Autowired private CustomerService customerService;
}
