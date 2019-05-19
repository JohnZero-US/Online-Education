package com.johnzero.userservice.controller;

import com.johnzero.bean.microservice.user.User;
import com.johnzero.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * 描述:
 */
/*
  Created by IntelliJ IDEA.
  Type: Class
  User: John Zero
  DateTime: 2019/5/18 9:52
  Description: 
*/
@RestController
@RequestMapping(path = {"/user"})
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 获取用户
     */
    @PostMapping(value = {"/login"})
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    User
    login(@RequestBody User user) {
        //
        userService.getUser(user.getUsername(), user.getPassword());
        user.setPassword("");
        return user;
    }

    /**
     * 插入用户
     *
     * @param user
     * @return
     */
    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public @ResponseBody
    User
    register(@RequestBody User user) {
        userService.addUser(user);
        user.setPassword("");
        return user;
    }
}
