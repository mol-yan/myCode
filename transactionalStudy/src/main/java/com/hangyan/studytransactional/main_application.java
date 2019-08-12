package com.hangyan.studytransactional;

import org.junit.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//扫描接口DAO
@MapperScan(value = "com.hangyan.studytransactional.Dao")
public class main_application {
    public static void main(String[] args) {
        SpringApplication.run(main_application.class,args);
    }
}
