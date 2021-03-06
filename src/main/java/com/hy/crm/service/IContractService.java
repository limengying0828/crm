package com.hy.crm.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hy.crm.bo.pml.ContractBo;
import com.hy.crm.bo.pml.ContractBos;
import com.hy.crm.pojo.Contract;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * <p>
 * 合同表 服务类
 * </p>
 *
 * @author zzx
 * @since 2020-08-28
 */
public interface IContractService extends IService<Contract> {

    public List<ContractBo> queryContract(@Param("classification")String classification, @Param("key")String key, @Param("page") Integer page, @Param("limit") Integer limit);
    //查询全部合同
    public List<ContractBos> queryContractCon(@Param("classification")String classification, @Param("key")String key, @Param("page") Integer page, @Param("limit") Integer limit);

    public List<ContractBo> queryContractMy(@Param("classification")String classification, @Param("key")String key, @Param("page") Integer page, @Param("limit") Integer limit,String associatedpersons);
    //查询我的合同
    public List<ContractBos> queryContractMyCon(@Param("classification")String classification, @Param("key")String key, @Param("page") Integer page, @Param("limit") Integer limit,String associatedpersons);


}
