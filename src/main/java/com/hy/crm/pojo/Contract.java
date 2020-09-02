package com.hy.crm.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * <p>
 * 合同表
 * </p>
 *
 * @author zzx
 * @since 2020-08-28
 */
@ApiModel(value="Contract对象", description="合同表")
public class Contract implements Serializable {

    private static final long serialVersionUID = 1L;

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

    public String getContractid() {
        return contractid;
    }

    public void setContractid(String contractid) {
        this.contractid = contractid;
    }
    public Integer getCustomerid() {
        return customerid;
    }

    public void setCustomerid(Integer customerid) {
        this.customerid = customerid;
    }
    public String getContractname() {
        return contractname;
    }

    public void setContractname(String contractname) {
        this.contractname = contractname;
    }
    public Float getContractmoney() {
        return contractmoney;
    }

    public void setContractmoney(Float contractmoney) {
        this.contractmoney = contractmoney;
    }
    public Float getRemittancecount() {
        return remittancecount;
    }

    public void setRemittancecount(Float remittancecount) {
        this.remittancecount = remittancecount;
    }
    public Float getMakecount() {
        return makecount;
    }

    public void setMakecount(Float makecount) {
        this.makecount = makecount;
    }
    public String getSigningdate() {
        return signingdate;
    }

    public void setSigningdate(String signingdate) {
        this.signingdate = signingdate;
    }
    public String getTakedate() {
        return takedate;
    }

    public void setTakedate(String takedate) {
        this.takedate = takedate;
    }
    public String getServiceto() {
        return serviceto;
    }

    public void setServiceto(String serviceto) {
        this.serviceto = serviceto;
    }
    public String getSidelinkman() {
        return sidelinkman;
    }

    public void setSidelinkman(String sidelinkman) {
        this.sidelinkman = sidelinkman;
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
    public String getTechnicalterms() {
        return technicalterms;
    }

    public void setTechnicalterms(String technicalterms) {
        this.technicalterms = technicalterms;
    }
    public String getBusinessterms() {
        return businessterms;
    }

    public void setBusinessterms(String businessterms) {
        this.businessterms = businessterms;
    }
    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }
    public String getAssociatedpersons() {
        return associatedpersons;
    }

    public void setAssociatedpersons(String associatedpersons) {
        this.associatedpersons = associatedpersons;
    }

    @Override
    public String toString() {
        return "Contract{" +
            "contractid=" + contractid +
            ", customerid=" + customerid +
            ", contractname=" + contractname +
            ", contractmoney=" + contractmoney +
            ", remittancecount=" + remittancecount +
            ", makecount=" + makecount +
            ", signingdate=" + signingdate +
            ", takedate=" + takedate +
            ", serviceto=" + serviceto +
            ", sidelinkman=" + sidelinkman +
            ", officephone=" + officephone +
            ", telephone=" + telephone +
            ", email=" + email +
            ", technicalterms=" + technicalterms +
            ", businessterms=" + businessterms +
            ", attachment=" + attachment +
            ", associatedpersons=" + associatedpersons +
        "}";
    }
}
