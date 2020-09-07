package com.hy.crm.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hy.crm.pojo.Customer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

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
   /* *
     * 根据客户名称查询客户信息
     * @return
     * RowBounds rowBounds*/
    @Select("select * from customer where customername = #{customername}")
    public Customer queryAllByName(String customername);
}
