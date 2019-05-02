package com.johnzero.loadbalancing.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * 描述:
 */
/*
  Created by IntelliJ IDEA.
  Type: Class
  User: John Zero
  DateTime: 2019/5/2 15:31
  Description: 
*/
@RestController
public class TestService {


    @Autowired
    RestTemplate restTemplate;

    @GetMapping(value = "/hi")
    public String hi(@RequestParam String name) {
        return restTemplate.getForObject("http://USER-SERVICE/hi?name=" + name, String.class);
    }
}
