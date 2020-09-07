package com.hy.crm.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * <p>
 * 商机表
 * </p>
 *
 * @author zzx
 * @since 2020-08-28
 */
@ApiModel(value="Business对象", description="商机表")
public class Business implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "商机编号")
    @TableId(value = "businessid", type = IdType.AUTO)
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

    @ApiModelProperty(value = "商机负责人")
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

    public Integer getCustomerid() {
        return customerid;
    }

    public void setCustomerid(Integer customerid) {
        this.customerid = customerid;
    }
    public String getBusinessname() {
        return businessname;
    }

    public void setBusinessname(String businessname) {
        this.businessname = businessname;
    }
    public String getCustomersource() {
        return customersource;
    }

    public void setCustomersource(String customersource) {
        this.customersource = customersource;
    }

    public Float getMakemoney() {
        return makemoney;
    }

    public void setMakemoney(Float makemoney) {
        this.makemoney = makemoney;
    }

    public String getOverdate() {
        return overdate;
    }

    public void setOverdate(String overdate) {
        this.overdate = overdate;
    }
    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }
    public String getOfficephone() {
        return officephone;
    }

    public void setOfficephone(String officephone) {
        this.officephone = officephone;
    }
    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getBusinessdemand() {
        return businessdemand;
    }

    public void setBusinessdemand(String businessdemand) {
        this.businessdemand = businessdemand;
    }
    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    public String getParticipate() {
        return participate;
    }

    public void setParticipate(String participate) {
        this.participate = participate;
    }
    public String getFocuspeople() {
        return focuspeople;
    }

    public void setFocuspeople(String focuspeople) {
        this.focuspeople = focuspeople;
    }
    public String getLastdocumentary() {
        return lastdocumentary;
    }

    public void setLastdocumentary(String lastdocumentary) {
        this.lastdocumentary = lastdocumentary;
    }
    public Integer getContractpriority() {
        return contractpriority;
    }

    public void setContractpriority(Integer contractpriority) {
        this.contractpriority = contractpriority;
    }

    public Integer getBusinessid() {
        return businessid;
    }

    public void setBusinessid(Integer businessid) {
        this.businessid = businessid;
    }

    public String getAddbusinesstime() {
        return addbusinesstime;
    }

    public void setAddbusinesstime(String addbusinesstime) {
        this.addbusinesstime = addbusinesstime;
    }

    @Override
    public String toString() {
        return "Business{" +
            "customerid=" + customerid +
            ", businessname=" + businessname +
            ", customersource=" + customersource +
            ", makemoney=" + makemoney +
            ", overdate=" + overdate +
            ", contact=" + contact +
            ", post=" + post +
            ", officephone=" + officephone +
            ", telephone=" + telephone +
            ", email=" + email +
            ", businessdemand=" + businessdemand +
            ", attachment=" + attachment +
            ", userId=" + userId +
            ", participate=" + participate +
            ", focuspeople=" + focuspeople +
            ", lastdocumentary=" + lastdocumentary +
            ", contractpriority=" + contractpriority +
        "}";
    }
}
