package com.hy.crm.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 开票申请表
 * </p>
 *
 * @author zzx
 * @since 2020-08-28
 */
@ApiModel(value="Makeapply对象", description="开票申请表")
public class Makeapply implements Serializable {

    private static final long serialVersionUID = 1L;

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

    @ApiModelProperty(value = "主要技术条款")
    private String technicalterms;

    @ApiModelProperty(value = "客户编号")
    private Integer customerid;

    @ApiModelProperty(value = "关联合同(合同编号)")
    private Integer contractid;

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

    @ApiModelProperty(value = "附件")
    private String attachment;

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
    public String getTechnicalterms() {
        return technicalterms;
    }

    public void setTechnicalterms(String technicalterms) {
        this.technicalterms = technicalterms;
    }
    public Integer getCustomerid() {
        return customerid;
    }

    public void setCustomerid(Integer customerid) {
        this.customerid = customerid;
    }
    public Integer getContractid() {
        return contractid;
    }

    public void setContractid(Integer contractid) {
        this.contractid = contractid;
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
    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }

    @Override
    public String toString() {
        return "Makeapply{" +
            "makeid=" + makeid +
            ", theme=" + theme +
            ", overtime=" + overtime +
            ", step=" + step +
            ", drawer=" + drawer +
            ", participant=" + participant +
            ", detailedaddress=" + detailedaddress +
            ", userid=" + userid +
            ", appletime=" + appletime +
            ", technicalterms=" + technicalterms +
            ", customerid=" + customerid +
            ", contractid=" + contractid +
            ", makekind=" + makekind +
            ", makemoney=" + makemoney +
            ", amoney=" + amoney +
            ", makedate=" + makedate +
            ", invoicenumber=" + invoicenumber +
            ", attachment=" + attachment +
        "}";
    }
}
