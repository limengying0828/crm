package com.hy.crm.bo.pml;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hy.crm.pojo.Invitation;
import org.springframework.data.repository.query.Param;

/**
 * @Author 潘梦丽
 * @create 2020/9/1
 */
public class SqlDocumentary {


    /**
     * 查询所有跟单信息
     */
    public String  queryAllDoc(@Param("classification")String classification, @Param("key")String key, @Param("page")Integer page, @Param("limit") Integer limit){
        StringBuffer stringBuffer= new StringBuffer("select * from documentary where 1=1  ");
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
     * 查询我的跟单
     */
    public String  queryAllMyDoc(@Param("classification")String classification, @Param("key")String key, @Param("page")Integer page, @Param("limit") Integer limit,@Param("userid") Integer userid){
        StringBuffer stringBuffer= new StringBuffer("select * from documentary  where 1=1  and userid="+userid);
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
     * 查询我的跟单
     */
    public String  queryAllMy(@Param("classification")String classification, @Param("key")String key, @Param("page")Integer page, @Param("limit") Integer limit,@Param("userid") Integer userid){
       System.out.println("sql语句");
        StringBuffer stringBuffer= new StringBuffer("select * from documentary d,user u where d.userid=u.userid  and d.userid="+userid);
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


    /**
     * 查询所有合同信息
     * @param
     * @param page
     * @param limit
     * @return
     */
    public String queryContractCon(@Param("classification")String classification, @Param("key")String key, @Param("page")Integer page, @Param("limit") Integer limit){
        StringBuffer stringBuffer=new StringBuffer("select * from contract  where 1=1");
        if (page==null){
            page=1;
        }
        if (null!=classification &&  !"".equals(classification) && null!=key && !"".equals(key)){
            stringBuffer.append(" and "+classification+" like '%" + key + "%' ");
        }
        stringBuffer.append(" limit "+((page-1)*limit)+","+limit);
        return stringBuffer.toString();
    }


    /**
     * 查询我的合同信息
     * @param
     * @param page
     * @param limit
     * @return
     */
    public String queryContractMyCon(@Param("classification")String classification, @Param("key")String key, @Param("page")Integer page, @Param("limit") Integer limit,@Param("associatedpersons")String associatedpersons){
        StringBuffer stringBuffer=new StringBuffer("select * from contract  where 1=1  and associatedpersons="+"'"+associatedpersons+"'" );
        if (page==null){
            page=1;
        }
        if (null!=classification &&  !"".equals(classification) && null!=key && !"".equals(key)){
            stringBuffer.append(" and "+classification+" like '%" + key + "%' ");
        }
        stringBuffer.append(" limit "+((page-1)*limit)+","+limit);
        return stringBuffer.toString();
    }

    /**
     * 查询我的合同信息
     * @param
     * @param page
     * @param limit
     * @return
     */
    public String queryContractMy(@Param("classification")String classification, @Param("key")String key, @Param("page")Integer page, @Param("limit") Integer limit,@Param("associatedpersons")String associatedpersons){
        StringBuffer stringBuffer=new StringBuffer("select * from contract c,makeapply m where c.contractid=m.contractid  and associatedpersons="+"'"+associatedpersons+"'" );
        if (page==null){
            page=1;
        }
        if (null!=classification &&  !"".equals(classification) && null!=key && !"".equals(key)){
            stringBuffer.append(" and "+classification+" like '%" + key + "%' ");
        }
        stringBuffer.append(" limit "+((page-1)*limit)+","+limit);
        return stringBuffer.toString();
    }


    /**
     * 查询全部讨论帖子
     * @param classification
     * @param key
     * @param page
     * @param
     * @return
     */
    public String queryInvitation(@Param("page") IPage<Invitation> page ,@Param("classification")String classification, @Param("key")String key){
        StringBuffer stringBuffer=new StringBuffer("select * from invitation where 1=1 ");
        if (null!=classification &&  !"".equals(classification) && null!=key && !"".equals(key)){
            stringBuffer.append(" and "+classification+" like '%" + key + "%' ");
        }
        return stringBuffer.toString();
    }
}
