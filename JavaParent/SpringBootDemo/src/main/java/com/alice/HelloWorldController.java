package com.alice;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class HelloWorldController {

    @RequestMapping("/")
    public String index(){
        return "helloWorld docker" + new Date().getTime();
    }
}
