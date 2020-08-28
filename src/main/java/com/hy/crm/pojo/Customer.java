package com.hy.crm.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 客户表
 * </p>
 *
 * @author zzx
 * @since 2020-08-28
 */
@ApiModel(value="Customer对象", description="客户表")
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "客户编号")
    @TableId(value = "customerid", type = IdType.AUTO)
    private Integer customerid;

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

    @ApiModelProperty(value = "办公电话")
    private String officephone;

    @ApiModelProperty(value = "移动电话")
    private String telephone;

    @ApiModelProperty(value = "邮件/QQ")
    private String email;

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
    public String getSpell() {
        return spell;
    }

    public void setSpell(String spell) {
        this.spell = spell;
    }
    public String getCustomerclass() {
        return customerclass;
    }

    public void setCustomerclass(String customerclass) {
        this.customerclass = customerclass;
    }
    public String getCustomersource() {
        return customersource;
    }

    public void setCustomersource(String customersource) {
        this.customersource = customersource;
    }
    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }
    public String getCustomerurl() {
        return customerurl;
    }

    public void setCustomerurl(String customerurl) {
        this.customerurl = customerurl;
    }
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public String getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
    }
    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }
    public String getLinkman() {
        return linkman;
    }

    public void setLinkman(String linkman) {
        this.linkman = linkman;
    }
    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
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
    public String getCorporate() {
        return corporate;
    }

    public void setCorporate(String corporate) {
        this.corporate = corporate;
    }
    public String getRegistered() {
        return registered;
    }

    public void setRegistered(String registered) {
        this.registered = registered;
    }
    public String getAdditional() {
        return additional;
    }

    public void setAdditional(String additional) {
        this.additional = additional;
    }
    public String getNumberbusiness() {
        return numberbusiness;
    }

    public void setNumberbusiness(String numberbusiness) {
        this.numberbusiness = numberbusiness;
    }
    public String getNumbercontract() {
        return numbercontract;
    }

    public void setNumbercontract(String numbercontract) {
        this.numbercontract = numbercontract;
    }
    public String getNumberafterSales() {
        return numberafterSales;
    }

    public void setNumberafterSales(String numberafterSales) {
        this.numberafterSales = numberafterSales;
    }

    @Override
    public String toString() {
        return "Customer{" +
            "customerid=" + customerid +
            ", customername=" + customername +
            ", spell=" + spell +
            ", customerclass=" + customerclass +
            ", customersource=" + customersource +
            ", industry=" + industry +
            ", customerurl=" + customerurl +
            ", state=" + state +
            ", city=" + city +
            ", address=" + address +
            ", postalcode=" + postalcode +
            ", fax=" + fax +
            ", linkman=" + linkman +
            ", department=" + department +
            ", post=" + post +
            ", officephone=" + officephone +
            ", telephone=" + telephone +
            ", email=" + email +
            ", corporate=" + corporate +
            ", registered=" + registered +
            ", additional=" + additional +
            ", numberbusiness=" + numberbusiness +
            ", numbercontract=" + numbercontract +
            ", numberafterSales=" + numberafterSales +
        "}";
    }
}
