package com.hy.crm.mapper;

import com.hy.crm.pojo.Busprocess;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hy.crm.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 商机处理过程表 Mapper 接口
 * </p>
 *
 * @author zzx
 * @since 2020-08-28
 */
public interface BusprocessMapper extends BaseMapper<Busprocess> {
    @Select("select * from busprocess where businessid=#{businessid} order by disposetime desc limit 1")
    public Busprocess seltodaystate(Busprocess busprocess);
}
