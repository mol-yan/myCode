package com.hangyan.tokenstudy.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class CookieController {
    @RequestMapping("/addCookie")
    public String addCookie(HttpServletRequest request,HttpServletResponse response,
                            @RequestParam("username")String username) {
        Cookie cookie = new Cookie("cookie_"+username, username);
        cookie.setPath(request.getServletPath());
        cookie.setMaxAge(80000);
        response.addCookie(cookie);
        return "addsucess";
    }

    @RequestMapping("/getCookie")
    public String showCookie(HttpServletRequest request, @RequestParam("username")String username) {
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if(cookie.getName().equals("cookie_"+username)) {
                System.out.println(cookie.getName());
                System.out.println(cookie.getValue());
                return cookie.getValue().toString();
            }
        }
        return "null";
    }
}