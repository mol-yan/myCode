package com.hangyan.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
//@WebFilter()这个注解设置url也可以，不过这里使用的CONFIG模式
@Slf4j
public class OncePerRequestFilter_study extends OncePerRequestFilter {
    @Override
    //出发拦截时被调用
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        log.info(request.getRequestURL().toString());
        log.info("OncePerRequestFilter instance");
        filterChain.doFilter(request,response);
    }
}
