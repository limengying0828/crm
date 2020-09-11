package com.hy.crm.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hy.crm.bo.pml.InvitationBo;
import com.hy.crm.bo.pml.InvitationBos;
import com.hy.crm.pojo.Invitation;
import com.hy.crm.pojo.User;
import com.hy.crm.service.IInvitationService;
import com.hy.crm.utils.MsgUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 帖子讨论表 前端控制器
 * </p>
 *
 * @author zzx
 * @since 2020-08-28
 */
@Controller
@RequestMapping("//invitation")
public class InvitationController {
    @Autowired
    private IInvitationService iInvitationService;

    @PostMapping("/addInvitation.do")
    public String addInvitation(Invitation invitation, HttpSession session){
        Date date=new Date();
        invitation.setReleasetime(String.valueOf(date.getTime()));
        User user = (User) session.getAttribute("user");
        invitation.setUserid(user.getUserid());
        iInvitationService.save(invitation);
        return "/html/host.html";
    }

    @RequestMapping("/queryInvitation.do")
    @ResponseBody
    public MsgUtils queryInvitation(Integer page, Integer limit, String classification, String key){
        Page page1=new Page<>(page,limit);
        List<InvitationBo>  invitationBoList=iInvitationService.queryInvitation(page1,classification,key);
        MsgUtils msgUtils=new MsgUtils();
        msgUtils.setCode(0);
        msgUtils.setMsg("查询成功");
        msgUtils.setCount(invitationBoList.size());
        msgUtils.setData(invitationBoList);
        return msgUtils;
    }

    @RequestMapping("/selectInvitationById.do")
    public String selectInvitationById(Integer invitationid, Model model){
        InvitationBos invitationBos=iInvitationService.queryInvitationById(iInvitationService.getById(invitationid));
        System.out.println("controller层："+invitationBos);
        model.addAttribute("invitationBos",invitationBos);
        return "/pml/invitation/lookInvitation.html";
    }

}
