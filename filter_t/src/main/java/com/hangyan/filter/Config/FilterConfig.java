package com.hangyan.filter.Config;

import com.hangyan.filter.OncePerRequestFilter_study;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;


@Configuration//OncePerRequestFilter_study针对这中方式的过滤器
public class FilterConfig {
    @Bean
    public Filter getFilter()
    {
        return  new OncePerRequestFilter_study();
    }
    @Bean//如果有多个过滤器，把这个函数多写几个，然后设置不同的优先级。
    public FilterRegistrationBean<Filter> someFilterRegistration() {

        FilterRegistrationBean<Filter> registration = new FilterRegistrationBean<Filter>();
        //把Filter加入容器
        registration.setFilter(getFilter());
        registration.addUrlPatterns("/*");
        registration.setOrder(1);
        return registration;
    }

}
