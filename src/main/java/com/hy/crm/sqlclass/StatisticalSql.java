package com.hy.crm.sqlclass;

/**
 * @Author: 李梦莹
 * @create: 2020/9/2 19:36
 * @Description:
 */
public class StatisticalSql {
    //根据时间查询商机数
    public String queryMyStaBusiness(String time){
        StringBuffer buffer=new StringBuffer("select count(*)  from business where 1=1 ");
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

    //根据时间查询合同数
    public String queryContractCount(String time){
        StringBuffer buffer=new StringBuffer("select count(*) from contract where 1=1 ");
        if(time.equals("本周")){
            buffer.append(" and YEARWEEK(date_format(signingdate,'%Y-%m-%d'),-1) = YEARWEEK(date_format(NOW(),'%Y-%m-%d'))");
        }
        if(time.equals("上周")){
            buffer.append(" and YEARWEEK(date_format(signingdate,'%Y-%m-%d'),1) = YEARWEEK(date_format(NOW(),'%Y-%m-%d'))");
        }
        if(time.equals("本月")){
            buffer.append(" and DATE_FORMAT(signingdate, '%Y%m' ) = DATE_FORMAT( CURDATE( ) , '%Y%m' )");
        }
        if(time.equals("上月")){
            buffer.append(" and PERIOD_DIFF( date_format( now( ) , '%Y%m' ) , date_format(signingdate, '%Y%m' ) ) =1");
        }
        if(time.equals("本季度")){
            buffer.append(" and QUARTER(signingdate)=QUARTER(now()) and  year(signingdate)=year(now())");
        }
        if(time.equals("上季度")){
            buffer.append(" and QUARTER(signingdate)=QUARTER(DATE_SUB(now(),interval 1 QUARTER)) and  YEAR (signingdate)=YEAR(DATE_SUB(now(),interval 1 QUARTER))");
        }
        if(time.equals("本年度")){
            buffer.append(" and YEAR(signingdate)=YEAR(NOW());");
        }
        if(time.equals("上年度")){
            buffer.append(" and year(signingdate)=year(date_sub(now(),interval 1 year))");
        }
        return buffer.toString();
    }

    public String queryFunnel(String status,String time){
        StringBuffer buffer=new StringBuffer("select count(1) as count,sum(b.makemoney) as money from business b,busprocess bp where b.businessid=bp.businessid");
        if(status.equals("初期沟通")){
            buffer.append(" and bp.todaystate='初期沟通'");
        }
        if(status.equals("方案和报价")){
            buffer.append(" and bp.todaystate='方案和报价'");
        }
        if(status.equals("竞争或投标")){
            buffer.append(" and bp.todaystate='竞争或投标'");
        }
        if(status.equals("商务谈判")){
            buffer.append(" and bp.todaystate='商务谈判'");
        }
        if(status.equals("成交")){
            buffer.append(" and bp.todaystate='成交'");
        }
        if(time.equals("本年度")){
            buffer.append(" and YEAR(bp.disposetime)=YEAR(NOW())");
        }
        if(time.equals("上年度")){
            buffer.append(" and year(bp.disposetime)=year(date_sub(now(),interval 1 year))");
        }

        if(time.equals("本季度")){
            buffer.append(" and QUARTER(bp.disposetime)=QUARTER(now()) and  year(bp.disposetime)=year(now())");
        }
        if(time.equals("上季度")){
            buffer.append(" and QUARTER(bp.disposetime)=QUARTER(DATE_SUB(now(),interval 1 QUARTER)) and  YEAR (bp.disposetime)=YEAR(DATE_SUB(now(),interval 1 QUARTER))");
        }
        return buffer.toString();
    }

    public String queryBusinessByTrade(){
       return "select industry as trade,count(*) as count,sum(b.makemoney) as money from customer c,business b where c.customerid=b.customerid  GROUP BY industry;\n";
    }

    //查询商机数（用户与商机关联）
    public String queryBusinessByTime(String time,Integer userid){
        StringBuffer buffer=new StringBuffer("select  *  from business b,`user` u where 1=1 ");
        if(time.equals("本周")){
            buffer.append("  and YEARWEEK(date_format(addbusinesstime,'%Y-%m-%d'),-1) = YEARWEEK(date_format(NOW(),'%Y-%m-%d')) and u.userid=b.userid and b.userid="+userid);
        }
        if(time.equals("上周")){
            buffer.append("  and YEARWEEK(date_format(addbusinesstime,'%Y-%m-%d'),1) = YEARWEEK(date_format(NOW(),'%Y-%m-%d')) and u.userid=b.userid and b.userid="+userid);
        }
        if(time.equals("本月")){
            buffer.append(" and DATE_FORMAT(addbusinesstime, '%Y%m' ) = DATE_FORMAT( CURDATE( ) , '%Y%m' ) and u.userid=b.userid and b.userid="+userid);
        }
        if(time.equals("上月")){
            buffer.append(" and PERIOD_DIFF( date_format( now( ) , '%Y%m' ) , date_format(addbusinesstime, '%Y%m' ) ) =1  and u.userid=b.userid and b.userid="+userid);
        }
        if(time.equals("本季度")){
            buffer.append(" and QUARTER(addbusinesstime)=QUARTER(now()) and  year(addbusinesstime)=year(now())  and u.userid=b.userid and b.userid="+userid);
        }
        if(time.equals("上季度")){
            buffer.append(" and QUARTER(addbusinesstime)=QUARTER(DATE_SUB(now(),interval 1 QUARTER)) and  YEAR (addbusinesstime)=YEAR(DATE_SUB(now(),interval 1 QUARTER))  and u.userid=b.userid and b.userid="+userid);
        }
        if(time.equals("本年度")){
            buffer.append(" and YEAR(addbusinesstime)=YEAR(NOW())  and u.userid=b.userid and b.userid="+userid);
        }
        if(time.equals("上年度")){
            buffer.append(" and year(addbusinesstime)=year(date_sub(now(),interval 1 year))  and u.userid=b.userid and b.userid="+userid);
        }
        return buffer.toString();
    }

    //查询成交数（用户与商机关联）
    public String querySuccessByTime(String time,Integer userid){
        StringBuffer buffer=new StringBuffer("select *  from busprocess b,user u where 1=1 ");
        if(time.equals("本周")){
            buffer.append(" and todaystate='成交' and YEARWEEK(date_format(disposetime,'%Y-%m-%d'),-1) = YEARWEEK(date_format(NOW(),'%Y-%m-%d')) and u.userid=b.userid and b.userid="+userid);
        }
        if(time.equals("上周")){
            buffer.append(" and todaystate='成交' and YEARWEEK(date_format(disposetime,'%Y-%m-%d'),1) = YEARWEEK(date_format(NOW(),'%Y-%m-%d')) and u.userid=b.userid and b.userid="+userid);
        }
        if(time.equals("本月")){
            buffer.append(" and DATE_FORMAT(disposetime, '%Y%m' ) = DATE_FORMAT( CURDATE( ) , '%Y%m' ) and todaystate='成交' and u.userid=b.userid and b.userid="+userid);
        }
        if(time.equals("上月")){
            buffer.append(" and PERIOD_DIFF( date_format( now( ) , '%Y%m' ) , date_format(disposetime, '%Y%m' ) ) =1 and todaystate='成交' and u.userid=b.userid and b.userid="+userid);
        }
        if(time.equals("本季度")){
            buffer.append(" and QUARTER(disposetime)=QUARTER(now()) and  year(disposetime)=year(now()) and todaystate='成交' and u.userid=b.userid and b.userid="+userid);
        }
        if(time.equals("上季度")){
            buffer.append(" and QUARTER(disposetime)=QUARTER(DATE_SUB(now(),interval 1 QUARTER)) and  YEAR (disposetime)=YEAR(DATE_SUB(now(),interval 1 QUARTER)) and todaystate='成交' and u.userid=b.userid and b.userid="+userid);
        }
        if(time.equals("本年度")){
            buffer.append(" and YEAR(disposetime)=YEAR(NOW()) and todaystate='成交' and u.userid=b.userid and b.userid="+userid);
        }
        if(time.equals("上年度")){
            buffer.append(" and year(disposetime)=year(date_sub(now(),interval 1 year)) and todaystate='成交' and u.userid=b.userid and b.userid="+userid);
        }
        return buffer.toString();
    }

    //查询跟单数（用户与商机关联）
    public String queryDocumentaryByTime(String time,Integer userid){
        StringBuffer buffer=new StringBuffer("select * from documentary d,user u where 1=1 ");
        if(time.equals("本周")){
            buffer.append(" and YEARWEEK(date_format(documentarytime,'%Y-%m-%d'),-1) = YEARWEEK(date_format(NOW(),'%Y-%m-%d')) and u.userid=d.userid and d.userid="+userid);
        }
        if(time.equals("上周")){
            buffer.append(" and YEARWEEK(date_format(documentarytime,'%Y-%m-%d'),1) = YEARWEEK(date_format(NOW(),'%Y-%m-%d')) and u.userid=d.userid and d.userid="+userid);
        }
        if(time.equals("本月")){
            buffer.append(" and DATE_FORMAT(documentarytime, '%Y%m' ) = DATE_FORMAT( CURDATE( ) , '%Y%m' ) and u.userid=d.userid and d.userid="+userid);
        }
        if(time.equals("上月")){
            buffer.append(" and PERIOD_DIFF( date_format( now( ) , '%Y%m' ) , date_format(documentarytime, '%Y%m' ) ) =1 and u.userid=d.userid and d.userid="+userid);
        }
        if(time.equals("本季度")){
            buffer.append(" and QUARTER(documentarytime)=QUARTER(now()) and  year(documentarytime)=year(now()) and u.userid=d.userid and d.userid="+userid);
        }
        if(time.equals("上季度")){
            buffer.append(" and QUARTER(documentarytime)=QUARTER(DATE_SUB(now(),interval 1 QUARTER)) and  YEAR (documentarytime)=YEAR(DATE_SUB(now(),interval 1 QUARTER)) and u.userid=d.userid and d.userid="+userid);
        }
        if(time.equals("本年度")){
            buffer.append(" and YEAR(documentarytime)=YEAR(NOW()) and u.userid=d.userid and d.userid="+userid);
        }
        if(time.equals("上年度")){
            buffer.append(" and year(documentarytime)=year(date_sub(now(),interval 1 year)) and u.userid=d.userid and d.userid="+userid);
        }
        return buffer.toString();
    }

    //查询合同数（用户与商机关联）
    public String queryContractByTime(String time,String username){
        StringBuffer buffer=new StringBuffer("select * from contract c,user u where 1=1 ");
        if(time.equals("本周")){
            buffer.append(" and YEARWEEK(date_format(signingdate,'%Y-%m-%d'),-1) = YEARWEEK(date_format(NOW(),'%Y-%m-%d')) and u.username=c.associatedpersons and c.associatedpersons='"+username+"'");
        }
        if(time.equals("上周")){
            buffer.append(" and YEARWEEK(date_format(signingdate,'%Y-%m-%d'),1) = YEARWEEK(date_format(NOW(),'%Y-%m-%d')) and u.username=c.associatedpersons and c.associatedpersons='"+username+"'");
        }
        if(time.equals("本月")){
            buffer.append(" and DATE_FORMAT(signingdate, '%Y%m' ) = DATE_FORMAT( CURDATE( ) , '%Y%m' ) and u.username=c.associatedpersons and c.associatedpersons='"+username+"'");
        }
        if(time.equals("上月")){
            buffer.append(" and PERIOD_DIFF( date_format( now( ) , '%Y%m' ) , date_format(signingdate, '%Y%m' ) ) =1 and u.username=c.associatedpersons and c.associatedpersons='"+username+"'");
        }
        if(time.equals("本季度")){
            buffer.append(" and QUARTER(signingdate)=QUARTER(now()) and  year(signingdate)=year(now()) and u.username=c.associatedpersons and c.associatedpersons='"+username+"'");
        }
        if(time.equals("上季度")){
            buffer.append(" and QUARTER(signingdate)=QUARTER(DATE_SUB(now(),interval 1 QUARTER)) and  YEAR (signingdate)=YEAR(DATE_SUB(now(),interval 1 QUARTER)) and u.username=c.associatedpersons and c.associatedpersons='"+username+"'");
        }
        if(time.equals("本年度")){
            buffer.append(" and YEAR(signingdate)=YEAR(NOW()) and u.username=c.associatedpersons and c.associatedpersons='"+username+"'");
        }
        if(time.equals("上年度")){
            buffer.append(" and year(signingdate)=year(date_sub(now(),interval 1 year)) and u.username=c.associatedpersons and c.associatedpersons='"+username+"'");
        }
        return buffer.toString();
    }

}
