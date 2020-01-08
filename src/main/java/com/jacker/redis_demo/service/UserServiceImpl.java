package com.jacker.redis_demo.service;

import com.jacker.redis_demo.domain.User;
import com.jacker.redis_demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@CacheConfig(cacheNames = "userKey")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Override
    @Cacheable(keyGenerator = "keyGenerator",unless = "#result == null ")
    public User getUserById(int id) {
        System.out.println("查询数据库");
        return userMapper.getUser(id);
    }

    public User getUser(int id) {
        System.out.println("查询数据库");
        return userMapper.getUser(id);
    }

    @Override
    @CacheEvict(key = "#p0")
    public int delete(int id) {
        return userMapper.delete(id);
    }
}
