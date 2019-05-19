package com.johnzero.userservice.mapper;

import com.johnzero.bean.microservice.user.User;
import org.apache.ibatis.annotations.*;
import org.springframework.data.repository.query.Param;

/**
 * 描述:
 */
/*
  Created by IntelliJ IDEA.
  Type: Class
  User: John Zero
  DateTime: 2019/5/18 9:23
  Description: 
*/
@Mapper
public interface UserMapper {

    /**
     * @param user
     */
    @SelectKey(keyProperty = "id", resultType = String.class, before = true, statement = "select uuid()")
    @Options(keyProperty = "id", useGeneratedKeys = true)
    @Insert("insert into user (id,username,nickname,password,age) values (#{id},#{username},#{nickname}," +
            "#{password},#{age})")
    void addUser(User user);


    /**
     * @param username
     * @param password
     * @return
     */
    @Select("select DISTINCT * from user where username=#{username} and password=#{password}")
    @Results(
            id = "userResult",
            value = {
                    @Result(property = "id", column = "id", id = true),
                    @Result(property = "username", column = "username"),
                    @Result(property = "nickname", column = "nickname"),
                    @Result(property = "password", column = "password"),
                    @Result(property = "age", column = "age"),
            }
    )
    User getUser(@Param("username") String username, @Param("password") String password);
}
