package com.jacker.redis_demo.controller;


import com.jacker.redis_demo.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisController {

    @Autowired
    private RedisUtils redisUtils;

    @RequestMapping("/redis/setAndGet")
    public String setAndGetValue(String name,String value){
        redisUtils.set(name,value);
        return (String) redisUtils.get(name);
    }
}
