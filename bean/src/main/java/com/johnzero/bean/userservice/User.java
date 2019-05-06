package com.johnzero.bean.userservice;

import java.io.Serializable;

/**
 * 描述: 用户表
 */
/*
  Created by IntelliJ IDEA.
  Type: Class
  User: John Zero
  DateTime: 2019/5/6 13:34
  Description: 
*/
public class User implements Serializable {
    //显式声明UID
    static final long serialVersionUID = 42L;

    private String id;

    private String username;

    private String nickname;

    private String password;

    private Integer age;

    public User() {
    }

    public User(String id, String username, String nickname, String password, Integer age) {
        this.id = id;
        this.username = username;
        this.nickname = nickname;
        this.password = password;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
