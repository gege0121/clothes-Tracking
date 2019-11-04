package com.ascending.training.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TestController {


    private Logger logger = LoggerFactory.getLogger(getClass());
//    @Autowired
//    private ClothesService clothesService;
//    @RequestMapping(value = "/paths", method = RequestMethod.GET, produces ={MediaType.APPLICATION_JSON_VALUE})
//    public String helloWorld(){
//        Map<String, String> m=new HashMap();
//        m.put("result","HelloWorld!");
//        return m;
//    }
//@RequestMapping(value="/users", method= RequestMethod.GET,produces= {MediaType.APPLICATION_JSON_VALUE})
//    public List<User> getuser(){
//return clothesService.getAll();
//    }
//@RequestMapping(value = "/example", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
//public String getPara(@RequestParam(name = "param")String param,@RequestParam(name = "param2") String){
//    logger.info(String.format("Param:%s",param));
//    logger.info(String.format("Param:%s",param2));
//    return param;
//            }
    @RequestMapping(value = "/example", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public String getPara(@RequestParam(name="param") String param,@RequestParam(name = "param1") String param1) {
        logger.info(String.format("Param:%s",param));
        logger.info(String.format("Param:%s",param1));
        return param;
    }

    //@RequestMapping(value="/body",method = RequestMethod.POST)



//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//@RequestMapping(value = "/",method = RequestMethod.GET, produces = {})
}
