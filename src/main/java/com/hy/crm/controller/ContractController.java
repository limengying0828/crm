package com.hy.crm.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hy.crm.bo.pml.ContractBo;
import com.hy.crm.pojo.Contract;
import com.hy.crm.service.IContractService;
import com.hy.crm.utils.MsgUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
    public MsgUtils selectContract(Integer page, Integer limit, String classification, String key){
        List<ContractBo> contractBoList=contractService.queryContract(classification,key,page,limit);
        MsgUtils msgUtils=new MsgUtils();
        msgUtils.setCode(0);
        msgUtils.setMsg("查询成功");
        msgUtils.setCount(contractBoList.size());
        msgUtils.setData(contractBoList);
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
