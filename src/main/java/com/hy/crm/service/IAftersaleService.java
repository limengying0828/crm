package com.hy.crm.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hy.crm.bo.lmy.AfterSaleUserBo;
import com.hy.crm.bo.lmy.ContractSaleBo;
import com.hy.crm.pojo.Aftersale;

import java.util.List;

/**
 * <p>
 * 售后服务 服务类
 * </p>
 *
 * @author zzx
 * @since 2020-08-28
 */
public interface IAftersaleService extends IService<Aftersale> {
     ContractSaleBo queryContractSale(String contractid);
     List<Aftersale> queryAfterSale(String classification, String key, Integer page, Integer limit, String status);
     Integer queryCount(String classification, String key,String status);
     AfterSaleUserBo queryAfterSaleUserBoByTheme(Integer saleid);
     Boolean updateAfterSaleStatus(Integer serviceid,String overtime);
}
