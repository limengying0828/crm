package com.hy.crm.controller;

import com.hy.crm.bo.pml.DocumentaryBo;
import com.hy.crm.bo.pml.DocumentaryBos;
import com.hy.crm.pojo.Documentary;
import com.hy.crm.pojo.User;
import com.hy.crm.service.IBusinessService;
import com.hy.crm.service.IDocumentaryService;
import com.hy.crm.utils.MsgUtils;
import com.hy.crm.utils.UtisMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * <p>
 * 跟单表 前端控制器
 * </p>
 *
 * @author zzx
 * @since 2020-08-28
 */
@Controller
@RequestMapping("//documentary")
public class DocumentaryController {
    @Autowired
    private IDocumentaryService iDocumentaryService;

    @Autowired
    private IBusinessService iBusinessService;

   /* *//**
     * 查询所有跟单
     * @param
     * @param
     * @return
     *//*
    @ResponseBody
    @GetMapping("/queryAll.do")
    public MsgUtils queryAll(String classification,String key,Integer page,Integer limit){
        List<DocumentaryBo> list =iDocumentaryService.queryAll(classification,key,page,limit);
        MsgUtils msgUtils=new MsgUtils();
        msgUtils.setCode(0);
        msgUtils.setMsg("查询成功");
        msgUtils.setCount(list.size());
        msgUtils.setData(list);
        return msgUtils;
    }
*/
    /**
     * 查询所有跟单
     * @param
     * @param
     * @return
     */
    @ResponseBody
    @GetMapping("/queryAllDoc.do")
    public MsgUtils queryAllDoc(String classification,String key,Integer page,Integer limit){
        List<DocumentaryBos> list =iDocumentaryService.queryAllDoc(classification,key,page,limit);
        MsgUtils msgUtils=new MsgUtils();
        msgUtils.setCode(0);
        msgUtils.setMsg("查询成功");
        msgUtils.setCount(list.size());
        msgUtils.setData(list);
        return msgUtils;
    }

    /**
     * 查询我的跟单
     * @param
     * @param
     * @return
     */
    @ResponseBody
    @GetMapping("/queryAllMyDoc.do")
    public MsgUtils queryAllMyDoc(String classification, String key, Integer page, Integer limit, HttpSession session){
        User us= (User) session.getAttribute("user");
        System.out.println("用户编号"+us.getUserid());
        List<DocumentaryBos> list =iDocumentaryService.queryAllMyDoc(classification,key,page,limit,us.getUserid());
        MsgUtils msgUtils=new MsgUtils();
        msgUtils.setCode(0);
        msgUtils.setMsg("查询成功");
        msgUtils.setCount(list.size());
        msgUtils.setData(list);
        return msgUtils;
    }

    /**
     * 添加时展示跟单
     * @return
     */
    @GetMapping("/select.do")
    @ResponseBody
    public List<DocumentaryBo> query(){
        return iDocumentaryService.select();
    }

    /**
     * 新增跟单表
     * @param documentary
     */
    @RequestMapping("/savaDocumentary.do")
    public String savaDocumentary(Documentary documentary,HttpSession session){
        User user= (User) session.getAttribute("user");
        documentary.setUserid(user.getUserid());
        iDocumentaryService.save(documentary);
        return "redirect:/html/pml/documentary/queryDocumentary.html";
    }

    /**
     * 根据跟单主题查询跟单信息
     * @param
     * @return
     */
    @RequestMapping("/queryByIdDoc.do")
    public String queryByIdDoc(Integer processid, Model model){
        List<DocumentaryBo> documentaryBo = iDocumentaryService.queryByIdDoc(processid);
       model.addAttribute("documentaryBo",documentaryBo);
       return "/html/pml/documentary/updateDocumentary.html";
    }

    @RequestMapping("/pictureUpload.do")
    @ResponseBody//响应
    public UtisMsg pictureUpload(@RequestParam("file") MultipartFile filename, HttpServletResponse response, HttpServletRequest request) throws IOException {
        //设置图片名称 不能重复
        String picName = UUID.randomUUID().toString();
        //获取文件名
        String oriName = filename.getOriginalFilename();
        //获取文件后缀
        String extName = oriName.substring(oriName.lastIndexOf("."));
        //获取到的是当前项目的绝对路径
        String filePath = request.getServletContext().getRealPath("/");
        File file = new File(filePath);
        //开始上传
        filePath = file.getParentFile().toString();

        File parentfile = new File(filePath + "\\upload\\" + picName + extName);
        System.out.println(parentfile);
        filename.transferTo(parentfile);
        UtisMsg utisMsg = new UtisMsg();
        utisMsg.setCode(0);
        utisMsg.setMsg("");
        utisMsg.setData("\\upload\\" + picName + extName);
        return utisMsg;
    }

    @RequestMapping("/updateDocumentary.do")
    public String updateDocumentary(Documentary documentaryBo,HttpSession session){
        User user= (User) session.getAttribute("user");
        documentaryBo.setUserid(user.getUserid());
        iDocumentaryService.save(documentaryBo);
        return "redirect:/html/pml/documentary/queryDocumentary.html";
    }
}
