package com.example.demo.shiro.service;

/**
 * @author ansonglin
 * @className IUserService
 * @description TODO
 * @date 2019/11/8 9:24
 * @cersion 1.0
 **/
public interface IUserService {


    String generateJwtToken(String userName);
}
   