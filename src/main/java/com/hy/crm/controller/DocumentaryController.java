package com.hy.crm.controller;

import com.hy.crm.bo.pml.DocumentaryBo;
import com.hy.crm.pojo.Documentary;
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

    /**
     * 查询所有跟单
     * @param
     * @param
     * @return
     */
    @ResponseBody
    @RequestMapping("/queryAll.do")
    public MsgUtils queryAll(DocumentaryBo documentaryBo){
        List<DocumentaryBo> list =iDocumentaryService.queryAll(documentaryBo);
        MsgUtils msgUtils=new MsgUtils();
        msgUtils.setCode(0);
        msgUtils.setMsg("查询成功");
        msgUtils.setCount(list.size()-1);
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
    public String savaDocumentary(Documentary documentary){
        iDocumentaryService.save(documentary);
        return "redirect:/html/pml/documentary/queryDocumentary.html";
    }

    /**
     * 根据跟单主题查询跟单信息
     * @param theme
     * @return
     */
    @RequestMapping("/selectTheme.do")
    public String selectTheme(String theme,Integer documentaryid, Model model){
       List<DocumentaryBo> documentaryBo = iDocumentaryService.selectTheme(theme);
       model.addAttribute("documentaryBo",documentaryBo);
       return "/pml/documentary/updateDocumentary.html";
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
    public String updateDocumentary(Documentary documentaryBo){
        iDocumentaryService.updateById(documentaryBo);
        return "redirect:/html/pml/documentary/queryDocumentary.html";
    }
}
