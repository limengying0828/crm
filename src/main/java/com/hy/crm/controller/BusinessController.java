package com.hy.crm.controller;


import com.hy.crm.pojo.Business;
import com.hy.crm.service.IBusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * <p>
 * 商机表 前端控制器
 * </p>
 *
 * @author zzx
 * @since 2020-08-28
 */
@Controller
@RequestMapping("//business")
public class BusinessController {
    @Autowired
    private IBusinessService iBusinessService;

    @GetMapping("/seletName.do")
    @ResponseBody
    public List<Business> seletName(){
       return iBusinessService.list();
    }

}
