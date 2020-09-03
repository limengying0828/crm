package com.hy.crm.controller;

import com.hy.crm.bo.pml.DocumentaryBo;
import com.hy.crm.pojo.Documentary;
import com.hy.crm.service.IBusinessService;
import com.hy.crm.service.IDocumentaryService;
import com.hy.crm.utils.MsgUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

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
    public MsgUtils queryAll(DocumentaryBo documentaryBo,Integer page,Integer limit){
        if (StringUtils.isEmpty(documentaryBo)){
            page=0;
        }
        if (!StringUtils.isEmpty(documentaryBo)){
            page=0;
            limit=10;
        }
        List<DocumentaryBo> list =iDocumentaryService.queryAll(documentaryBo,page,limit);
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
}
