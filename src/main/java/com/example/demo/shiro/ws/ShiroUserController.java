package com.example.demo.shiro.ws;

import com.example.demo.shiro.dto.UserDto;
import com.example.demo.shiro.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author ansonglin
 * @className UserController
 * @description TODO
 * @date 2019/11/8 9:17
 * @cersion 1.0
 **/
@Slf4j
@RestController
@RequestMapping("/user")
public class ShiroUserController {


    @Autowired
    private IUserService iUserService;

    @PostMapping(value = "/login")
    public ResponseEntity<Void> login(@RequestBody UserDto loginInfo, HttpServletRequest request, HttpServletResponse response){
        Subject subject = SecurityUtils.getSubject();
        try {
            //将用户请求参数封装后，直接提交给Shiro处理
            UsernamePasswordToken token = new UsernamePasswordToken(loginInfo.getUserName(), loginInfo.getPassWord());
            subject.login(token);
            //Shiro认证通过后会将user信息放到subject内，生成token并返回
            UserDto user = (UserDto) subject.getPrincipal();
            String newToken = iUserService.generateJwtToken(user.getUserName());
            response.setHeader("x-auth-token", newToken);
            return ResponseEntity.ok().build();
        } catch (AuthenticationException e) {
            // 如果校验失败，shiro会抛出异常，返回客户端失败
            log.error("User {} login fail, Reason:{}", loginInfo.getUserName(), e.getMessage());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
   