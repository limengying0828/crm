package com.hy.crm.bo.pml;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Author 潘梦丽
 * @create 2020/9/5
 */
public class ContractBo {
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

    @ApiModelProperty(value = "编号")
    @TableId(value = "makeid", type = IdType.AUTO)
    private Integer makeid;

    @ApiModelProperty(value = "主题")
    private String theme;

    @ApiModelProperty(value = "结束时间")
    private String overtime;

    @ApiModelProperty(value = "步骤")
    private String step;

    @ApiModelProperty(value = "责任人（开票人）")
    private String drawer;

    @ApiModelProperty(value = "参与人")
    private String participant;

    @ApiModelProperty(value = "详细地址")
    private String detailedaddress;

    @ApiModelProperty(value = "申请人编号(用户id)")
    private Integer userid;

    @ApiModelProperty(value = "申请日期")
    private String appletime;

    @ApiModelProperty(value = "开票种类")
    private String makekind;

    @ApiModelProperty(value = "开票金额")
    private Float makemoney;

    @ApiModelProperty(value = "金额大写")
    private String amoney;

    @ApiModelProperty(value = "开票日期")
    private String makedate;

    @ApiModelProperty(value = "发票号")
    private Integer invoicenumber;

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

    public Integer getMakeid() {
        return makeid;
    }

    public void setMakeid(Integer makeid) {
        this.makeid = makeid;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getOvertime() {
        return overtime;
    }

    public void setOvertime(String overtime) {
        this.overtime = overtime;
    }

    public String getStep() {
        return step;
    }

    public void setStep(String step) {
        this.step = step;
    }

    public String getDrawer() {
        return drawer;
    }

    public void setDrawer(String drawer) {
        this.drawer = drawer;
    }

    public String getParticipant() {
        return participant;
    }

    public void setParticipant(String participant) {
        this.participant = participant;
    }

    public String getDetailedaddress() {
        return detailedaddress;
    }

    public void setDetailedaddress(String detailedaddress) {
        this.detailedaddress = detailedaddress;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getAppletime() {
        return appletime;
    }

    public void setAppletime(String appletime) {
        this.appletime = appletime;
    }

    public String getMakekind() {
        return makekind;
    }

    public void setMakekind(String makekind) {
        this.makekind = makekind;
    }

    public Float getMakemoney() {
        return makemoney;
    }

    public void setMakemoney(Float makemoney) {
        this.makemoney = makemoney;
    }

    public String getAmoney() {
        return amoney;
    }

    public void setAmoney(String amoney) {
        this.amoney = amoney;
    }

    public String getMakedate() {
        return makedate;
    }

    public void setMakedate(String makedate) {
        this.makedate = makedate;
    }

    public Integer getInvoicenumber() {
        return invoicenumber;
    }

    public void setInvoicenumber(Integer invoicenumber) {
        this.invoicenumber = invoicenumber;
    }
}
