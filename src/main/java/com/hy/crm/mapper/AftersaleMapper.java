package com.hy.crm.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hy.crm.bo.lmy.AfterSaleUserBo;
import com.hy.crm.bo.lmy.ContractSaleBo;
import com.hy.crm.pojo.Aftersale;
import com.hy.crm.sqlclass.AfterSaleSql;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;

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
    public List<Aftersale> queryAfterSaleProcessBo(@Param("classification") String classification, @Param("key")String key, @Param("page")Integer page, @Param("limit")Integer limit,@Param("status") String status);

    @SelectProvider(type = AfterSaleSql.class,method ="querySumCount")
    public Integer queryCount(String status);

    @Select("select * from `user` u,aftersale af,customer c,contract con,contractprocess cp where u.userid=af.userid and c.customerid=af.customerid  and cp.contractid=con.contractid and af.saleid=#{saleid}  ")
    public AfterSaleUserBo queryAfterSaleUserBoByTheme(Integer saleid);

    @Update("update aftersale set realstatus='已结束',overtime=#{overtime} where saleid=#{serviceid}")
    public boolean updateAfterSaleStatus(Integer serviceid,String overtime);




}
