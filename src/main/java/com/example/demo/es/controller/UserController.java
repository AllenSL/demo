package com.example.demo.es.controller;

import com.example.demo.base.util.ResultInfo;
import com.example.demo.base.util.ResultUtil;
import com.example.demo.es.entity.User;
import com.example.demo.es.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName UserController
 * @Description TODO
 * @Autor ansonglin
 * @Date 2019/6/20 14:12
 * @Version 1.0
 **/
@RestController
@RequestMapping("/es")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/addUserMsg")
    public ResultInfo addUserMsg(@RequestBody User user){
        userService.create(user);
        return ResultUtil.success();
    }

    @GetMapping("/findUserByName")
    public ResultInfo findUserInfoByName(Long id){

        userService.findById(id);
        return ResultUtil.success();
    }
}
   