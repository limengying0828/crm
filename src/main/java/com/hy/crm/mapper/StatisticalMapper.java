package com.hy.crm.mapper;

import com.hy.crm.bo.lmy.BusinessUserBo;
import com.hy.crm.bo.lmy.FunnelBo;
import com.hy.crm.bo.lmy.OriginBo;
import com.hy.crm.bo.lmy.TradeBo;
import com.hy.crm.sqlclass.StatisticalSql;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

/**
 * @Author: 李梦莹
 * @create: 2020/9/7 10:14
 * @Description:
 */
public interface StatisticalMapper {
    @SelectProvider(type = StatisticalSql.class,method = "queryMyStaBusiness")
    public Integer queryMyStaBusiness(String time);

    @SelectProvider(type = StatisticalSql.class,method = "querySuccessCount")
    public Integer quertMyStaBusprocess(String time);

    @SelectProvider(type = StatisticalSql.class,method = "queryDocumentaryCount")
    public Integer quertMyStaDocumentary(String time);

    @SelectProvider(type = StatisticalSql.class,method = "queryContractCount")
    public Integer queryContractCount(String time);

    @SelectProvider(type = StatisticalSql.class,method = "queryFunnel")
    public FunnelBo queryFunnel(String status,String time);

    @SelectProvider(type = StatisticalSql.class,method = "queryBusinessByTrade")
    public List<TradeBo> queryBusinessByTrade();

    @Select("select customersource as originname,count(*) as count,SUM(makemoney) as money from business GROUP BY customersource")
    public List<OriginBo> queryBusinessByOrigin();

    @SelectProvider(type = StatisticalSql.class,method ="queryBusinessByTime" )
    public List<BusinessUserBo> queryBusinessByTime(String time,Integer userid);

    @SelectProvider(type = StatisticalSql.class,method ="querySuccessByTime" )
    public List<BusinessUserBo> querySuccessByTime(String time,Integer userid);

    @SelectProvider(type = StatisticalSql.class,method ="queryDocumentaryByTime" )
    public List<BusinessUserBo> queryDocumentaryByTime(String time,Integer userid);

    @SelectProvider(type = StatisticalSql.class,method ="queryContractByTime" )
    public List<BusinessUserBo> queryContractByTime(String time,String username);

}
