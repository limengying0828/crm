package com.hy.crm.service.impl;

import com.hy.crm.bo.pml.ContractBo;
import com.hy.crm.pojo.Contract;
import com.hy.crm.mapper.ContractMapper;
import com.hy.crm.service.IContractService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 合同表 服务实现类
 * </p>
 *
 * @author zzx
 * @since 2020-08-28
 */
@Service
public class ContractServiceImpl extends ServiceImpl<ContractMapper, Contract> implements IContractService {

    @Autowired
    private ContractMapper contractMapper;

    @Override
    public List<ContractBo> queryContract(@Param("classification")String classification, @Param("key")String key, @Param("page") Integer page, @Param("limit") Integer limit) {
        return contractMapper.queryContract(classification, key,page,limit);
    }

    @Override
    public List<ContractBo> queryContractMy(String classification, String key, Integer page, Integer limit, String associatedpersons) {
        return contractMapper.queryContractMy(classification,key,page,limit,associatedpersons);
    }
}
