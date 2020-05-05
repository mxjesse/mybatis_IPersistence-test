package com.mx.dao;

import com.mx.pojo.User;

import java.util.List;

/**
 * @author mx
 * @version 1.0
 * @description
 * @date 2020/4/27 11:16 上午
 */
public interface IUserDao {

    List<User> findAll();

    User findByCondition(User user);
}
