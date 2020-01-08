package com.jacker.redis_demo.service;

import com.jacker.redis_demo.domain.User;

public interface UserService {

    public User getUserById(int id);

    public int delete(int id);

    public User getUser(int id);

}
