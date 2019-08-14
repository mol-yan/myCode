package com.hangyan.LogStudy;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.swing.*;
@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class testLog {
    @Test
    public void testLog(){


        Controller controller= new Controller();
        controller.aaa();
      log.info("info message");
      log.debug("debug message");
      log.warn("waring message");
      log.error("error message");


    }
}
