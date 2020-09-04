package com.hy.crm.bo.lmy;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author: 李梦莹
 * @create: 2020/9/3 15:53
 * @Description:
 */
@Data
public class AfterSaleProcessBo {
    @ApiModelProperty(value = "处理编号")
    private Integer afterid;

    @ApiModelProperty(value = "服务编号")
    private Integer serviceid;

    @ApiModelProperty(value = "处理人id")
    private Integer userid;

    @ApiModelProperty(value = "处理时间")
    private String disposetime;

    @ApiModelProperty(value = "处理内容（转服务人员处理，本次服务完成）")
    private String disposecontent;

    @ApiModelProperty(value = "处理状态")
    private String status;

    @ApiModelProperty(value = "主题")
    private String theme;

    @ApiModelProperty(value = "步骤")
    private String step;

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

}
