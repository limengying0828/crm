package com.hy.crm.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hy.crm.bo.ykz.CbcaBo;
import com.hy.crm.pojo.Customer;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hy.crm.yuutils.SqlDynamic;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 客户表 Mapper 接口
 * </p>
 *
 * @author zzx
 * @since 2020-08-28
 */
@Mapper
@Repository
public interface CustomerMapper extends BaseMapper<Customer> {
    /**
     * 查询所有+多条件查询
     * @return
     * RowBounds rowBounds
     */
    /*@Select("select * from customer")
    public List<Customer> queryAll(IPage<Customer> page);*/
}
