package com.ascending.training.controller;


import com.ascending.training.model.Customer;
import com.ascending.training.service.CustomerService;
import com.ascending.training.util.JwtUtil;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping(value={"/auth"})
public class AuthenticationController {
    @Autowired CustomerService customerService;
    @Autowired Logger logger;
    private String errorMsg="wrong?!";
    // /auth POST
    @RequestMapping(value="", method= RequestMethod.POST, produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity authenticate(@RequestBody Customer customer){

        Map<String, String> result=new HashMap<>();
        String token="";

         try{
            Customer c=customerService.getCustomerByCredentials(customer.getEmail(),customer.getPassword());
            if (c ==null){
                result.put("error", errorMsg);
                return ResponseEntity.status(HttpServletResponse.SC_NON_AUTHORITATIVE_INFORMATION).body(result);
            }
            logger.info(">>>>> customer: " + c.toString());

            token=JwtUtil.generateToken(c);
        }
         catch(Exception e){
             String msg=e.getMessage();
             if(msg==null) msg="BAD REQUEST!";
             logger.error(msg);
         }
        //token= JwtUtil.generateToken(customer);
        result.put("token", token);
        return ResponseEntity.status(HttpServletResponse.SC_OK).body(result);
    }
}
