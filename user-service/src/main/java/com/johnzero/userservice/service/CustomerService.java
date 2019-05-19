package com.johnzero.userservice.service;


import com.johnzero.bean.microservice.user.Customer;
import com.johnzero.bean.microservice.user.User;
import com.johnzero.userservice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

/**
 * 描述:
 */
/*
  Created by IntelliJ IDEA.
  Type: Class
  User: John Zero
  DateTime: 2019/5/2 16:11
  Description: 
*/
@Service
public class CustomerService implements CommandLineRunner {

    @Autowired
    private CustomerRepository repository;

    @Autowired
    private UserService userService;

    @Override
    public void run(String... args) throws Exception {

      /*  repository.deleteAll();

        // save a couple of customers
        repository.save(new Customer("Alice", "Smith", 25));
        repository.save(new Customer("Bob", "Smith", 31));

        // fetch all customers
        System.out.println("Customers found with findAll():");
        System.out.println("-------------------------------");
        for (Customer customer : repository.findAll()) {
            System.out.println(customer);
        }
        System.out.println();

        // fetch an individual customer
        System.out.println("Customer found with findByFirstName('Alice'):");
        System.out.println("--------------------------------");
        System.out.println(repository.findByFirstName("Alice"));

        System.out.println("Customers found with findByLastName('Smith'):");
        System.out.println("--------------------------------");
        for (Customer customer : repository.findByLastName("Smith")) {
            System.out.println(customer);
        }

        System.out.println("Customer found with findByAge(25):");
        System.out.println("--------------------------------");
        System.out.println(repository.findByAge(25));*/



    }
}
