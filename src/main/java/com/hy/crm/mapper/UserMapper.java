package com.hy.crm.mapper;

import com.hy.crm.pojo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author zzx
 * @since 2020-08-28
 */
public interface UserMapper extends BaseMapper<User> {
    /**
     * 登录根据名字查密码
     * @param user
     * @return
     */
    @Select("select * from user where username=#{username}")
    public User selname(User user);

    /**
     * 注册
     * @param user
     * @return
     */
    @Insert("insert into user (username,password,image) values (#{username},#{password},#{image})")
    public void registerUser(User user);

    /**
     * 注册前查询账号是否存在
     * @param user
     * @return
     */
    @Select("select username from user where username=#{username}")
    public User selusername(User user);

}
