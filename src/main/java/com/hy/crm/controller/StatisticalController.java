package com.hy.crm.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hy.crm.bo.lmy.MyStatisticalBo;
import com.hy.crm.service.impl.StatisticalService;
import com.hy.crm.utils.MsgUtils;
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

    @GetMapping("/queryFunnel.do")
    @ResponseBody
    public MsgUtils queryFunnel()
    {
        return statisticalService.queryFunnel("");
    }

    @GetMapping("/queryFunnelYear.do")
    @ResponseBody
    public MsgUtils queryFunnelYear()
    {
        return statisticalService.queryFunnel("本年度");
    }

    @GetMapping("/queryFunnelLastYear.do")
    @ResponseBody
    public MsgUtils queryFunneLastlYear()
    {
        return statisticalService.queryFunnel("上年度");
    }

    @GetMapping("/queryFunnelQuarter.do")
    @ResponseBody
    public MsgUtils queryFunnelQuarter()
    {
        return statisticalService.queryFunnel("本季度");
    }

    @GetMapping("/queryFunnelLastQuarter.do")
    @ResponseBody
    public MsgUtils queryFunnelLastQuarter()
    {
        return statisticalService.queryFunnel("本季度");
    }

    @GetMapping("/queryTrade.do")
    @ResponseBody
    public MsgUtils queryTrade()
    {
        return statisticalService.queryTrade();
    }

    @GetMapping("/queryOrigin.do")
    @ResponseBody
    public MsgUtils queryOrigin()
    {
        return statisticalService.queryBusinessByOrigin();
    }

    @GetMapping("/queryBusinessByTime.do")
    @ResponseBody
    public MsgUtils queryMyStaWeek(String time,Integer page,Integer limit){
        Page page1=new Page<>(page,limit);
        return statisticalService.queryBusinessByTime(time,page1);
    }

    @GetMapping("/queryBusinessByMonth.do")
    @ResponseBody
    public MsgUtils queryBusinessByMonth(String time,Integer page,Integer limit){
        Page page1=new Page<>(page,limit);
        return statisticalService.queryBusinessByMonth(time,page1);
    }

    @GetMapping("/queryBusinessByQuarter.do")
    @ResponseBody
    public MsgUtils queryBusinessByQuarter(String time,Integer page,Integer limit){
        Page page1=new Page<>(page,limit);
        return statisticalService.queryBusinessByQuarter(time,page1);
    }

    @GetMapping("/queryBusinessByYear.do")
    @ResponseBody
    public MsgUtils queryBusinessByYear(String time,Integer page,Integer limit){
        Page page1=new Page<>(page,limit);
        return statisticalService.queryBusinessByYear(time,page1);
    }

}
