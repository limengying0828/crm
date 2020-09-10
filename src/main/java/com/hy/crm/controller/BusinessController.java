package com.hy.crm.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hy.crm.bo.lmy.ExpectedMoneyBo;
import com.hy.crm.bo.ykz.BusinessBo;
import com.hy.crm.pojo.Business;
import com.hy.crm.pojo.Busprocess;
import com.hy.crm.pojo.Customer;
import com.hy.crm.pojo.User;
import com.hy.crm.service.IBusinessService;
import com.hy.crm.service.IBusprocessService;
import com.hy.crm.service.ICustomerService;
import com.hy.crm.yuutils.LayuiUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.util.Date;
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
@RequestMapping("/business")
public class BusinessController {
    @Autowired
    private IBusinessService iBusinessService;

    @Autowired
    private IBusprocessService iBusprocessService;

    @Autowired
    private ICustomerService iCustomerService;


    @GetMapping("/seletName.do")
    @ResponseBody
    public List<Business> seletName(){
       return iBusinessService.list();
    }

    /**
     * //主页面各种状态预计成交金额
     * @return
     */
    @GetMapping("/queryMoney.do")
    @ResponseBody
    public List<ExpectedMoneyBo> queryMoney(){
        return iBusinessService.queryMoney();

    }

    /**
     *查商机
     */
    @GetMapping("/businessQueryall.do")
    @ResponseBody
    public LayuiUtils businessQueryall(@RequestParam("page") Integer pg, @RequestParam("limit") Integer size, String businessname, String todaystate, String userId, String makemoney, String documentarytime, String forum, HttpSession session) {
        IPage<Business> page=new Page<>(pg,size);
        List<BusinessBo> list1=iBusinessService.businessQueryall(page,businessname,todaystate,userId,makemoney,documentarytime,forum);
        LayuiUtils layuiUtils=new LayuiUtils();
        layuiUtils.setCode(0);
        layuiUtils.setMsg("查询成功");
        layuiUtils.setCount(Integer.parseInt(String.valueOf(page.getTotal())));
        layuiUtils.setData(list1);
        return layuiUtils;
    }

    /**
     * 商机添加
     * @param business
     * @return
     */
    @GetMapping("/save.do")
    public String save(Business business){
        iBusinessService.save(business);
        QueryWrapper queryWrapper=new QueryWrapper();
        queryWrapper.eq("businessname",business.getBusinessname());
        List<Business> list=iBusinessService.list(queryWrapper);
        int businessid=0;
        int uid=0;
        for(Business c:list){
            businessid=c.getBusinessid();
            uid=c.getUserId();
        }
        Busprocess busprocess=new Busprocess();
        busprocess.setBusinessid(businessid);
        busprocess.setUserid(uid);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        busprocess.setDisposetime(df.format(new Date()));
        busprocess.setTodaystate("初期沟通");
        iBusprocessService.save(busprocess);
        return "redirect:/html/ykz/business.html";
    }

    /**
     * 根据id查商机信息
     * @param model
     * @param businessid
     * @return
     */
    @GetMapping("/queryall.do")
    public String queryall(Model model, int businessid){
        QueryWrapper queryWrapper=new QueryWrapper();
        queryWrapper.eq("businessid",businessid);
        Business business=iBusinessService.getOne(queryWrapper);

        QueryWrapper queryWrapper1=new QueryWrapper();
        queryWrapper1.eq("customerid",business.getCustomerid());
        Customer customer=iCustomerService.getOne(queryWrapper1);
        model.addAttribute("business",business);
        model.addAttribute("customer",customer);
        return "/ykz/businesscheck.html";
    }

}
