package com.hangyan.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DoInterceptor {

    @RequestMapping("/interceptor")
    public String sendHello(){
        return "hello";
    }
}
