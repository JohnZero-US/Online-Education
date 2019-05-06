package com.johnzero.userservicecluster.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * 描述:
 */
/*
  Created by IntelliJ IDEA.
  Type: Class
  User: John Zero
  DateTime: 2019/5/5 23:02
  Description: 
*/
@RefreshScope
@RestController
public class TestService {

    @Autowired
    RestTemplate restTemplate;

    /**
     * 负载均衡测试
     *
     * @return
     */
    @GetMapping("/getPort")
    @HystrixCommand(fallbackMethod = "getPortError") //熔断功能，调用熔断提示
    public String getPort() {
        //
        String us_port = restTemplate.getForObject("http://USER-SERVICE/getPort", String.class);

        return us_port;
    }

    /**
     * 熔断提示
     *
     * @return
     */
    public String getPortError() {
        return "Get USER-SERVICE port is error!";
    }

}
