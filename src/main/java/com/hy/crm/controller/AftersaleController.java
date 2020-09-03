package com.hy.crm.controller;

import com.hy.crm.bo.lmy.ContractSaleBo;
import com.hy.crm.pojo.Aftersale;
import com.hy.crm.service.IAftersaleService;
import com.hy.crm.service.ICustomerService;
import com.hy.crm.utils.MyMsgUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
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
    private ICustomerService customerService;
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
        Boolean b=aftersaleService.save(aftersale);
        if(b){
            return "yes";
        }else {
            return "no";
        }
    }

    @GetMapping("/queryAfterSale.do")
    @ResponseBody
    public void queryAfterSale(@RequestParam  Integer page,@RequestParam Integer limit,@RequestParam  String type,@RequestParam String key){

    }

}
