package com.hy.crm.sqlclass;

/**
 * @Author: 李梦莹
 * @create: 2020/9/2 19:36
 * @Description:
 */
public class AfterSaleSql {
    public String queryContractSaleByUserName(String contractid){
      return "select * from contract c,`user` u,contractprocess con where u.username=c.associatedpersons and con.contractid=c.contractid and c.contractid='"+contractid+"'";
    }

}
