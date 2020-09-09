package com.hy.crm.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * <p>
 * 汇款额详情表
 * </p>
 *
 * @author zzx
 * @since 2020-08-28
 */
@ApiModel(value="Remits对象", description="汇款额详情表")
public class Remits implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "汇款编号")
    @TableId(value = "remitsid", type = IdType.AUTO)
    private Integer remitsid;

    @ApiModelProperty(value = "收入日期")
    private String incometime;

    @ApiModelProperty(value = "收入分类")
    private String incomeclass;

    @ApiModelProperty(value = "收入金额")
    private Float incomemoney;

    @ApiModelProperty(value = "大写钱数")
    private String capital;

    @ApiModelProperty(value = "收款方式")
    private String paymentterm;

    @ApiModelProperty(value = "登记人")
    private Integer userid;

    @ApiModelProperty(value = "用户编号")
    private Integer customerid;

    @ApiModelProperty(value = "合同编号")
    private String contractid;

    @ApiModelProperty(value = "合同说明")
    private String incomestatement;

    public Integer getRemitsid() {
        return remitsid;
    }

    public void setRemitsid(Integer remitsid) {
        this.remitsid = remitsid;
    }
    public String getIncometime() {
        return incometime;
    }

    public void setIncometime(String incometime) {
        this.incometime = incometime;
    }
    public String getIncomeclass() {
        return incomeclass;
    }

    public void setIncomeclass(String incomeclass) {
        this.incomeclass = incomeclass;
    }
    public Float getIncomemoney() {
        return incomemoney;
    }

    public void setIncomemoney(Float incomemoney) {
        this.incomemoney = incomemoney;
    }
    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }
    public String getPaymentterm() {
        return paymentterm;
    }

    public void setPaymentterm(String paymentterm) {
        this.paymentterm = paymentterm;
    }
    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
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

    public String getIncomestatement() {
        return incomestatement;
    }

    public void setIncomestatement(String incomestatement) {
        this.incomestatement = incomestatement;
    }


    @Override
    public String toString() {
        return "Remits{" +
            "remitsid=" + remitsid +
            ", incometime=" + incometime +
            ", incomeclass=" + incomeclass +
            ", incomemoney=" + incomemoney +
            ", capital=" + capital +
            ", paymentterm=" + paymentterm +
            ", userid=" + userid +
            ", customerid=" + customerid +
            ", contractid=" + contractid +
            ", incomestatement=" + incomestatement +
        "}";
    }
}
