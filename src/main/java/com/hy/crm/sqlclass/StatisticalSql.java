package com.hy.crm.sqlclass;

/**
 * @Author: 李梦莹
 * @create: 2020/9/2 19:36
 * @Description:
 */
public class StatisticalSql {
    //根据时间查询商机数
    public String queryMyStaBusiness(String time){
        StringBuffer buffer=new StringBuffer("select count(*) from business where 1=1 ");
        if(time.equals("本周")){
            buffer.append(" and YEARWEEK(date_format(addbusinesstime,'%Y-%m-%d'),-1) = YEARWEEK(date_format(NOW(),'%Y-%m-%d'))");
        }
        if(time.equals("上周")){
            buffer.append(" and YEARWEEK(date_format(addbusinesstime,'%Y-%m-%d'),1) = YEARWEEK(date_format(NOW(),'%Y-%m-%d'))");
        }
        if(time.equals("本月")){
            buffer.append(" and DATE_FORMAT(addbusinesstime, '%Y%m' ) = DATE_FORMAT( CURDATE( ) , '%Y%m' )");
        }
        if(time.equals("上月")){
            buffer.append(" and PERIOD_DIFF( date_format( now( ) , '%Y%m' ) , date_format(addbusinesstime, '%Y%m' ) ) =1");
        }
        if(time.equals("本季度")){
            buffer.append(" and QUARTER(addbusinesstime)=QUARTER(now()) and  year(addbusinesstime)=year(now())");
        }
        if(time.equals("上季度")){
            buffer.append(" and QUARTER(addbusinesstime)=QUARTER(DATE_SUB(now(),interval 1 QUARTER)) and  YEAR (addbusinesstime)=YEAR(DATE_SUB(now(),interval 1 QUARTER))");
        }
        if(time.equals("本年度")){
            buffer.append(" and YEAR(addbusinesstime)=YEAR(NOW());");
        }
        if(time.equals("上年度")){
            buffer.append(" and year(addbusinesstime)=year(date_sub(now(),interval 1 year))");
        }
        return buffer.toString();
    }
    //根据时间查询成交数
    public String querySuccessCount(String time){
        StringBuffer buffer=new StringBuffer("select count(*) from busprocess where 1=1 ");
        if(time.equals("本周")){
            buffer.append(" and todaystate='成交' and YEARWEEK(date_format(disposetime,'%Y-%m-%d'),-1) = YEARWEEK(date_format(NOW(),'%Y-%m-%d'))");
        }
        if(time.equals("上周")){
            buffer.append(" and todaystate='成交' and YEARWEEK(date_format(disposetime,'%Y-%m-%d'),1) = YEARWEEK(date_format(NOW(),'%Y-%m-%d'))");
        }
        if(time.equals("本月")){
            buffer.append(" and DATE_FORMAT(disposetime, '%Y%m' ) = DATE_FORMAT( CURDATE( ) , '%Y%m' ) and todaystate='成交'");
        }
        if(time.equals("上月")){
            buffer.append(" and PERIOD_DIFF( date_format( now( ) , '%Y%m' ) , date_format(disposetime, '%Y%m' ) ) =1 and todaystate='成交'");
        }
        if(time.equals("本季度")){
            buffer.append(" and QUARTER(disposetime)=QUARTER(now()) and  year(disposetime)=year(now()) and todaystate='成交'");
        }
        if(time.equals("上季度")){
            buffer.append(" and QUARTER(disposetime)=QUARTER(DATE_SUB(now(),interval 1 QUARTER)) and  YEAR (disposetime)=YEAR(DATE_SUB(now(),interval 1 QUARTER)) and todaystate='成交'");
        }
        if(time.equals("本年度")){
            buffer.append(" and YEAR(disposetime)=YEAR(NOW()) and todaystate='成交'");
        }
        if(time.equals("上年度")){
            buffer.append(" and year(disposetime)=year(date_sub(now(),interval 1 year)) and todaystate='成交'");
        }
        return buffer.toString();
    }
   //根据时间查询跟单数
    public String queryDocumentaryCount(String time){
        StringBuffer buffer=new StringBuffer("select count(*) from documentary where 1=1 ");
        if(time.equals("本周")){
            buffer.append(" and YEARWEEK(date_format(documentarytime,'%Y-%m-%d'),-1) = YEARWEEK(date_format(NOW(),'%Y-%m-%d'))");
        }
        if(time.equals("上周")){
            buffer.append(" and YEARWEEK(date_format(documentarytime,'%Y-%m-%d'),1) = YEARWEEK(date_format(NOW(),'%Y-%m-%d'))");
        }
        if(time.equals("本月")){
            buffer.append(" and DATE_FORMAT(documentarytime, '%Y%m' ) = DATE_FORMAT( CURDATE( ) , '%Y%m' )");
        }
        if(time.equals("上月")){
            buffer.append(" and PERIOD_DIFF( date_format( now( ) , '%Y%m' ) , date_format(documentarytime, '%Y%m' ) ) =1");
        }
        if(time.equals("本季度")){
            buffer.append(" and QUARTER(documentarytime)=QUARTER(now()) and  year(documentarytime)=year(now())");
        }
        if(time.equals("上季度")){
            buffer.append(" and QUARTER(documentarytime)=QUARTER(DATE_SUB(now(),interval 1 QUARTER)) and  YEAR (documentarytime)=YEAR(DATE_SUB(now(),interval 1 QUARTER))");
        }
        if(time.equals("本年度")){
            buffer.append(" and YEAR(documentarytime)=YEAR(NOW());");
        }
        if(time.equals("上年度")){
            buffer.append(" and year(documentarytime)=year(date_sub(now(),interval 1 year))");
        }
        return buffer.toString();
    }
}
