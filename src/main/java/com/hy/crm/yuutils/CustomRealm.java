package com.hy.crm.yuutils;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hy.crm.mapper.UserMapper;
import com.hy.crm.pojo.User;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

public class CustomRealm extends AuthorizingRealm {
    @Autowired
    private UserMapper userMapper;

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        //1、先拿到用户名
        Object object=principalCollection.getPrimaryPrincipal();
        System.out.println("用户名=============="+object);
        
        //2、根据用户名查询数据库得到角色和权限
        //角色

        //权限

        //3、返回授权的信息类
        /*SimpleAuthorizationInfo authorizationInfo=new SimpleAuthorizationInfo();
        authorizationInfo.setRoles();
        authorizationInfo.addStringPermissions();
        return authorizationInfo;*/
        return null;

    }


    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken=(UsernamePasswordToken)authenticationToken;
        String username=usernamePasswordToken.getUsername();
        QueryWrapper queryWrapper=new QueryWrapper();
        System.out.println(username);
        queryWrapper.eq("username",username);
        User user=userMapper.selectOne(queryWrapper);

        System.out.println(user.getPassword());
        if(user==null){
            throw new UnknownAccountException("用户不存在！！！");
        }

        SimpleAuthenticationInfo simpleAuthenticationInfo=new SimpleAuthenticationInfo(user.getUsername(),user.getPassword(),getName());
        System.out.println("验证成功！");
        return simpleAuthenticationInfo;
    }
}
