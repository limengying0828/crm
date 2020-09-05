package com.hy.crm.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hy.crm.pojo.User;

/**
 * @author yukangze
 * @version 1.0
 * @description
 * @date 2020-09-01 11:18
 */
public interface IUserService extends IService<User> {

    /**
     * 登录
     * 注册的时候查有没有这个账号
     * @param user
     * @return
     */
    public User selname(User user);

    /**
     * 注册
     * @return
     */
    public void registerUser(User user);

    /**
     * 注册前查询账号是否存在
     * @param user
     * @return
     */
    public User selusername(User user);


}
