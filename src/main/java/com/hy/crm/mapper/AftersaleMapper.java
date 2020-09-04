package com.hy.crm.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hy.crm.bo.lmy.AfterSaleProcessBo;
import com.hy.crm.bo.lmy.ContractSaleBo;
import com.hy.crm.pojo.Aftersale;
import com.hy.crm.sqlclass.AfterSaleSql;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

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
    @SelectProvider(type = AfterSaleSql.class,method ="queryAfterSaleProcessBo")
    public List<AfterSaleProcessBo> queryAfterSaleProcessBo(@Param("classification") String classification, @Param("key")String key, @Param("page")Integer page, @Param("limit")Integer limit,@Param("status") String status);
    @SelectProvider(type = AfterSaleSql.class,method ="querySumCount")
    public Integer queryCount(@Param("classification") String classification, @Param("key")String key,@Param("status") String status);



}
