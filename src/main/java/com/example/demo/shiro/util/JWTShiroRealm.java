package com.example.demo.shiro.util;

import com.example.demo.shiro.service.impl.IUserServiceImpl;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * @author ansonglin
 * @className JWTShiroRealm
 * @description TODO
 * @date 2019/11/8 10:53
 * @cersion 1.0
 **/
public class JWTShiroRealm extends AuthorizingRealm {

    protected IUserServiceImpl iUserServiceImpl;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        return null;
    }
}
   