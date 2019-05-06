package com.johnzero.viewservice.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 描述:
 */
/*
  Created by IntelliJ IDEA.
  Type: Class
  User: John Zero
  DateTime: 2019/5/2 18:04
  Description: 
*/
@Controller
public class HomeController {

    @Value("${server.port}")
    String port;

    @GetMapping(value = {"/", "/home"})
    public String home(Model model) {
        model.addAttribute("port", port);
        return "home";
    }

/*    @GetMapping(value = {"/", "/home"})
    public ModelAndView home(ModelAndView mav) {
        mav.addObject("port", port);
        mav.setViewName("home");
        return mav;
    }*/
}
