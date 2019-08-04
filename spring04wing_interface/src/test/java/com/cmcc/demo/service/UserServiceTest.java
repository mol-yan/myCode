package com.cmcc.demo.service;


import com.cmcc.demo.service.impl.UserServiceFestival;
import com.cmcc.demo.service.impl.UserServiceNormal;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.swing.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class UserServiceTest {

    @Autowired
    @Qualifier("userServiceNormal")
    UserService userService;

    @Test
    public void testAdd(){
        userService.add();
    }


}
