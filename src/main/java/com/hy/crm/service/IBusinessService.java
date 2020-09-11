package com.hy.crm.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hy.crm.bo.lmy.ExpectedMoneyBo;
import com.hy.crm.bo.ykz.BusinessBo;
import com.hy.crm.pojo.Business;

import java.util.List;

/**
 * <p>
 * 商机表 服务类
 * </p>
 *
 * @author zzx
 * @since 2020-08-28
 */
public interface IBusinessService extends IService<Business> {
    //主页面各种状态预计成交金额
    public List<ExpectedMoneyBo> queryMoney();

    public List<BusinessBo> businessQueryall(IPage<Business> page, String businessname, String todaystate, String userId, String makemoney, String overdate, String post,String status);
}
