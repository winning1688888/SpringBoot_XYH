package com.xjy.shiro.service;

import com.xjy.shiro.domain.User;

public interface UserService {

    public User findByName(String name);

    public User findById(Integer id);

}
