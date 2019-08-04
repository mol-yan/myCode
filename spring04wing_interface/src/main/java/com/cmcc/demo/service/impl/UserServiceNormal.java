package com.cmcc.demo.service.impl;

import com.cmcc.demo.service.UserService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class UserServiceNormal implements UserService {


    public void add() {
        System.out.println("添加用户");
    }
}
