package com.johnzero.userservice.service;

import com.johnzero.bean.microservice.user.User;
import com.johnzero.userservice.mapper.UserMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 描述:
 */
/*
  Created by IntelliJ IDEA.
  Type: Class
  User: John Zero
  DateTime: 2019/5/18 9:20
  Description: 
*/
@Service
public class UserService {

    @Resource
    private UserMapper userMapper;

    //
    @Transactional
    public void addUser(User user) {
         userMapper.addUser(user);
    }

    //
    public User getUser(String username, String password) {
        return userMapper.getUser(username, password);
    }
}
