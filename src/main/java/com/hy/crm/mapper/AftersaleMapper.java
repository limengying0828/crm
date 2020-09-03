package com.hy.crm.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hy.crm.bo.lmy.ContractSaleBo;
import com.hy.crm.pojo.Aftersale;
import com.hy.crm.sqlclass.AfterSaleSql;
import org.apache.ibatis.annotations.SelectProvider;

/**
 * <p>
 * 售后服务 Mapper 接口
 * </p>
 *
 * @author zzx
 * @since 2020-08-28
 */
public interface AftersaleMapper extends BaseMapper<Aftersale> {
    @SelectProvider(type = AfterSaleSql.class,method = "queryContractSaleByUserName")
    public ContractSaleBo queryContractSaleBo(String contractid);

}
