package com.hy.crm.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hy.crm.bo.pml.DocumentaryBo;
import com.hy.crm.bo.pml.SqlDocumentary;
import com.hy.crm.pojo.Documentary;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

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
     * @param documentaryBo
     * @return
     */
    @SelectProvider(type = SqlDocumentary.class,method = "queryAll")
    public List<DocumentaryBo> queryAll(DocumentaryBo documentaryBo, Integer m,Integer n);

    @Select("select * from documentary d,user u where d.userid=u.userid")
    public List<DocumentaryBo> query();
}
