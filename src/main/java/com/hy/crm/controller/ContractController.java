package com.hy.crm.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hy.crm.pojo.Contract;
import com.hy.crm.service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * <p>
 * 合同表 前端控制器
 * </p>
 *
 * @author zzx
 * @since 2020-08-28
 */
@Controller
@RequestMapping("//contract")
public class ContractController {
    @Autowired
    private IContractService contractService;
    @GetMapping("/queryContractByCustomer.do")
    @ResponseBody
    public List<Contract> queryContractByCustomer(Integer customerid){
        QueryWrapper wrapper=new QueryWrapper<>();
        wrapper.eq("customerid",customerid);
        return contractService.list(wrapper);
    }

}
