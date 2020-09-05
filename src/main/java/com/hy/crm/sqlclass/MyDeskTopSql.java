package com.hy.crm.sqlclass;

/**
 * @Author: 李梦莹
 * @create: 2020/9/2 19:36
 * @Description:
 */
public class MyDeskTopSql {
     public String queryMoney(){
         return "SELECT bp.todaystate,SUM(b.makemoney) as sumMoney from business b,busprocess bp where b.businessid=bp.businessid GROUP BY bp.todaystate;";
     }

}
