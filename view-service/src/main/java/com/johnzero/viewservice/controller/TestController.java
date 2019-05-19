package com.johnzero.viewservice.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
  DateTime: 2019/5/2 18:10
  Description: 
*/
@RefreshScope
@RestController
public class TestController {

    @Value("${server.tomcat.max-connections}")
    private int maxConnections;

    @Value("${server.tomcat.max-threads}")
    private int maxThreads;


    @Value("${server.port}")
    private String port;

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/getMaxConnectAndMaxThread")
    public String getMaxConnectAndMaxThread() {
        return String.format("总连接数为：%s，总线程数为：%s", String.valueOf(maxConnections), String.valueOf(maxThreads));
    }


    /**
     * @return
     */
    @GetMapping("/getPort")
    @HystrixCommand(fallbackMethod = "getPortError")  //断路器发生调用方法
    public String getPort() {
        //
        String us_port = restTemplate.getForObject("http://USER-SERVICE/getPort", String.class);

        return String.format("View Port:%s,User-Service port:%s", port, us_port);
    }

    public String getPortError() {
        return "Get User-Service Error!!!";
    }


    /**
     * @return
     */
    @GetMapping("/getPort2")
    public String getPort2() {
        //
        String us_port = restTemplate.getForObject("http://127.0.0.1:12000/getPort", String.class);

        return String.format("View Port:%s,User-Service port:%s", port, us_port);
    }

}
