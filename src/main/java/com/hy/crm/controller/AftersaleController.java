package com.hy.crm.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hy.crm.bo.lmy.AfterSaleUserBo;
import com.hy.crm.bo.lmy.ContractSaleBo;
import com.hy.crm.pojo.After;
import com.hy.crm.pojo.Aftersale;
import com.hy.crm.service.IAfterService;
import com.hy.crm.service.IAftersaleService;
import com.hy.crm.service.ICustomerService;
import com.hy.crm.service.IUserService;
import com.hy.crm.utils.MsgUtils;
import com.hy.crm.utils.MyMsgUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * <p>
 * 售后服务 前端控制器
 * </p>
 *
 * @author zzx
 * @since 2020-08-28
 */
@Controller
@RequestMapping("//aftersale")
public class AftersaleController {
    @Autowired
    private IAftersaleService aftersaleService;
    @Autowired
    private IAfterService afterService;
    @Autowired
    private ICustomerService customerService;
    @Autowired
    private IUserService userService;
    @GetMapping("/queryContractSaleByContractId.do")
    @ResponseBody
    public ContractSaleBo queryContractSaleByContractId(String contractid){
        return aftersaleService.queryContractSale(contractid);
    }

    @PostMapping("/upload.do")
    @ResponseBody
    public MyMsgUtils upload(@RequestParam("file") MultipartFile picture, HttpServletRequest request)throws IOException {
        //设置图片名称
        String pictureName = UUID.randomUUID().toString();
        //获取文件名s
        String fileName = picture.getOriginalFilename();
        //图片的后缀
        String suffix = fileName.substring(fileName.lastIndexOf("."));
        String path=pictureName+suffix;
        //获取整个web路径
        String webPath = request.getServletContext().getRealPath("/");
        File file=new File(webPath);
        webPath=file.getParentFile().toString();
        File parentPath = new File(webPath, "upload");
        //判断当前文件是否存在
        if (!parentPath.exists()) {
            parentPath.mkdirs();
        }
        File filePath = new File(parentPath, path);
        picture.transferTo(filePath);
        MyMsgUtils msgUtils=new MyMsgUtils();
        msgUtils.setCode(0);
        msgUtils.setMsg("");
        msgUtils.setData("/upload/"+path);
        return msgUtils;
    }
    @PostMapping("/addAfterSale.do")
    @ResponseBody
    public String addAfterSale(Aftersale aftersale){
        String theme=aftersale.getTheme();
        theme=customerService.getById(aftersale.getCustomerid()).getCustomername()+"-"+aftersale.getContractid()+"-"+theme;
        aftersale.setTheme(theme);
        aftersale.setRealstatus("处理中");
        Date date=new Date();
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Boolean b=aftersaleService.save(aftersale);
        if(b){
            After after=new After();
            QueryWrapper queryWrapper=new QueryWrapper<>();
            queryWrapper.eq("theme",aftersale.getTheme());
            after.setServiceid(aftersaleService.getOne(queryWrapper).getSaleid());
            after.setUserid(aftersale.getUserid());
            after.setDisposetime(dateFormat.format(date));
            after.setDisposecontent("添加售后服务");
            after.setStatus("处理中");
            Boolean bo=afterService.save(after);
            if(bo){
                return  "yes";
            }else {
                return "no";
            }
        }else {
            return "no";
        }
    }

    @RequestMapping("/queryAfterSale.do")
    @ResponseBody
    public MsgUtils queryAfterSale(Integer page,Integer limit, String classification, String key,String status){
        List<Aftersale> list=aftersaleService.queryAfterSale(classification,key,page,limit,status);
        MsgUtils msgUtils=new MsgUtils();
        msgUtils.setCode(0);
        msgUtils.setCount(aftersaleService.queryCount(status));
        msgUtils.setMsg("");
        msgUtils.setData(list);
        return msgUtils;
    }

    @GetMapping("/addAfterSaleOver.do")
    @ResponseBody
    public String addAfterSaleOver(Aftersale aftersale){
        String theme=aftersale.getTheme();
        theme=customerService.getById(aftersale.getCustomerid()).getCustomername()+"-"+aftersale.getContractid()+"-"+theme;
        aftersale.setTheme(theme);
        aftersale.setRealstatus("已结束");
        Date date=new Date();
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        aftersale.setOvertime(dateFormat.format(date));
        Boolean b=aftersaleService.save(aftersale);
        if(b){
            After after=new After();
            QueryWrapper queryWrapper=new QueryWrapper<>();
            queryWrapper.eq("theme",aftersale.getTheme());
            after.setServiceid(aftersaleService.getOne(queryWrapper).getSaleid());
            after.setUserid(aftersale.getUserid());
            after.setDisposetime(dateFormat.format(date));
            after.setDisposecontent("本次服务完成");
            after.setStatus("已结束");
            Boolean bo=afterService.save(after);
            if(bo){
                return  "yes";
            }else {
                return "no";
            }
        }else {
            return "no";
        }
    }
    @GetMapping("/queryAfterSaleUserBo.do")
    public String queryAfterSaleUserBo(Integer saleid, Model model){
        AfterSaleUserBo afterSaleUserBo=aftersaleService.queryAfterSaleUserBoByTheme(saleid);
        String str="【合同全称】:"+afterSaleUserBo.getCustomername()+"  【合同所属部门】:"+afterSaleUserBo.getDeptname()+"  【关联人员】:"
                +afterSaleUserBo.getAssociatedpersons()+"  【签约日期】:  "+afterSaleUserBo.getSigningdate()+"  【生效日期】："+afterSaleUserBo.getTakedate()
                +"  【合同状态】："+afterSaleUserBo.getTodaystate()+"  【服务期至】："+afterSaleUserBo.getServiceto();
        model.addAttribute("afterSale",afterSaleUserBo);
        model.addAttribute("info",str);
        return "/lmy/aftersale/aftersaleinfo.html";
    }

    @PostMapping("/updateStatusById.do")
    public String updateStatusByTheme(After after){
        after.setUserid(1001);//需要动态获取session的id
        after.setStatus("已结束");
        Date date=new Date();
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        after.setDisposetime(dateFormat.format(date));
        after.setDisposecontent("本次服务完成");
        boolean b=afterService.save(after);
        if(b){
            boolean bo=aftersaleService.updateAfterSaleStatus(after.getServiceid(),dateFormat.format(date));
            if(bo){
                return "/lmy/aftersale/aftersale.html";
            }else{
                return "no";
            }
        }else{
            return "no";
        }
    }

}
