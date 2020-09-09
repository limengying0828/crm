package com.hy.crm.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hy.crm.bo.ykz.BusinessBo;
import com.hy.crm.bo.ykz.CbcaBo;
import com.hy.crm.pojo.Business;
import com.hy.crm.pojo.Customer;
import com.hy.crm.pojo.Finance;
import com.hy.crm.service.ICustomerService;
import com.hy.crm.service.IFinanceService;
import com.hy.crm.yuutils.LayuiUtils;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 客户表 前端控制器
 * </p>
 *
 * @author zzx
 * @since 2020-08-28
 */
@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private ICustomerService service;

    @Autowired
    private IFinanceService iFinanceService;

    @Autowired
    private ICustomerService iCustomerService;



    @GetMapping("/queryCustomer.do")
    @ResponseBody
    public List<Customer> queryCustomer(){
       return service.list();
    }

    @GetMapping("/queryCustomerById.do")
    @ResponseBody
    public Customer queryCustomerById(Integer customerid) {
        return service.getById(customerid);
    }

    /**
     * 添加
     * @param customer
     * @param bankaccount
     * @param accountname
     * @param accountbank
     * @param bankurl
     * @param dutyparagraph
     * @param phone
     * @return
     */
    @PostMapping("/save.do")
    public String save(Customer customer,String bankaccount,String accountname,String accountbank,String bankurl,String dutyparagraph,String phone){
        service.save(customer);
        QueryWrapper queryWrapper=new QueryWrapper();
        queryWrapper.eq("customername",customer.getCustomername());
        List<Customer> list=service.list(queryWrapper);
        int customerid=0;
        for(Customer c:list){
            customerid=c.getCustomerid();
        }
        Finance finance=new Finance();
        finance.setCustomerid(customerid);
        finance.setBankaccount(bankaccount);
        finance.setAccountname(accountname);
        finance.setAccountbank(accountbank);
        finance.setBankurl(bankurl);
        finance.setDutyparagraph(dutyparagraph);
        finance.setPhone(phone);
        iFinanceService.save(finance);
        return "redirect:/html/ykz/customer.html";
    }

    /**
     * 查询所有客户信息
     * @param
     * @return
     */
    @GetMapping(value = "/customerAll.do")//url映射   @Cacheable(value = "emp", key = "'empall'")缓存
    @ResponseBody
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "系统错误"),
            @ApiResponse(code = 200, message = "0 成功", response = LayuiUtils.class) })
    @ApiOperation(httpMethod = "GET", value = "查询所有客户信息")//swagger 当前接口注解
    public LayuiUtils find(@RequestParam("page") Integer pg, @RequestParam("limit") Integer size, String condition,String keyword) {
        IPage<Customer> page=new Page<>(pg,size);
        List<CbcaBo> list1=iCustomerService.queryAll(page,condition,keyword);
        LayuiUtils layuiUtils=new LayuiUtils();
        layuiUtils.setCode(0);
        layuiUtils.setMsg("查询成功");
        layuiUtils.setCount(Integer.parseInt(String.valueOf(page.getTotal())));
        layuiUtils.setData(list1);
        return layuiUtils;
    }


    //根据客户id查询所有
    @GetMapping("/queryall.do")
    public String queryall(Model model,int customerid){
        QueryWrapper queryWrapper=new QueryWrapper();
        queryWrapper.eq("customerid",customerid);
        Customer customer=iCustomerService.getOne(queryWrapper);
        Finance finance=iFinanceService.getOne(queryWrapper);
        model.addAttribute("customer",customer);
        model.addAttribute("finance",finance);
        return "/ykz/customerupdate.html";
    }


    /**
     * 修改
     * @param customer
     * @param bankaccount
     * @param accountname
     * @param accountbank
     * @param bankurl
     * @param dutyparagraph
     * @param phone
     * @return
     */
    @PostMapping("/update.do")
    public String update(Customer customer,int financeId,String bankaccount,String accountname,String accountbank,String bankurl,String dutyparagraph,String phone){
        service.updateById(customer);
        QueryWrapper queryWrapper=new QueryWrapper();
        queryWrapper.eq("customername",customer.getCustomername());
        List<Customer> list=service.list(queryWrapper);
        int customerid=0;
        for(Customer c:list){
            customerid=c.getCustomerid();
        }
        System.out.println("customerid==="+customerid);
        Finance finance=new Finance();
        finance.setFinanceId(financeId);
        finance.setCustomerid(customerid);
        finance.setBankaccount(bankaccount);
        finance.setAccountname(accountname);
        finance.setAccountbank(accountbank);
        finance.setBankurl(bankurl);
        finance.setDutyparagraph(dutyparagraph);
        finance.setPhone(phone);
        iFinanceService.updateById(finance);
        return "redirect:/html/ykz/customer.html";
    }

    /**
     * 删除
     * @param customerid
     * @param financeId
     * @return
     */
    @GetMapping("/custDelete.do")
    public String custDelete(int customerid,int financeId){
        System.out.println(customerid+"========="+financeId);
        iCustomerService.removeById(customerid);
        iFinanceService.removeById(financeId);
        return "redirect:/html/ykz/customer.html";
    }

    /**
     *查商机
     */
    @GetMapping("/businessQueryall.do")
    @ResponseBody
    public LayuiUtils businessQueryall(String businessname,String todaystate,String userId,String makemoney,String documentarytime,String forum) {
        List<BusinessBo> list1=iCustomerService.businessQueryall(businessname,todaystate,userId,makemoney,documentarytime,forum);
        LayuiUtils layuiUtils=new LayuiUtils();
        layuiUtils.setCode(0);
        layuiUtils.setMsg("查询成功");
        layuiUtils.setCount(list1.size());
        layuiUtils.setData(list1);
        return layuiUtils;
    }


    /**
     * 根据客户名称查询客户信息
     * @param customername
     * @return
     */
    @GetMapping("/queryAllByName.do")
    @ResponseBody
    public Customer queryAllByName(String customername){
       return iCustomerService.queryAllByName(customername);
    }

}
