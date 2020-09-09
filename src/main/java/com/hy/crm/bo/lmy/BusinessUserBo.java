package com.hy.crm.bo.lmy;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author: 李梦莹
 * @create: 2020/9/8 18:29
 * @Description:
 */
@Data
public class BusinessUserBo {
    @ApiModelProperty(value = "商机编号")
    private Integer businessid;

    @ApiModelProperty(value = "客户编号")
    private Integer customerid;

    @ApiModelProperty(value = "商机名称")
    private String businessname;

    @ApiModelProperty(value = "客户来源")
    private String customersource;

    @ApiModelProperty(value = "预计成交金额")
    private Float makemoney;

    @ApiModelProperty(value = "预计结单日期")
    private String overdate;

    @ApiModelProperty(value = "联系人")
    private String contact;

    @ApiModelProperty(value = "职务")
    private String post;

    @ApiModelProperty(value = "固定电话")
    private String officephone;

    @ApiModelProperty(value = "移动电话")
    private String telephone;

    @ApiModelProperty(value = "邮件/QQ")
    private String email;

    @ApiModelProperty(value = "主要业务需求")
    private String businessdemand;

    @ApiModelProperty(value = "相关附件")
    private String attachment;

    @TableField("userId")
    private Integer userId;

    @ApiModelProperty(value = "商机参与人")
    private String participate;

    @ApiModelProperty(value = "商机关注人")
    private String focuspeople;

    @ApiModelProperty(value = "最后跟单时间")
    private String lastdocumentary;

    @ApiModelProperty(value = "合同优先级")
    private Integer contractpriority;

    @ApiModelProperty(value = "商机添加时间")
    private String addbusinesstime;

    @ApiModelProperty(value = "用户编号")
    @TableId(value = "userid", type = IdType.AUTO)
    private Integer userid;

    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "部门")
    private String deptname;

    @ApiModelProperty(value = "角色")
    private String role;

    @ApiModelProperty(value = "用户头像")
    private String image;

    @ApiModelProperty(value = "本周商机数")
    private Integer businessWeekCount;

    @ApiModelProperty(value = "上周商机数")
    private Integer businessLastWeekCount;

    @ApiModelProperty(value = "本周成交数")
    private Integer successWeekCount;

    @ApiModelProperty(value = "上周成交数")
    private Integer successLastWeekCount;

    @ApiModelProperty(value = "本周跟单数")
    private Integer documentaryWeekCount;

    @ApiModelProperty(value = "上周跟单数")
    private Integer documentaryLastWeekCount;

    @ApiModelProperty(value = "本周合同数")
    private Integer contractWeekCount;

    @ApiModelProperty(value = "上周合同数")
    private Integer contractLastWeekCount;

    @ApiModelProperty(value = "数量")
    private Integer count;
}

