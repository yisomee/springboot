package com.som.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index(){
        return "home";
    } 
    
    @GetMapping("hello")
    public String hello(){
        return "hello";
    }
}
