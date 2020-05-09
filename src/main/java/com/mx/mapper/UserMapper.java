package com.mx.mapper;

import com.mx.pojo.User;

import java.util.List;

public interface UserMapper {

    List<User> findAll();

    User findByCondition(User user);

    boolean add(List<User> users);

    boolean update(User user);

    boolean delete(User user);
}
