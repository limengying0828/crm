package com.hy.crm.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hy.crm.bo.pml.ContractBos;
import com.hy.crm.pojo.Contract;
import com.hy.crm.pojo.Makeapply;
import com.hy.crm.pojo.Remits;
import com.hy.crm.pojo.User;
import com.hy.crm.service.IContractService;
import com.hy.crm.service.IMakeapplyService;
import com.hy.crm.service.IRemitsService;
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
    @Autowired
    private IMakeapplyService iMakeapplyService;
    @Autowired
    private IRemitsService iRemitsService;

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

    @GetMapping("/queryContractCon.do")
    @ResponseBody
    public MsgUtils queryContractCon(Integer page, Integer limit, String classification, String key){
        List<ContractBos> contractBoList=contractService.queryContractCon(classification,key,page,limit);
        MsgUtils msgUtils=new MsgUtils();
        msgUtils.setCode(0);
        msgUtils.setMsg("查询成功");
        msgUtils.setCount(contractBoList.size());
        msgUtils.setData(contractBoList);
        return msgUtils;
    }

    @GetMapping("/queryContractMyCon.do")
    @ResponseBody
    public MsgUtils selectContractMy(Integer page, Integer limit, String classification, String key, HttpSession session){
        User use= (User) session.getAttribute("user");
        List<ContractBos> contractBoList=contractService.queryContractMyCon(classification,key,page,limit,use.getUsername());
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
        boolean b=contractService.save(contract);
        System.out.println("b"+b);
        if (b){
            System.out.println("添加开票===");
            Makeapply makeapply =new Makeapply();
            makeapply.setMakemoney(0.0f);
            makeapply.setUserid(user.getUserid());
            makeapply.setContractid(contract.getContractid());
            iMakeapplyService.save(makeapply);
            Remits remits=new Remits();
            remits.setIncomemoney(0.0f);
            remits.setUserid(user.getUserid());
            remits.setContractid(contract.getContractid());
            iRemitsService.save(remits);
        }
        return "redirect:/html/pml/contract/queryContract.html";
    }

    @RequestMapping("/updateContract.do")
    public String updateContract(String contractid, Model model){
        QueryWrapper queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("contractid",contractid);
        Contract contractList=contractService.getOne(queryWrapper);
        model.addAttribute("contractList",contractList);
        return "/html/pml/contract/updateContract.html";
    }

    @RequestMapping("/selectContractById.do")
    public String selectContractById(String contractid, Model model){
        QueryWrapper queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("contractid",contractid);
        Contract contractList=contractService.getOne(queryWrapper);
        model.addAttribute("contractList",contractList);
        return "/html/pml/makeapply/addmakeapply.html";
    }

    @PostMapping("/updateContractById.do")
    public String updateContractById(Contract  contract){
        contractService.updateById(contract);
        return "/html/pml/contract/queryContract.html";
    }
}
