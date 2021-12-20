package com.som.myhome.controller;

import com.som.myhome.model.User;
import com.som.myhome.service.UserService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/account")
@RequiredArgsConstructor
public class AccountController {
    
    private final UserService userService;

    @GetMapping("/login")
    public String login(){
        return "account/login";
    }

    @PostMapping("/register")
    public String register(User user){
        userService.save(user);
        return "account/register";
    }
}
