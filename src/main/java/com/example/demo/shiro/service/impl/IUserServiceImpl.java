package com.example.demo.shiro.service.impl;

import com.example.demo.shiro.service.IUserService;
import com.example.demo.shiro.util.JwtUtils;
import org.springframework.stereotype.Service;

/**
 * @author ansonglin
 * @className IUserServiceImpl
 * @description TODO
 * @date 2019/11/8 9:32
 * @cersion 1.0
 **/
@Service
public class IUserServiceImpl implements IUserService {


    @Override
    public String generateJwtToken(String userName) {
        String salt = "1234";
        return JwtUtils.sign(userName, salt, 60 * 60L);
    }
}
   