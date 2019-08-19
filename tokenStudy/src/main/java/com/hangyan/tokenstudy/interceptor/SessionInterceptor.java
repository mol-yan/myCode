package com.hangyan.tokenstudy.interceptor;


import com.hangyan.tokenstudy.tokenUtil.TokenUse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
@Slf4j
public class SessionInterceptor implements HandlerInterceptor{


    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        String methodName = method.getName();
        log.info("====拦截到了方法：{}，在该方法执行之前执行====", methodName);
        response.setCharacterEncoding("utf-8");
        String token=request.getHeader("token");

        if (token!=null){
            boolean bo= TokenUse.tokenVerify(token);
            if (bo){
                return true;
            }
        }
        return false;
    }


    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }


    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}

