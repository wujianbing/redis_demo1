package com.jacker.redis_demo.controller;

import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jacker.redis_demo.RedisService;
import com.jacker.redis_demo.RedisUtils;
import com.jacker.redis_demo.domain.User;
import com.jacker.redis_demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RedisService redisService;

    private static final String key = "userKey_";
    @RequestMapping("getUserById")
    public User getUserById(int id){
        JSONObject jsonObject = (JSONObject) redisService.get(key+id);
        User user = JSON.toJavaObject(jsonObject,User.class);
        if(user == null){
            user = userService.getUserById(id);
            if(user != null){
                redisService.set(key+id, JSON.toJSON(user));
                return user;
            }
        }
        return user;
    }

    @RequestMapping("getCache")
    public User getCache(int id){
        return userService.getUserById(id);
    }

    @RequestMapping("getBySql")
    public User getBySql(int id){
        return userService.getUser(id);
    }
}
