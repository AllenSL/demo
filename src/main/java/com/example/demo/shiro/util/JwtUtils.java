package com.example.demo.shiro.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import java.io.UnsupportedEncodingException;
import java.util.Date;

/**
 * @author ansonglin
 * @className JWTUtil
 * @description TODO
 * @date 2019/11/8 9:49
 * @cersion 1.0
 **/
public class JwtUtils {


    /**
     * 生成签名，expireTime后过期
     *
     * @param userName
     * @param salt
     * @param expireTime token失效时间(s)
     * @return
     */
    public static String sign(String userName, String salt, Long expireTime) {
        try {
            Date date = new Date(System.currentTimeMillis() + expireTime * 1000);
            Algorithm algorithm = Algorithm.HMAC256(salt);
            return JWT.create().withClaim("username", userName)
                    .withExpiresAt(date)
                    .withIssuedAt(new Date())
                    .sign(algorithm);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }
}
   