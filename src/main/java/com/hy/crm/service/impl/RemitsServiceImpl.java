package com.hy.crm.service.impl;

import com.hy.crm.pojo.Remits;
import com.hy.crm.mapper.RemitsMapper;
import com.hy.crm.service.IRemitsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 汇款额详情表 服务实现类
 * </p>
 *
 * @author zzx
 * @since 2020-08-28
 */
@Service
public class RemitsServiceImpl extends ServiceImpl<RemitsMapper, Remits> implements IRemitsService {

    @Autowired
    private RemitsMapper remitsMapper;

    @Override
    public Remits queryAll(String contractid) {
       return remitsMapper.queryAll(contractid);
    }
}
