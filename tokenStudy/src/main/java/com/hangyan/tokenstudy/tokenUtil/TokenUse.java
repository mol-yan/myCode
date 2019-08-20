package com.hangyan.tokenstudy.tokenUtil;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.hangyan.tokenstudy.bo.User;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TokenUse {
    //过期时间24小时
    private static final long overdeuTime = 1440 * 60 * 1000;
    //私钥uuid生成，确定唯一性
    private static final String tokenSecRet = "fde35b32-0f47-46be-ae2a-49bcb7ed7d7f";

    /**
     * 生成token，用户退出后消失
     *
     * @param userCode
     * @param userId
     * @return
     */
    public static String sign(User user) {
        try {
            //设置过期时间
            Date date = new Date(System.currentTimeMillis() + overdeuTime);
            //token私钥加密
            Algorithm algorithm = Algorithm.HMAC256(tokenSecRet);
            //设置头部信息,jwt头部的信息包括哪些？
            Map<String, Object> requestHender = new HashMap<String, Object>(2);
            requestHender.put("type", "JWT");
            requestHender.put("encryption", "HS256");
            long date1 = new Date().getTime();

            //返回带有用户信息的签名,.withClaim表示存放沟通信息payload，withHeader存放头，sign签名算法，withExpiresAt有效期
            return JWT.create().withHeader(requestHender)
                    .withClaim("username",user.getUsername())
                    .withClaim("userid",user.getUserid())
                    .withClaim("passwd",user.getPasswd())
                    .withClaim("sign_time", date1)
                    .withExpiresAt(date)
                    .sign(algorithm);

        } catch (UnsupportedEncodingException e) {
            return null;
        }
    }

    /**
     * 验证token是否正确
     *
     * @param token
     * @return
     */
    public static JWTVerifier tokenVerify(String tokenSecRet) throws UnsupportedEncodingException {

            Algorithm algorithm = Algorithm.HMAC256(tokenSecRet);
            JWTVerifier verifier = JWT.require(algorithm).build();
//            DecodedJWT decodedJWT = verifier.verify(token);
            return verifier;

    }

    /**
     * 获取登陆用户token中的用户ID
     *
     * @param token
     * @return
     */
    public static String getUserID(String token) {
        DecodedJWT decodedJWT = JWT.decode(token);
        return decodedJWT.getClaim("userid").asString();
    }
}
