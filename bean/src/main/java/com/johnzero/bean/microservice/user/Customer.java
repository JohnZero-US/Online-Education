package com.johnzero.bean.microservice.user;

import org.springframework.data.annotation.Id;

/**
 * 描述:
 */
/*
  Created by IntelliJ IDEA.
  Type: Class
  User: John Zero
  DateTime: 2019/5/2 15:55
  Description: 
*/
public class Customer {


    @Id
    public String id;

    public String firstName;
    public String lastName;

    public Integer age;

    public Customer() {
    }

    public Customer(String firstName, String lastName, Integer age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format(
                "Customer[id=%s, firstName='%s', lastName='%s', age='%s']",
                id, firstName, lastName, age);
    }
}
