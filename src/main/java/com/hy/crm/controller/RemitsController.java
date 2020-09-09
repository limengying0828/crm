package com.hy.crm.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hy.crm.pojo.Remits;
import com.hy.crm.service.IRemitsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;

/**
 * <p>
 * 汇款额详情表 前端控制器
 * </p>
 *
 * @author zzx
 * @since 2020-08-28
 */
@Controller
@RequestMapping("//remits")
public class RemitsController {

    @Autowired
    private IRemitsService iRemitsService;

    @RequestMapping("/queryRemits.do")
    public String queryRemits(String contractid, Model model){
        QueryWrapper queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("contractid",contractid);
        Remits remits =iRemitsService.getOne(queryWrapper);
        model.addAttribute("remits",remits);
        return "/pml/remits/updateRemits.html";
    }
}
