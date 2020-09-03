package com.hy.crm.controller;


import com.hy.crm.bo.lmy.ContractSaleBo;
import com.hy.crm.service.IAftersaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>
 * 售后服务 前端控制器
 * </p>
 *
 * @author zzx
 * @since 2020-08-28
 */
@Controller
@RequestMapping("//aftersale")
public class AftersaleController {
    @Autowired
    private IAftersaleService aftersaleService;
    @GetMapping("/queryContractSaleByContractId.do")
    @ResponseBody
    public ContractSaleBo queryContractSaleByContractId(String contractid){
        return aftersaleService.queryContractSale(contractid);
    }

}
