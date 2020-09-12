package com.hy.crm.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hy.crm.bo.pml.DocumentaryBo;
import com.hy.crm.bo.pml.SqlDocumentary;
import com.hy.crm.pojo.Documentary;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * <p>
 * 跟单表 Mapper 接口
 * </p>
 *
 * @author zzx
 * @since 2020-08-28
 */
public interface DocumentaryMapper extends BaseMapper<Documentary> {

    /**
     * 查询全部跟单
     * @param
     * @return
     *//*
    @SelectProvider(type = SqlDocumentary.class,method = "queryAll")
    public List<DocumentaryBo> queryAll(@Param("classification")String classification, @Param("key")String key, @Param("page")Integer page, @Param("limit") Integer limit);
*/

    @SelectProvider(type = SqlDocumentary.class,method = "queryAllDoc")
    public List<Documentary> queryAllDoc(@Param("classification")String classification, @Param("key")String key, @Param("page")Integer page, @Param("limit") Integer limit);


    @Select("select * from documentary d,user u where d.userid=u.userid and d.processid=#{processid}")
    public List<DocumentaryBo> queryByIdDoc(Integer processid);

    @Select("select * from documentary d,user u where d.theme =#{theme} and d.userid=u.userid")
    public List<DocumentaryBo> selectTheme(String theme);

    @Select("select * from documentary d,user u where d.theme =#{theme} and d.userid=u.userid")
    public DocumentaryBo selectUpdate(String theme);

    @SelectProvider(type = SqlDocumentary.class,method = "queryAllMy")
    public List<DocumentaryBo> queryAllMy(@Param("classification")String classification, @Param("key")String key, @Param("page")Integer page, @Param("limit") Integer limit,@Param("userid") Integer userid);



    @SelectProvider(type = SqlDocumentary.class,method = "queryAllMyDoc")
    public List<Documentary> queryAllMyDoc(@Param("classification")String classification, @Param("key")String key, @Param("page")Integer page, @Param("limit") Integer limit, @Param("userid") Integer userid);

}
