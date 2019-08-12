package com.hangyan;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AnotherInterceptorConfig  implements WebMvcConfigurer {


    public void addInterceptors(InterceptorRegistry registry) {
        // 实现 WebMvcConfigurer 不会导致静态资源被拦截
        registry.addInterceptor(new Interceptor()).addPathPatterns("/**");
    }

}
