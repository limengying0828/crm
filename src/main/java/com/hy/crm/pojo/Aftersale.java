package com.hy.crm.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 售后服务
 * </p>
 *
 * @author zzx
 * @since 2020-08-28
 */
@ApiModel(value="Aftersale对象", description="售后服务")
public class Aftersale implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "售后服务编号")
    @TableId(value = "saleid", type = IdType.AUTO)
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
    private Integer servicespeople;

    @ApiModelProperty(value = "服务评分")
    private String servicesscore;

    @ApiModelProperty(value = "附件")
    private String attachment;

    public Integer getSaleid() {
        return saleid;
    }

    public void setSaleid(Integer saleid) {
        this.saleid = saleid;
    }
    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }
    public String getStep() {
        return step;
    }

    public void setStep(String step) {
        this.step = step;
    }
    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }
    public String getParticipant() {
        return participant;
    }

    public void setParticipant(String participant) {
        this.participant = participant;
    }
    public Integer getCustomerid() {
        return customerid;
    }

    public void setCustomerid(Integer customerid) {
        this.customerid = customerid;
    }
    public String getContractid() {
        return contractid;
    }

    public void setContractid(String contractid) {
        this.contractid = contractid;
    }
    public String getContactperson() {
        return contactperson;
    }

    public void setContactperson(String contactperson) {
        this.contactperson = contactperson;
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
    public String getTypeservices() {
        return typeservices;
    }

    public void setTypeservices(String typeservices) {
        this.typeservices = typeservices;
    }
    public String getServicemode() {
        return servicemode;
    }

    public void setServicemode(String servicemode) {
        this.servicemode = servicemode;
    }
    public String getBegintime() {
        return begintime;
    }

    public void setBegintime(String begintime) {
        this.begintime = begintime;
    }
    public String getOvertime() {
        return overtime;
    }

    public void setOvertime(String overtime) {
        this.overtime = overtime;
    }
    public String getServicescontent() {
        return servicescontent;
    }

    public void setServicescontent(String servicescontent) {
        this.servicescontent = servicescontent;
    }
    public String getCustomerfeedback() {
        return customerfeedback;
    }

    public void setCustomerfeedback(String customerfeedback) {
        this.customerfeedback = customerfeedback;
    }
    public Integer getServicespeople() {
        return servicespeople;
    }

    public void setServicespeople(Integer servicespeople) {
        this.servicespeople = servicespeople;
    }
    public String getServicesscore() {
        return servicesscore;
    }

    public void setServicesscore(String servicesscore) {
        this.servicesscore = servicesscore;
    }
    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }

    @Override
    public String toString() {
        return "Aftersale{" +
            "saleid=" + saleid +
            ", theme=" + theme +
            ", step=" + step +
            ", userid=" + userid +
            ", participant=" + participant +
            ", customerid=" + customerid +
            ", contractid=" + contractid +
            ", contactperson=" + contactperson +
            ", officephone=" + officephone +
            ", telephone=" + telephone +
            ", email=" + email +
            ", typeservices=" + typeservices +
            ", servicemode=" + servicemode +
            ", begintime=" + begintime +
            ", overtime=" + overtime +
            ", servicescontent=" + servicescontent +
            ", customerfeedback=" + customerfeedback +
            ", servicespeople=" + servicespeople +
            ", servicesscore=" + servicesscore +
            ", attachment=" + attachment +
        "}";
    }
}
