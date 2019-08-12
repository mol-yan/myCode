package com.hangyan.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class doFilter {

    @RequestMapping("/interceptor")
    public String sendHello(){
        return "hello";
    }
}
