package com.hangyan.activemq.Config;

import com.hangyan.activemq.Controller.ProducerController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class JmsTest {
    @Autowired
    ProducerController producerController;
    @Test
    public void test(){

        producerController.sendMessage();


    }
}
