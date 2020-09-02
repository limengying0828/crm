package com.hy.crm.controller;


import com.hy.crm.pojo.Customer;
import com.hy.crm.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

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
@RequestMapping("//customer")
public class CustomerController {
    @Autowired
    private ICustomerService service;
    @GetMapping("/queryCustomer.do")
    @ResponseBody
    public List<Customer> queryCustomer(){
       return service.list();
    }
}
