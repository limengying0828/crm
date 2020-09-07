package com.hy.crm.controller;

import com.hy.crm.bo.lmy.MyStatisticalBo;
import com.hy.crm.service.impl.StatisticalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author: 李梦莹
 * @create: 2020/9/7 10:10
 * @Description:
 */
@Controller
@RequestMapping("//statistical")
public class StatisticalController {
    @Autowired
    private StatisticalService statisticalService;
    /**
     * 查询我的统计
     */
    @GetMapping("/queryMySta.do")
    @ResponseBody
    public List<MyStatisticalBo> queryMySta(){
        return statisticalService.queryMySta();
    }
}
