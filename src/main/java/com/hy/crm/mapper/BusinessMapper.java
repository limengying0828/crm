package com.hy.crm.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hy.crm.bo.lmy.ExpectedMoneyBo;
import com.hy.crm.pojo.Business;
import com.hy.crm.sqlclass.MyDeskTopSql;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

/**
 * <p>
 * 商机表 Mapper 接口
 * </p>
 *
 * @author zzx
 * @since 2020-08-28
 */
public interface BusinessMapper extends BaseMapper<Business> {
    @SelectProvider(type = MyDeskTopSql.class,method = "queryMoney")
    public List<ExpectedMoneyBo> queryMoney();

}
