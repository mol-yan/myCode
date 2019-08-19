package com.hangyan.tokenstudy.controller;

import com.hangyan.tokenstudy.service.IuserDao;
import com.hangyan.tokenstudy.tokenUtil.TokenUse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Slf4j
@RestController
public class Login {
    @Resource
    private IuserDao iuserDao;

    @RequestMapping("/login/{userCode}/{password}")
    public  String login(@PathVariable("userCode") String userCode,@PathVariable("password") String password) {
    //验证用户登陆信息于数据库中的用户信息是否一致，检查一下
        String passwd = iuserDao.userLogin(userCode);

        if (passwd.equals(password))
        {
            String token = TokenUse.sign(userCode);
            if (token!=null)
            {
                log.info(token);
                return token;
            }
        }
        return "error";
    }


}
