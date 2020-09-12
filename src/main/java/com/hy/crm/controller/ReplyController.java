package com.hy.crm.controller;


import com.hy.crm.pojo.Reply;
import com.hy.crm.pojo.User;
import com.hy.crm.service.IReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * <p>
 * 帖子回复表 前端控制器
 * </p>
 *
 * @author zzx
 * @since 2020-08-28
 */
@Controller
@RequestMapping("//reply")
public class ReplyController {
    @Autowired
    private IReplyService iReplyService;

    @RequestMapping("/addRrply.do")
    public String addRrply(Reply reply, HttpSession session){
        User user = (User) session.getAttribute("user");
        reply.setUserid(user.getUserid());
        Date date=new Date();
        reply.setReplytime(String.valueOf(date.getTime()));
        iReplyService.save(reply);
        return "/html/pml/invitation/queryinvitation.html";
    }

}
