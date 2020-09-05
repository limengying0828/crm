package com.hy.crm.yuutils;

import com.hy.crm.bo.ykz.CbcaBo;
import org.apache.ibatis.annotations.Param;

/**
 * @author yukangze
 * @version 1.0
 * @description
 * @date 2020-09-02 20:14
 */
public class SqlDynamic {
    public String select(@Param("condition")String condition,@Param("keyword")String keyword){
        StringBuffer sql = new StringBuffer("select * from customer where 1=1");
        if(condition != null && condition != ""){
            if(keyword != null && keyword != ""){
                if(condition=="1002"){
                    sql.append(" and customername='"+keyword+"' ");
                }
                if(condition=="1003"){
                    sql.append(" and customersource='"+keyword+"' ");
                }
                if(condition=="1004"){
                    sql.append(" and city='"+keyword+"' ");
                }
            }
        }
        return sql.toString();
    }
}
