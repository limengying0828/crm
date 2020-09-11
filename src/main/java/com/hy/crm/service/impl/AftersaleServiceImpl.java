package com.hy.crm.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hy.crm.bo.lmy.AfterSaleUserBo;
import com.hy.crm.bo.lmy.ContractSaleBo;
import com.hy.crm.mapper.AftersaleMapper;
import com.hy.crm.pojo.Aftersale;
import com.hy.crm.service.IAftersaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<Aftersale> queryAfterSale(String classification, String key, Integer page, Integer limit, String status) {
       return aftersaleMapper.queryAfterSaleProcessBo(classification,key,page,limit,status);
    }

    @Override
    public Integer queryCount(String classification, String key, Integer page, Integer limit, String status) {
        return aftersaleMapper.queryCount(classification,key,page,limit,status);
    }

    @Override
    public AfterSaleUserBo queryAfterSaleUserBoByTheme(Integer saleid) {
        return  aftersaleMapper.queryAfterSaleUserBoByTheme(saleid);
    }

    @Override
    public Boolean updateAfterSaleStatus(Integer serviceid,String overtime) {
        return  aftersaleMapper.updateAfterSaleStatus(serviceid,overtime);
    }
}
