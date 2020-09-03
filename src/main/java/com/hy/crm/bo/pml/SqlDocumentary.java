package com.hy.crm.bo.pml;

import org.springframework.util.StringUtils;

/**
 * @Author 潘梦丽
 * @create 2020/9/1
 */
public class SqlDocumentary {

    /**
     * 查询所有跟单
     */
    public String  queryAll(DocumentaryBo documentaryBo, Integer m,Integer n){
       StringBuffer stringBuffer= new StringBuffer("select * from documentary d,user u where d.userid=u.userid  ");
       if (StringUtils.isEmpty(documentaryBo)){
           stringBuffer.append(" limit " + m + " , " + n);
       }
        if (!StringUtils.isEmpty(documentaryBo)){
            if(!StringUtils.isEmpty(documentaryBo.getDocumentarytime())){
                stringBuffer.append(" and d.documentarytime like '%"+documentaryBo.getDocumentarytime()+"%'");
            }
            if (!StringUtils.isEmpty(documentaryBo.getTheme())){
                System.out.println(documentaryBo.getTheme());
                stringBuffer.append(" and d.theme like '%"+documentaryBo.getTheme()+"%'");
            }
            if (!StringUtils.isEmpty(documentaryBo.getUsername())){
                stringBuffer.append(" and u.username like '%"+documentaryBo.getUsername()+"%'");
            }
            stringBuffer.append(" limit " + m + " , " + n);
        }
        return stringBuffer.toString();
    }
}
