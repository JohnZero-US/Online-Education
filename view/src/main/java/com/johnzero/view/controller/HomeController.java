package com.johnzero.view.controller;

import org.springframework.stereotype.Controller;
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


    @GetMapping("home")
    public String home() {
        return "home";
    }
}
