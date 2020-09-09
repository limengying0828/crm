package com.hy.crm.mapper;

import com.hy.crm.pojo.Remits;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 * 汇款额详情表 Mapper 接口
 * </p>
 *
 * @author zzx
 * @since 2020-08-28
 */
public interface RemitsMapper extends BaseMapper<Remits> {

    @Select("select * from remits where contractid = #{contractid}")
    public Remits queryAll(String contractid);
}
