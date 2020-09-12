package com.hy.crm.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hy.crm.bo.pml.ContractBo;
import com.hy.crm.bo.pml.ContractBos;
import com.hy.crm.mapper.ContractMapper;
import com.hy.crm.mapper.MakeapplyMapper;
import com.hy.crm.mapper.RemitsMapper;
import com.hy.crm.pojo.Contract;
import com.hy.crm.pojo.Makeapply;
import com.hy.crm.pojo.Remits;
import com.hy.crm.service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    @Autowired
    private RemitsMapper remitsMapper;
    @Autowired
    private MakeapplyMapper makeapplyMapper;

    @Override
    public List<ContractBo> queryContract(@Param("classification")String classification, @Param("key")String key, @Param("page") Integer page, @Param("limit") Integer limit) {
        return contractMapper.queryContract(classification, key,page,limit);
    }

    /**
     * 查询全部合同
     * @param classification
     * @param key
     * @param page
     * @param limit
     * @return
     */
    @Override
    public List<ContractBos> queryContractCon(String classification, String key, Integer page, Integer limit) {
        List<Contract> list= contractMapper.queryContractCon(classification,key,page,limit);
        List<ContractBos> bosList=new ArrayList<>();
        for (Contract contract:list) {
            QueryWrapper queryWrapper=new QueryWrapper<>();
            queryWrapper.eq("contractid",contract.getContractid());
            Remits remits=remitsMapper.selectOne(queryWrapper);
            QueryWrapper wrapper=new QueryWrapper<>();
            wrapper.eq("contractid",contract.getContractid());
            Makeapply makeapply =makeapplyMapper.selectOne(wrapper);
            ContractBos contractBos=new ContractBos(contract,makeapply,remits);
            bosList.add(contractBos);
        }
        return bosList;
    }

    @Override
    public List<ContractBo> queryContractMy(String classification, String key, Integer page, Integer limit, String associatedpersons) {
        return contractMapper.queryContractMy(classification,key,page,limit,associatedpersons);
    }

    /**
     * 查询我的合同
     * @param classification
     * @param key
     * @param page
     * @param limit
     * @param associatedpersons
     * @return
     */
    @Override
    public List<ContractBos> queryContractMyCon(String classification, String key, Integer page, Integer limit, String associatedpersons) {
        List<Contract> list= contractMapper.queryContractMyCon(classification,key,page,limit,associatedpersons);
        List<ContractBos> bosList=new ArrayList<>();
        for (Contract contract:list) {
            QueryWrapper queryWrapper=new QueryWrapper<>();
            queryWrapper.eq("contractid",contract.getContractid());
            Remits remits=remitsMapper.selectOne(queryWrapper);
            QueryWrapper wrapper=new QueryWrapper<>();
            wrapper.eq("contractid",contract.getContractid());
            Makeapply makeapply =makeapplyMapper.selectOne(wrapper);
            ContractBos contractBos=new ContractBos(contract,makeapply,remits);
            bosList.add(contractBos);
        }
        return bosList;
    }
}
