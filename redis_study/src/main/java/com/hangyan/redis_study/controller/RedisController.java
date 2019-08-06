package com.hangyan.redis_study.controller;

import com.hangyan.redis_study.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class RedisController {

    @Resource
    private RedisTemplate redisTemplate;
    @Autowired
    private RedisService redisService;

    @RequestMapping("/redis/setAndGet")
    @ResponseBody
    public String serAndFetValue(String name ,String value)
    {
        redisService.set(name,value);
//        redisTemplate.opsForValue().set(name,value);
//        return (String) redisTemplate.opsForValue().get(name);
        return  redisService.get(name).toString();
    }
}
