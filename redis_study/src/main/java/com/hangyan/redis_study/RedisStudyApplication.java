package com.hangyan.redis_study;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.annotation.EnableCaching;

//@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@MapperScan("com.hangyan.redis_study.Mapper")
@SpringBootApplication
@EnableCaching

public class RedisStudyApplication {
    public static void main(String[] args) {
        SpringApplication.run(RedisStudyApplication.class,args);
    }
}
