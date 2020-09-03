package com.hy.crm.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hy.crm.bo.lmy.ContractSaleBo;
import com.hy.crm.mapper.AftersaleMapper;
import com.hy.crm.pojo.Aftersale;
import com.hy.crm.service.IAftersaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 售后服务 服务实现类
 * </p>
 *
 * @author zzx
 * @since 2020-08-28
 */
@Service
public class AftersaleServiceImpl extends ServiceImpl<AftersaleMapper, Aftersale> implements IAftersaleService {
    @Autowired
    private AftersaleMapper aftersaleMapper;
    @Override
    public ContractSaleBo queryContractSale(String contractid) {
        return aftersaleMapper.queryContractSaleBo(contractid);
    }
}
