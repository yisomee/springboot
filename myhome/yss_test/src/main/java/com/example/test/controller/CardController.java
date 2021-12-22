package com.example.test.controller;

import org.springframework.stereotype.Controller;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("register")
public class CardController {

    // @GetMapping("login")
    // public String login(){
    //     return "login";
    // }
    // @RequestMapping("mainPage")
    // public String loginOk(){
    //     return "layout/fragments/layout";
    // }
    @RequestMapping("cardPage")
    public String pswPage(){
        return "contents/card/card";
    }

}
