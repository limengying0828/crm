package com.hy.crm.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hy.crm.pojo.Contract;
import com.hy.crm.service.IContractService;
import com.hy.crm.utils.MsgUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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

    /**
     * 查询
     * @param customerid
     * @return
     */
    @GetMapping("/queryContractByCustomer.do")
    @ResponseBody
    public List<Contract> queryContractByCustomer(Integer customerid){
        QueryWrapper wrapper=new QueryWrapper<>();
        wrapper.eq("customerid",customerid);
        return contractService.list(wrapper);
    }

    @GetMapping("/selectContract.do")
    @ResponseBody
    public MsgUtils selectContract(Integer page,Integer limit,Contract contract){

        QueryWrapper queryWrapper=new QueryWrapper<Contract>();
        if (!StringUtils.isEmpty(contract)){
            if (!StringUtils.isEmpty(contract.getContractname())){
                queryWrapper.eq("contractname",contract.getContractname());
            }
            if (!StringUtils.isEmpty(contract.getContractname())){
                queryWrapper.eq("contractid",contract.getContractid());
            }
            if (!StringUtils.isEmpty(contract.getContractname())){
                queryWrapper.eq("signingdate",contract.getSigningdate());
            }
        }
        Page<Contract> ipage=new Page<>(page,limit);
        Page<Contract> pages=contractService.page(ipage,queryWrapper);

        MsgUtils msgUtils=new MsgUtils();
        msgUtils.setCode(0);
        msgUtils.setMsg("查询成功");
        msgUtils.setCount((int)pages.getTotal());
        msgUtils.setData(pages.getRecords());
        return msgUtils;
    }

    /**
     * 查询所有合同信息
     * @return
     */
    @GetMapping("/queryAll.do")
    @ResponseBody
    public List<Contract> queryAll(){
        return contractService.list();
    }
}
