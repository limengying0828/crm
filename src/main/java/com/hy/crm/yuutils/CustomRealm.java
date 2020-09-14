package com.hy.crm.yuutils;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hy.crm.mapper.UserMapper;
import com.hy.crm.pojo.User;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

public class CustomRealm extends AuthorizingRealm {
    @Autowired
    private UserMapper userMapper;

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //1、先拿到用户名
        Object username=principalCollection.getPrimaryPrincipal();
        //2.查看当前用户下的角色权限
        QueryWrapper queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("username",username);
        User user=userMapper.selectOne(queryWrapper);
        System.out.println("--------------"+user.getRole());
        SimpleAuthorizationInfo simpleAuthorizationInfo=new SimpleAuthorizationInfo();
        /*simpleAuthorizationInfo.addRole(user.getRole());*/
        Set<String> set=new HashSet<>();
        set.add(user.getRole());
        simpleAuthorizationInfo.setRoles(set);
        return simpleAuthorizationInfo;

    }


    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken=(UsernamePasswordToken)authenticationToken;
        String username=usernamePasswordToken.getUsername();
        QueryWrapper queryWrapper=new QueryWrapper();
        queryWrapper.eq("username",username);
        User user=userMapper.selectOne(queryWrapper);
        String passwordByMd5 = Md5.JM(user.getPassword());
        if(user==null){
            throw new UnknownAccountException("用户不存在！！！");
        }
        SimpleAuthenticationInfo simpleAuthenticationInfo=new SimpleAuthenticationInfo(user.getUsername(),passwordByMd5,getName());
        return simpleAuthenticationInfo;
    }
}
