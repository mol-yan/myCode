package com.hangyan.tokenstudy.controller;

import com.alibaba.fastjson.JSONObject;
import com.hangyan.tokenstudy.annotation.PassToken;
import com.hangyan.tokenstudy.annotation.UserLoginToken;
import com.hangyan.tokenstudy.bo.User;
import com.hangyan.tokenstudy.service.IuserDao;
import com.hangyan.tokenstudy.tokenUtil.TokenUse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;

@Slf4j
@RestController
public class Login {
    @Resource
    private IuserDao iuserDao;


    @PassToken
    @RequestMapping("/register")
    public Object register(@RequestBody User user) throws UnsupportedEncodingException {
        JSONObject jsonObject = new JSONObject();
        User userForBase = iuserDao.findUserById(user.getUserid());
        if (userForBase == null) {
            jsonObject.put("message", "登录失败,用户不存在");
            return jsonObject;
        } else {
            if (!userForBase.getPasswd().equals(user.getPasswd())) {
                jsonObject.put("message", "登录失败,密码错误");
                return jsonObject;
            } else {

                String token = TokenUse.sign(userForBase);
                jsonObject.put("token", token);
                jsonObject.put("user", userForBase);
                return jsonObject;
            }
        }

    }

    @UserLoginToken
    @RequestMapping("/get")
    public String login() {
        return "login success";
    }


}
