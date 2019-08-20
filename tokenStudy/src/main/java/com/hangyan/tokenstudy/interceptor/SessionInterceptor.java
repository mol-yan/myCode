package com.hangyan.tokenstudy.interceptor;


import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.hangyan.tokenstudy.annotation.PassToken;
import com.hangyan.tokenstudy.annotation.UserLoginToken;
import com.hangyan.tokenstudy.bo.User;
import com.hangyan.tokenstudy.constans.TokenErroeCodeEnum;
import com.hangyan.tokenstudy.expection.TokenExpection;
import com.hangyan.tokenstudy.service.IuserDao;
import com.hangyan.tokenstudy.tokenUtil.TokenUse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

@Slf4j
public class SessionInterceptor implements HandlerInterceptor {

    @Resource
    IuserDao iuserDao;

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        // 如果不是映射到方法直接通过
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        //检查是否有passtoken注释，有则跳过认证
        if (method.isAnnotationPresent(PassToken.class)) {
            PassToken passToken = method.getAnnotation(PassToken.class);
            if (passToken.required()) {
                return true;
            }
        }
        String token = request.getHeader("token");// 从 http 请求头中取出 token
        //检查有没有需要用户权限的注解
        if (method.isAnnotationPresent(UserLoginToken.class)) {
            UserLoginToken userLoginToken = method.getAnnotation(UserLoginToken.class);
            if (userLoginToken.required()) {
                // 执行认证
                //所谓的认证做了两件事：
                //1、从Http头中拿到token，先进行解析，获取id，根据id从数据库中找信息，找到了说明该id不是假的
                //2、根据密钥，对token进行验证，看是不是这个算法之前产生的toekn
                //还有其他的验证方法，比如第一次注册时用把用户Id和token结合，然后放入redis中，
                // 在拦截器里根据redis拿出token对比看在不在redis中。

                if (token == null) {
                    throw new TokenExpection(TokenErroeCodeEnum.NOT_FIND_TOKEN, "无token，请重新登录");
//                    throw new RuntimeException("无token，请重新登录");
                }
                // 获取 token 中的 user id
                String userId = "";
                try {
//                    userId = JWT.decode(token).getAudience().get(0);
                    userId = TokenUse.getUserID(token);
                } catch (JWTDecodeException j) {
                    throw new TokenExpection(TokenErroeCodeEnum.VERTY_FAILED, "验证失败");
//                    throw new RuntimeException("401");
                }
                log.info("验证解密userid: " + userId);

                User user = iuserDao.findUserById(userId);
                if (user == null) {
                    throw new TokenExpection(TokenErroeCodeEnum.NOT_FIND_USER, "用户不存在，请重新登录");
//                    throw new RuntimeException("用户不存在，请重新登录");
                }
                // 验证 token
                JWTVerifier jwtVerifier = TokenUse.tokenVerify("fde35b32-0f47-46be-ae2a-49bcb7ed7d7f");
//                JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(user.getPasswd())).build();
                try {
                    jwtVerifier.verify(token);
                } catch (JWTVerificationException e) {
                    throw new TokenExpection(TokenErroeCodeEnum.VERTY_FAILED);

//                    throw new RuntimeException("401");

                }
                return true;
            }
        }
        return true;
    }


    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }


    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}

