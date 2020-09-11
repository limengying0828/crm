package com.hy.crm.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hy.crm.pojo.User;
import com.hy.crm.service.IUserService;
import com.hy.crm.yuutils.LayuiUtilsPrice;
import com.hy.crm.yuutils.VerifyCode;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author zzx
 * @since 2020-08-28
 */
@Controller
@RequestMapping("//user")
public class UserController {

    @Autowired
    private IUserService iUserService;

    /**
     * 登录
     * @param username
     * @param password
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @PostMapping("userNamequery1.do")
    public String userNamequery1(String username, String password, Integer rememberme, HttpServletRequest request, HttpServletResponse response, Model model, HttpSession session) throws ServletException, IOException {
        String imageText = request.getParameter("image");
        // 图片的验证码
        String text = (String) request.getSession().getAttribute("text");
        if (!text.equalsIgnoreCase(imageText)) {
            model.addAttribute("msg","验证码输入错误!");
            return "/ykz/error.html";
        }else {
            UsernamePasswordToken usernamePasswordToken=new UsernamePasswordToken(username,password);
            //开启记住密码
            if(rememberme !=null && rememberme==1){
                usernamePasswordToken.setRememberMe(true);
                System.out.println("已开启记住密码！");
            }
            Subject sub= SecurityUtils.getSubject();
            int count=0;
            try {
                sub.login(usernamePasswordToken);
            } catch (UnknownAccountException e) {
                count++;
                model.addAttribute("msg","账号不存在！");
            } catch (IncorrectCredentialsException e1) {
                count++;
                model.addAttribute("msg","密码异常！");
            }
            if(count>0){
                return "/ykz/error.html";
            }
            QueryWrapper queryWrapper=new QueryWrapper();
            queryWrapper.eq("username",username);
            User user=iUserService.getOne(queryWrapper);
            sub.getSession().setAttribute("user",user);
            return "/host.html";

        }
    }

    /**
     * 图片
     * @param multipartFile
     * @param request
     * @return
     * @throws IOException
     */
    @PostMapping("userPicture.do")
    @ResponseBody
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "系统错误"),
            @ApiResponse(code = 200, message = "0 成功", response = LayuiUtilsPrice.class) })
    @ApiOperation(httpMethod = "post", value = "上传图片")//swagger 当前接口注解
    public LayuiUtilsPrice saveprice(@ApiParam(required = true,name = "file",value = "图片")@RequestParam("file") MultipartFile multipartFile, HttpServletRequest request) throws IOException {
        String picName = UUID.randomUUID().toString().replaceAll("-","");
        String uuid=picName.substring(18);
        String oriName = multipartFile.getOriginalFilename();
        String extName = oriName.substring(oriName.lastIndexOf("."));
        String rpath = request.getServletContext().getRealPath("/");
        rpath = rpath.substring(0, rpath.lastIndexOf("\\"));
        rpath = rpath.substring(0, rpath.lastIndexOf("\\"));
        File file = new File(rpath+"/upload");
        if(!file.exists()){
            file.mkdirs();
        }
        multipartFile.transferTo(new File(file +"/"+ uuid + extName));
        System.out.println("图片===================="+file +"/"+ uuid + extName);
        String str=uuid + extName;
        LayuiUtilsPrice layuiUtilsPrice=new LayuiUtilsPrice();
        layuiUtilsPrice.setFileName(str);
        return layuiUtilsPrice;
    }

    /**
     * 注册
     * @param username
     * @param password
     * @param image
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    @PostMapping("/registerUser.do")
    public String registerUser(String username,String password,String image,String deptname, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user =new User();
        user.setUsername(username);
        if(iUserService.selusername(user)!=null){
            request.setAttribute("msg", "账号已存在!");
            return "/ykz/register.html";
        }else{
            String imageText = request.getParameter("verimage");
            // 图片的验证码
            String text = (String) request.getSession().getAttribute("text");
            if (!text.equalsIgnoreCase(imageText)) {
                request.setAttribute("msg", "验证码输入错误!");
                return "/ykz/error1.html";
            }else {
                User user1=new User();
                user1.setUsername(username);
                user1.setPassword(password);
                user1.setImage(image);
                user1.setDeptname(deptname);
                iUserService.save(user1);
                return "/ykz/login.html";
            }
        }
    }


    @GetMapping("/queryname.do")
    @ResponseBody
    public User queryname(String username){
        QueryWrapper queryWrapper=new QueryWrapper();
        queryWrapper.eq("username",username);
        return iUserService.getOne(queryWrapper);
    }

    /**
     * 验证码
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping("/VerifyCodeServlet.do")
    public void VerifyCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //创建对象
        VerifyCode vc = new VerifyCode();
        //获取图片对象
        BufferedImage bi = vc.getImage();
        //获得图片的文本内容
        String text = vc.getText();
        // 将系统生成的文本内容保存到session中
        request.getSession().setAttribute("text", text);
        //向浏览器输出图片
        vc.output(bi, response.getOutputStream());
    }

}
