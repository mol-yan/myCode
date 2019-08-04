package com.hangyan.pathtest;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class pathVariableApplication {
    public static void main(String[] args) {
        SpringApplication.run(pathVariableApplication.class,args);
    }
}
