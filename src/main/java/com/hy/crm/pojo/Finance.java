package com.hy.crm.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 财物详细表
 * </p>
 *
 * @author zzx
 * @since 2020-08-28
 */
@ApiModel(value="Finance对象", description="财物详细表")
public class Finance implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "财务信息编号")
    @TableId(value = "financeId", type = IdType.AUTO)
    private Integer financeId;

    @ApiModelProperty(value = "客户编号")
    private Integer customerid;

    @ApiModelProperty(value = "银行账号")
    private String bankaccount;

    @ApiModelProperty(value = "开户名称")
    private String accountname;

    @ApiModelProperty(value = "开户银行")
    private String accountbank;

    @ApiModelProperty(value = "银行地址")
    private String bankurl;

    @ApiModelProperty(value = "税号")
    private String dutyparagraph;

    @ApiModelProperty(value = "电话")
    private String phone;

    public Integer getFinanceId() {
        return financeId;
    }

    public void setFinanceId(Integer financeId) {
        this.financeId = financeId;
    }
    public Integer getCustomerid() {
        return customerid;
    }

    public void setCustomerid(Integer customerid) {
        this.customerid = customerid;
    }
    public String getBankaccount() {
        return bankaccount;
    }

    public void setBankaccount(String bankaccount) {
        this.bankaccount = bankaccount;
    }
    public String getAccountname() {
        return accountname;
    }

    public void setAccountname(String accountname) {
        this.accountname = accountname;
    }
    public String getAccountbank() {
        return accountbank;
    }

    public void setAccountbank(String accountbank) {
        this.accountbank = accountbank;
    }
    public String getBankurl() {
        return bankurl;
    }

    public void setBankurl(String bankurl) {
        this.bankurl = bankurl;
    }
    public String getDutyparagraph() {
        return dutyparagraph;
    }

    public void setDutyparagraph(String dutyparagraph) {
        this.dutyparagraph = dutyparagraph;
    }
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Finance{" +
            "financeId=" + financeId +
            ", customerid=" + customerid +
            ", bankaccount=" + bankaccount +
            ", accountname=" + accountname +
            ", accountbank=" + accountbank +
            ", bankurl=" + bankurl +
            ", dutyparagraph=" + dutyparagraph +
            ", phone=" + phone +
        "}";
    }
}
