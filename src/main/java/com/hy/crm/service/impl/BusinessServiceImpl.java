package com.hy.crm.service.impl;

import com.hy.crm.bo.lmy.ExpectedMoneyBo;
import com.hy.crm.pojo.Business;
import com.hy.crm.mapper.BusinessMapper;
import com.hy.crm.service.IBusinessService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 商机表 服务实现类
 * </p>
 *
 * @author zzx
 * @since 2020-08-28
 */
@Service
public class BusinessServiceImpl extends ServiceImpl<BusinessMapper, Business> implements IBusinessService {
    @Autowired
    private BusinessMapper businessMapper;

    /**
     * //桌面各种状态预计成交金额
     * @return
     */
    @Override
    public List<ExpectedMoneyBo> queryMoney() {
        return businessMapper.queryMoney();
    }
}
