package com.hangyan;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


import java.lang.reflect.Method;

@Slf4j
public class Interceptor implements HandlerInterceptor {
    public Interceptor() {
        super();
    }

    public boolean preHandle(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, Object handler) throws Exception {
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        String methodName = method.getName();
        log.info("====拦截到了方法：{}，在该方法执行之前执行====", methodName);
        // 返回 true 才会继续执行，返回 false 则取消当前请求
        // 判断用户有没有登陆，一般登陆之后的用户都有一个对应的 token
        String token = request.getParameter("token");
        if (null == token || "".equals(token)) {
            log.info("用户未登录，没有权限执行……请登录");
            return false;
        }

        return true;

    }

    public void postHandle(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("执行完方法之后进执行(Controller方法调用之后)，但是此时还没进行视图渲染");

    }

    public void afterCompletion(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("整个请求都处理完咯，DispatcherServlet也渲染了对应的视图咯，此时我可以做一些清理的工作了");

    }
}
