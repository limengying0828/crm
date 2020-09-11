package com.hy.crm.bo.lmy;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author: 李梦莹
 * @create: 2020/9/4 15:44
 * @Description:
 */
@Data
public class AfterSaleUserBo {
    @ApiModelProperty(value = "服务编号")
    private Integer saleid;

    @ApiModelProperty(value = "主题")
    private String theme;

    @ApiModelProperty(value = "步骤")
    private String step;

    @ApiModelProperty(value = "责任人")
    private Integer userid;

    @ApiModelProperty(value = "参与人")
    private String participant;

    @ApiModelProperty(value = "客户编号")
    private Integer customerid;

    @ApiModelProperty(value = "合同编号")
    private String contractid;

    @ApiModelProperty(value = "对方联系人")
    private String contactperson;

    @ApiModelProperty(value = "固定长度")
    private String officephone;

    @ApiModelProperty(value = "移动电话")
    private String telephone;

    @ApiModelProperty(value = "邮件/QQ")
    private String email;

    @ApiModelProperty(value = "服务类型")
    private String typeservices;

    @ApiModelProperty(value = "服务方式")
    private String servicemode;

    @ApiModelProperty(value = "开始时间")
    private String begintime;

    @ApiModelProperty(value = "结束时间")
    private String overtime;

    @ApiModelProperty(value = "服务内容")
    private String servicescontent;

    @ApiModelProperty(value = "客户反馈")
    private String customerfeedback;

    @ApiModelProperty(value = "服务人员")
    private String servicespeople;

    @ApiModelProperty(value = "服务评分")
    private String servicesscore;

    @ApiModelProperty(value = "附件")
    private String attachment;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "部门")
    private String deptname;

    @ApiModelProperty(value = "角色")
    private String role;

    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "用户头像")
    private String image;

    @ApiModelProperty(value = "客户名称")
    private String customername;

    @ApiModelProperty(value = "合同名称（客户名+合同名）")
    private String contractname;

    @ApiModelProperty(value = "合同金额")
    private Float contractmoney;

    @ApiModelProperty(value = "汇款额")
    private Float remittancecount;

    @ApiModelProperty(value = "开票额")
    private Float makecount;

    @ApiModelProperty(value = "签约日期")
    private String signingdate;

    @ApiModelProperty(value = "生效日期")
    private String takedate;

    @ApiModelProperty(value = "服务期至")
    private String serviceto;

    @ApiModelProperty(value = "对方联系人")
    private String sidelinkman;

    @ApiModelProperty(value = "主要技术条款（【产品交付和时间】）")
    private String technicalterms;

    @ApiModelProperty(value = "主要商务条款（【收款方式和时间】）")
    private String businessterms;

    @ApiModelProperty(value = "关联人员")
    private String associatedpersons;

    @ApiModelProperty(value = "处理编号")
    @TableId(value = "conprocessid", type = IdType.AUTO)
    private Integer conprocessid;

    @ApiModelProperty(value = "处理时间")
    private String disposetime;

    @ApiModelProperty(value = "当前状态")
    private String todaystate;

    @ApiModelProperty(value = "真实状态")
    private String realstatus;

}
