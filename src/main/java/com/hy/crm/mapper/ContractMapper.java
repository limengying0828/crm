package com.hy.crm.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hy.crm.bo.pml.ContractBo;
import com.hy.crm.bo.pml.SqlDocumentary;
import com.hy.crm.pojo.Contract;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * <p>
 * 合同表 Mapper 接口
 * </p>
 *
 * @author zzx
 * @since 2020-08-28
 */
public interface ContractMapper extends BaseMapper<Contract> {

    /**
     * 查询所有合同信息
     * @param
     * @param page
     * @param limit
     * @return
     */
    @SelectProvider(type = SqlDocumentary.class,method = "queryContract")
    public List<ContractBo> queryContract(@Param("classification")String classification, @Param("key")String key, @Param("page") Integer page, @Param("limit") Integer limit);

    @SelectProvider(type = SqlDocumentary.class,method = "queryContractMy")
    public List<ContractBo> queryContractMy(@Param("classification")String classification, @Param("key")String key, @Param("page") Integer page, @Param("limit") Integer limit,@Param("associatedpersons")String associatedpersons);

    /**
     * 查询全部合同
     * @param classification
     * @param key
     * @param page
     * @param limit
     * @return
     */
    @SelectProvider(type = SqlDocumentary.class,method = "queryContractCon")
    public List<Contract> queryContractCon(@Param("classification")String classification, @Param("key")String key, @Param("page") Integer page, @Param("limit") Integer limit);

    /**
     * 查询我的合同
     * @param classification
     * @param key
     * @param page
     * @param limit
     * @param associatedpersons
     * @return
     */
    @SelectProvider(type = SqlDocumentary.class,method = "queryContractMyCon")
    public List<Contract> queryContractMyCon(@Param("classification")String classification, @Param("key")String key, @Param("page") Integer page, @Param("limit") Integer limit,@Param("associatedpersons")String associatedpersons);

}
