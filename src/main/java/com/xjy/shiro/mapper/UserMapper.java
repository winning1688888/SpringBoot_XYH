package com.xjy.shiro.mapper;

import com.xjy.shiro.domain.User;

public interface UserMapper {

    public User findByName(String name);

    public User findById(Integer id);
}
