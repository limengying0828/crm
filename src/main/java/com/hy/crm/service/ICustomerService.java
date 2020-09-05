package com.hy.crm.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hy.crm.bo.ykz.CbcaBo;
import com.hy.crm.pojo.Customer;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 客户表 服务类
 * </p>
 *
 * @author zzx
 * @since 2020-08-28
 */
public interface ICustomerService extends IService<Customer> {
    public List<CbcaBo> queryAll(IPage<Customer> page, String condition,String keyword);
}
