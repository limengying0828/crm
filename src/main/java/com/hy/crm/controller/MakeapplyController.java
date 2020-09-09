package com.hy.crm.controller;


import com.hy.crm.pojo.Makeapply;
import com.hy.crm.service.IMakeapplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;

/**
 * <p>
 * 开票申请表 前端控制器
 * </p>
 *
 * @author zzx
 * @since 2020-08-28
 */
@Controller
@RequestMapping("//makeapply")
public class MakeapplyController {

    @Autowired
    private IMakeapplyService iMakeapplyService;

    @PostMapping("/addMakeapply.do")
    public String addMakeapply(Makeapply makeapply){
        iMakeapplyService.save(makeapply);
        return "/pml/contract/queryContract.html";
    }

}
