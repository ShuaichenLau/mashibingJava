package com.alice.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * index
 * @author liusc
 */
@RestController
public class HelloWorldController {
    public static Log log = LogFactory.getLog(HelloWorldController.class);

    @RequestMapping("/")
    public String index(){
        log.info("com.alice.controller.HelloWorldController.index");
        return "helloWorld docker  " + new Date().toString();
    }

    @RequestMapping("/info")
    public String info(){
        log.info("com.alice.controller.HelloWorldController.info");
        return "helloWorld liusc  " + new Date().toString();
    }
}
