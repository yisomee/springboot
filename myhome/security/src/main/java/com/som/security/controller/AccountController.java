package com.som.security.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/account")
public class AccountController {

    // @RequestMapping("/login")
    // public String login(){
    //     return "account/login";
    // }

    @RequestMapping("/login")
    public String login(Model model,HttpServletRequest request){
		// 이전페이지 URL 추출
		String referrer = request.getHeader("Referer");
		request.getSession().setAttribute("prevPage", referrer);
        return "account/login";
    }
    // @PostMapping("/login")
    // public String loginOk(){
    //     return "hello";
    // }

}
