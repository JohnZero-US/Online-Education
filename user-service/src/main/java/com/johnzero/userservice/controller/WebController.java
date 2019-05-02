package com.johnzero.userservice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * 描述:
 */
/*
  Created by IntelliJ IDEA.
  Type: Class
  User: John Zero
  DateTime: 2019/5/2 1:22
  Description: 
*/
@RestController
public class WebController {

    @RequestMapping("htmlTest")
    public ModelAndView htmlTest() {
        ModelAndView mav = new ModelAndView("htmlTest");
        return mav;
    }
}
