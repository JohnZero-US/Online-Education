package com.johnzero.viewservice.controller;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Date;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * 描述:
 */
/*
  Created by IntelliJ IDEA.
  Type: Class
  User: John Zero
  DateTime: 2019/5/7 17:03
  Description: 
*/
@RestController
public class ELKController {

    private static final Logger LOG = LogManager.getLogger(ELKController.class.getName());

    @Autowired
    RestTemplate restTemplete;


    @RequestMapping(value = "/elkdemo")
    public String helloWorld() {
        String response = "Hello user ! " + new Date();
        LOG.log(Level.INFO, "/elkdemo - &gt; " + response);

        return response;
    }

    /**
     *
     * @return
     */
    @RequestMapping(value = "/elk")
    public String helloWorld1() {

        //
        String response = (String) restTemplete
                .exchange("http://127.0.0.1:9080/elkdemo",HttpMethod.GET,null,
                new ParameterizedTypeReference() {}).getBody();
        //
        LOG.log(Level.INFO, "/elk - &gt; " + response);

        try {
            //
            String exceptionrsp = (String) restTemplete.exchange("http://127.0.0.1:9080/exception", HttpMethod.GET,
                    null, new ParameterizedTypeReference() {}).getBody();

            //
            LOG.log(Level.INFO, "/elk trying to print exception - &gt; " + exceptionrsp);
            //
            response = response + " === " + exceptionrsp;
        } catch (Exception e) {
            // exception should not reach here. Really bad practice 🙂
        }

        return response;
    }

    /**
     *
     * @return
     */
    @RequestMapping(value = "/exception")
    public String exception() {
        //
        String rsp = "";
        //
        try {
            int i = 1 / 0;
            // should get exception
        } catch (Exception e) {
            e.printStackTrace();
            LOG.error(e);
            //
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);
            //
            String sStackTrace = sw.toString(); // stack trace as a string
            LOG.error("Exception As String :: - &gt; " + sStackTrace);

            rsp = sStackTrace;
        }
        return rsp;
    }
}
