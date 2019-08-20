package com.hangyan.tokenstudy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootApplication
@MapperScan("com.hangyan.tokenstudy.service")
public class main_application {
    public static void main(String[] args) {
        SpringApplication.run(main_application.class,args);
    }
}
