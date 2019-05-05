package com.johnzero.userservice.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 描述:
 */
/*
  Created by IntelliJ IDEA.
  Type: Class
  User: John Zero
  DateTime: 2019/5/2 15:48
  Description: 
*/

@RestController
public class TestService {
    @Value("${server.port}")
    String port;

    @RequestMapping("/hi")
    public String home(@RequestParam(value = "name", defaultValue = "john_zero") String name) {
        return "hi " + name + " ,i am from port:" + port;
    }

    @RequestMapping("/getPort")
    public String getPort() {
        return port;
    }
}
