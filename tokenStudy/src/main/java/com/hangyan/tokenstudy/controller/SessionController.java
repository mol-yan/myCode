package com.hangyan.tokenstudy.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@CrossOrigin
@Slf4j
public class SessionController {

    @RequestMapping("/addSession")
    public String addSession(HttpServletRequest httpServletRequest,
                             @RequestParam("username") String username) {

        //用于第一次访问时，先到session中取，没有到数据库中取，取到了在setAttribute。
        HttpSession session = httpServletRequest.getSession();
        session.setAttribute("key" + username, username);
        session.setMaxInactiveInterval(10000);
        return "addSuccess";
    }

    @RequestMapping("/getSession")
    public String showSession(HttpServletRequest httpServletRequest, @RequestParam("username") String username) {
        HttpSession session = httpServletRequest.getSession();

        return (String) session.getAttribute("key" + username);
    }
}