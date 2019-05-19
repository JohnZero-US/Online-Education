package com.johnzero.userservice.repository;

import com.johnzero.bean.microservice.user.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * 描述:
 */
/*
  Created by IntelliJ IDEA.
  Type: Class
  User: John Zero
  DateTime: 2019/5/2 16:10
  Description: 
*/
public interface CustomerRepository extends MongoRepository<Customer, String> {

    Customer findByFirstName(String firstName);

    List<Customer> findByLastName(String lastName);

    Customer findByAge(int age);
}
