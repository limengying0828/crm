package com.hy.crm.sqlclass;

import com.mysql.jdbc.StringUtils;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: 李梦莹
 * @create: 2020/9/2 19:36
 * @Description:
 */
public class AfterSaleSql {
    //联合查询用户、合同、用户表
    public String queryContractSaleByUserName(String contractid){
      return "select * from contract c,`user` u,contractprocess con where u.username=c.associatedpersons and con.contractid=c.contractid and c.contractid='"+contractid+"'";
    }

    public String queryAfterSaleProcessBo(@Param("classification")String classification, @Param("key")String key,@Param("page")Integer page, @Param("limit")Integer limit,@Param("status")String status){
        StringBuffer buffer=new StringBuffer("select * from aftersale a where 1=1 ");
        if (null==page){
            page=1;
        }
        if(!StringUtils.isNullOrEmpty(classification) && !StringUtils.isNullOrEmpty(key)){
            buffer.append(" and "+classification+" like '%"+key+"%'");
        }
        if(!StringUtils.isNullOrEmpty(status)&& status.equals("处理中")){
            buffer.append(" and a.realstatus='处理中'");
        }
        if(!StringUtils.isNullOrEmpty(status)&& status.equals("已结束")){
            buffer.append(" and a.realstatus='已结束'");
        }
        if(!StringUtils.isNullOrEmpty(status)&& status.equals("已撤除")){
            buffer.append(" and a.realstatus='已撤除'");
        }
        if(!StringUtils.isNullOrEmpty(status) && status.equals("本周")){
            buffer.append(" and DATE_SUB(CURDATE(), INTERVAL 7 DAY) <= a.begintime");
        }
        if(!StringUtils.isNullOrEmpty(status) && status.equals("上周")){
            buffer.append(" and YEARWEEK(date_format(a.begintime,'%Y-%m-%d'),1) = YEARWEEK(date_format(NOW(),'%Y-%m-%d'))");
        }
        if(!StringUtils.isNullOrEmpty(status)&&status.equals("本月")){
            buffer.append(" and DATE_FORMAT(a.begintime, '%Y%m' ) = DATE_FORMAT( CURDATE( ) , '%Y%m' )");
        }
        if(!StringUtils.isNullOrEmpty(status)&&status.equals("上月")){
            buffer.append(" and PERIOD_DIFF( date_format( now( ) , '%Y%m' ) , date_format( a.begintime, '%Y%m' ) ) =1");
        }
        if(!StringUtils.isNullOrEmpty(status)&&status.equals("本季度")){
            buffer.append(" and QUARTER(a.begintime)=QUARTER(now()) and  year(a.begintime)=year(now())");
        }
        if(!StringUtils.isNullOrEmpty(status)&&status.equals("上季度")){
            buffer.append(" and QUARTER(a.begintime)=QUARTER(DATE_SUB(now(),interval 1 QUARTER)) and  YEAR (a.begintime)=YEAR(DATE_SUB(now(),interval 1 QUARTER))");
        }
        buffer.append(" limit "+((page-1)*limit)+","+limit);
        return buffer.toString();
    }

    public String querySumCount(@Param("classification")String classification, @Param("key")String key,@Param("status")String status){
        StringBuffer buffer=new StringBuffer("select count(*) from aftersale a where 1=1  ");

        if(!StringUtils.isNullOrEmpty(classification) && !StringUtils.isNullOrEmpty(key)){
            buffer.append(" and "+classification+" like '%"+key+"%'");
        }
        if(!StringUtils.isNullOrEmpty(status)&& status.equals("处理中")){
            buffer.append(" and a.realstatus='处理中'");
        }
        if(!StringUtils.isNullOrEmpty(status)&& status.equals("已结束")){
            buffer.append(" and a.realstatus='已结束'");
        }
        if(!StringUtils.isNullOrEmpty(status)&& status.equals("已撤除")){
            buffer.append(" and a.realstatus='已撤除'");
        }
        if(!StringUtils.isNullOrEmpty(status)&&status.equals("本周")){
            buffer.append(" and DATE_SUB(CURDATE(), INTERVAL 7 DAY) <= a.begintime");
        }
        if(!StringUtils.isNullOrEmpty(status)&&status.equals("上周")){
            buffer.append(" and YEARWEEK(date_format(a.begintime,'%Y-%m-%d'),1) = YEARWEEK(date_format(NOW(),'%Y-%m-%d'))");
        }
        if(!StringUtils.isNullOrEmpty(status)&&status.equals("本月")){
            buffer.append(" and DATE_FORMAT( a.begintime, '%Y%m' ) = DATE_FORMAT( CURDATE( ) , '%Y%m' )");
        }
        if(!StringUtils.isNullOrEmpty(status)&&status.equals("上月")){
            buffer.append(" and PERIOD_DIFF( date_format( now( ) , '%Y%m' ) , date_format(a.begintime, '%Y%m' ) ) =1");
        }
        if(!StringUtils.isNullOrEmpty(status)&&status.equals("本季度")){
            buffer.append(" and QUARTER(a.begintime)=QUARTER(now()) and  year(a.begintime)=year(now())");
        }
        if(!StringUtils.isNullOrEmpty(status)&&status.equals("上季度")){
            buffer.append(" and QUARTER(a.begintime)=QUARTER(DATE_SUB(now(),interval 1 QUARTER)) and  YEAR (a.begintime)=YEAR(DATE_SUB(now(),interval 1 QUARTER))");
        }
        return buffer.toString();
    }

}
