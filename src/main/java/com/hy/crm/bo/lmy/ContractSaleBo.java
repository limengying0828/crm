package com.hy.crm.bo.lmy;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author: 李梦莹
 * @create: 2020/9/2 19:20
 * @Description:
 */
@Data
public class ContractSaleBo implements Serializable {
    @ApiModelProperty(value = "合同编号")
    private String contractid;

    @ApiModelProperty(value = "客户编号")
    private Integer customerid;

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

    @ApiModelProperty(value = "对方联系人")
    private String officephone;

    @ApiModelProperty(value = "移动电话")
    private String telephone;

    @ApiModelProperty(value = "邮件/QQ")
    private String email;

    @ApiModelProperty(value = "主要技术条款（【产品交付和时间】）")
    private String technicalterms;

    @ApiModelProperty(value = "主要商务条款（【收款方式和时间】）")
    private String businessterms;

    @ApiModelProperty(value = "相关附件")
    private String attachment;

    @ApiModelProperty(value = "关联人员")
    private String associatedpersons;

    @ApiModelProperty(value = "客户名称")
    private String customername;

    @ApiModelProperty(value = "拼音")
    private String spell;

    @ApiModelProperty(value = "客户分类")
    private String customerclass;

    @ApiModelProperty(value = "客户来源")
    private String customersource;

    @ApiModelProperty(value = "所属行业")
    private String industry;

    @ApiModelProperty(value = "客户网址")
    private String customerurl;

    @ApiModelProperty(value = "国家/地区")
    private String state;

    @ApiModelProperty(value = "所在城市")
    private String city;

    @ApiModelProperty(value = "详细地址")
    private String address;

    @ApiModelProperty(value = "邮政编码")
    private String postalcode;

    @ApiModelProperty(value = "传真")
    private String fax;

    @ApiModelProperty(value = "联系人")
    private String linkman;

    @ApiModelProperty(value = "客户部门")
    private String department;

    @ApiModelProperty(value = "职务")
    private String post;

    @ApiModelProperty(value = "法人代表")
    private String corporate;

    @ApiModelProperty(value = "注册资本")
    private String registered;

    @ApiModelProperty(value = "附加说明")
    private String additional;

    @ApiModelProperty(value = "商机数")
    private String numberbusiness;

    @ApiModelProperty(value = "合同数")
    private String numbercontract;

    @ApiModelProperty(value = "售后服务")
    @TableField("numberafterSales")
    private String numberafterSales;

    @ApiModelProperty(value = "处理编号")
    private Integer conprocessid;

    @ApiModelProperty(value = "处理人编号")
    private Integer userid;

    @ApiModelProperty(value = "处理时间")
    private String disposetime;

    @ApiModelProperty(value = "当前状态")
    private String todaystate;

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


}
