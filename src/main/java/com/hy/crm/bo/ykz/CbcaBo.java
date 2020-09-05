package com.hy.crm.bo.ykz;

/**
 * @author yukangze
 * @version 1.0
 * @description
 * @date 2020-09-02 19:52
 */
public class CbcaBo {

    //客户表id
    private Integer customerid;

    //客户名称
    private String customername;

    //商机数
    private Integer businessNumber;

    //预计成交金额
    private float expectedTransactionAmount;
    //合同数
    private Integer contractNumber;
    //合同金额
    private float contractmoney;
    //回款额
    private float returned;
    //售后服务数
    private Integer aftersaleNumbre;
    //服务均分
    private float average;

    public Integer getCustomerid() {
        return customerid;
    }

    public void setCustomerid(Integer customerid) {
        this.customerid = customerid;
    }

    public String getCustomername() {
        return customername;
    }

    public void setCustomername(String customername) {
        this.customername = customername;
    }

    public Integer getBusinessNumber() {
        return businessNumber;
    }

    public void setBusinessNumber(Integer businessNumber) {
        this.businessNumber = businessNumber;
    }

    public float getExpectedTransactionAmount() {
        return expectedTransactionAmount;
    }

    public void setExpectedTransactionAmount(float expectedTransactionAmount) {
        this.expectedTransactionAmount = expectedTransactionAmount;
    }

    public Integer getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(Integer contractNumber) {
        this.contractNumber = contractNumber;
    }

    public Float getContractmoney() {
        return contractmoney;
    }

    public void setContractmoney(Float contractmoney) {
        this.contractmoney = contractmoney;
    }

    public Float getReturned() {
        return returned;
    }

    public void setReturned(Float returned) {
        this.returned = returned;
    }

    public Integer getAftersaleNumbre() {
        return aftersaleNumbre;
    }

    public void setAftersaleNumbre(Integer aftersaleNumbre) {
        this.aftersaleNumbre = aftersaleNumbre;
    }

    public Float getAverage() {
        return average;
    }

    public void setAverage(Float average) {
        this.average = average;
    }

    @Override
    public String toString() {
        return "CbcaBo{" +
                "customerid=" + customerid +
                ", customername=" + customername +
                ", businessNumber=" + businessNumber +
                ", expectedTransactionAmount='" + expectedTransactionAmount + '\'' +
                ", contractNumber=" + contractNumber +
                ", contractmoney='" + contractmoney + '\'' +
                ", returned='" + returned + '\'' +
                ", aftersaleNumbre='" + aftersaleNumbre + '\'' +
                ", average='" + average + '\'' +
                '}';
    }
}
