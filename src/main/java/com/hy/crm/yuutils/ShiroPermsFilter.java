package com.hy.crm.yuutils;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authz.PermissionsAuthorizationFilter;
import org.apache.shiro.web.util.WebUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: 李梦莹
 * @create: 2020/9/12 10:37
 * @Description:
 */
public class ShiroPermsFilter extends PermissionsAuthorizationFilter {
    /**
     * shiro认证perms资源失败后回调方法
     * @param servletRequest
     * @param servletResponse
     * @return
     * @throws IOException
     */
    @Override
    protected boolean onAccessDenied(ServletRequest servletRequest, ServletResponse servletResponse) throws IOException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        //获取当前用户
        Subject subject = this.getSubject(httpServletRequest, httpServletResponse);
        //判断是否已经认证
        if (subject.getPrincipal() == null) {
            //没有认证则重定向到登录页面
            this.saveRequestAndRedirectToLogin(httpServletRequest, httpServletResponse);
        }else {//认证过了

            String requestedWith = httpServletRequest.getHeader("X-Requested-With");
            if (StringUtils.isNotEmpty(requestedWith) && requestedWith.equals("XMLHttpRequest")) { //如果是ajax返回指定格式数据
//           //是ajax请求
                httpServletResponse.setContentType("text/json;charset=UTF-8");//设置响应头
//                返回json 数据，告知无权限
                httpServletResponse.getWriter().write("{\"success\":false,\"message\":\"抱歉，你没有这个权限!\",\"errorCode\":-10001}");
            } else {//如果是普通请求进行重定向
                //不是ajax请求
                String unauthorizedUrl = this.getUnauthorizedUrl();
                if (StringUtils.isNotEmpty(unauthorizedUrl)) {
                    WebUtils.issueRedirect(httpServletRequest, httpServletResponse, unauthorizedUrl);
                } else {
                    WebUtils.toHttp(httpServletResponse).sendError(401);
                }
            }

        }
        return false;
    }
}
