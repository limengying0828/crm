package com.hy.crm.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hy.crm.mapper.UserMapper;
import com.hy.crm.pojo.User;
import com.hy.crm.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author zzx
 * @since 2020-08-28
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    @Autowired
    private UserMapper userMapper;

    /**
     * 登录
     * 注册的时候查有没有这个账号
     * @param user
     * @return
     */
    @Override
    public User selname(User user) {
        User user1= userMapper.selname(user);
        return user1;
    }

    /**
     * 注册
     * @return
     */
    @Override
    public void registerUser(User user) {
        userMapper.registerUser(user);
    }

    /**
     * 注册前查询账号是否存在
     * @param user
     * @return
     */
    @Override
    public User selusername(User user){
        return userMapper.selusername(user);
    };
}
