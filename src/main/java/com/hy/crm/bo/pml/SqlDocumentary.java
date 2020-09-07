package com.hy.crm.bo.pml;

import org.springframework.data.repository.query.Param;

/**
 * @Author 潘梦丽
 * @create 2020/9/1
 */
public class SqlDocumentary {

    /**
     * 查询所有跟单信息
     */
    public String  queryAll(@Param("classification")String classification, @Param("key")String key, @Param("page")Integer page, @Param("limit") Integer limit){
       StringBuffer stringBuffer= new StringBuffer("select * from documentary d,user u where d.userid=u.userid  ");
        if (page==null){
            page=1;
        }
        if (null!=classification &&  !"".equals(classification) &&  null!=key  &&  !"".equals(key)){
            stringBuffer.append(" and "+classification+" like '%" + key + "%' ");
        }
        stringBuffer.append(" limit "+((page-1)*limit)+","+limit);
        return stringBuffer.toString();
    }

    /**
     * 查询所有合同信息
     * @param
     * @param page
     * @param limit
     * @return
     */
    public String queryContract(@Param("classification")String classification, @Param("key")String key, @Param("page")Integer page, @Param("limit") Integer limit){
        StringBuffer stringBuffer=new StringBuffer("select * from contract c,makeapply m where c.contractid=m.contractid ");
        if (page==null){
            page=1;
        }
            if (null!=classification &&  !"".equals(classification) && null!=key && !"".equals(key)){
                stringBuffer.append(" and "+classification+" like '%" + key + "%' ");
            }
        stringBuffer.append(" limit "+((page-1)*limit)+","+limit);
        return stringBuffer.toString();
    }
}
