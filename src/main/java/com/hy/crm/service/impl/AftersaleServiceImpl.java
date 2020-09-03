package com.hy.crm.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hy.crm.bo.lmy.ContractSaleBo;
import com.hy.crm.mapper.AftersaleMapper;
import com.hy.crm.pojo.Aftersale;
import com.hy.crm.service.IAftersaleService;
import com.mysql.jdbc.StringUtils;
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
    public List<Aftersale> queryAfterSale(String type,String key, Integer page, Integer limit) {
        Page pages=new Page<>(page,limit);
        IPage iPage=null;
        if(StringUtils.isNullOrEmpty(key) || StringUtils.isNullOrEmpty(type)){
            iPage=aftersaleMapper.selectPage(pages,null);
        }else {
            QueryWrapper queryWrapper=new QueryWrapper<>();
            queryWrapper.eq(type,key);
            iPage=aftersaleMapper.selectPage(pages,queryWrapper);
        }
        return iPage.getRecords();
    }
}
