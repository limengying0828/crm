package com.hy.crm.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hy.crm.bo.pml.ContractBo;
import com.hy.crm.pojo.Contract;
import com.hy.crm.pojo.User;
import com.hy.crm.service.IContractService;
import com.hy.crm.utils.MsgUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
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
        wrapper.eq("customername",customerid);
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

    @GetMapping("/selectContractMy.do")
    @ResponseBody
    public MsgUtils selectContractMy(Integer page, Integer limit, String classification, String key, HttpSession session){
        User use= (User) session.getAttribute("user");
        List<ContractBo> contractBoList=contractService.queryContractMy(classification,key,page,limit,use.getUsername());
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

    /**
     * 新增合同
     * @param contract
     * @return
     */
    @PostMapping("/addContract.do")
    public String addContract(Contract contract,HttpSession session){
        User user= (User) session.getAttribute("user");
        contract.setAssociatedpersons(user.getUsername());
        contractService.save(contract);
        return "/html/pml/contract/queryContract.html";
    }

    @RequestMapping("/updateContract.do")
    public String updateContract(String contractid, Model model){
        QueryWrapper queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("contractid",contractid);
        Contract contractList=contractService.getOne(queryWrapper);
        model.addAttribute("contractList",contractList);
        return "/pml/contract/updateContract.html";
    }

    @RequestMapping("/selectContractById.do")
    public String selectContractById(String contractid, Model model){
        QueryWrapper queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("contractid",contractid);
        Contract contractList=contractService.getOne(queryWrapper);
        model.addAttribute("contractList",contractList);
        return "/pml/makeapply/addmakeapply.html";
    }

    @PostMapping("/updateContractById.do")
    public String updateContractById(Contract  contract){
        contractService.updateById(contract);
        return "/pml/contract/queryContract.html";
    }
}
