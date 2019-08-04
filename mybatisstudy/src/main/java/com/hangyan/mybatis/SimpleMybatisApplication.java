package com.hangyan.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.Mapping;

import javax.swing.*;

@SpringBootApplication
@MapperScan("com.hangyan.mybatis.Mapper")
public class SimpleMybatisApplication {
    public static void main(String[] args) {
        SpringApplication.run(SimpleMybatisApplication.class,args);
    }
}
