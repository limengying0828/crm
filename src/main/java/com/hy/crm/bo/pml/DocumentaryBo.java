package com.hy.crm.bo.pml;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Author 潘梦丽
 * @create 2020/9/1
 */
public class DocumentaryBo {
    @ApiModelProperty(value = "跟单编号")
    @TableId(value = "documentaryid", type = IdType.AUTO)
    private Integer documentaryid;

    @ApiModelProperty(value = "商机编号")
    private Integer processid;

    @ApiModelProperty(value = "跟单主题（商机+跟单分类组成）")
    private String theme;

    @ApiModelProperty(value = "跟单时间")
    private String documentarytime;

    @ApiModelProperty(value = "跟单分类")
    private String documentaryclass;

    @ApiModelProperty(value = "跟单人")
    private Integer userid;

    @ApiModelProperty(value = "详细内容")
    private String detail;

    @ApiModelProperty(value = "相关附件")
    private String attachment;

    @ApiModelProperty(value = "优先级（int类型）")
    private Integer contractpriority;

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

    public Integer getDocumentaryid() {
        return documentaryid;
    }

    public void setDocumentaryid(Integer documentaryid) {
        this.documentaryid = documentaryid;
    }

    public Integer getProcessid() {
        return processid;
    }

    public void setProcessid(Integer processid) {
        this.processid = processid;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getDocumentarytime() {
        return documentarytime;
    }

    public void setDocumentarytime(String documentarytime) {
        this.documentarytime = documentarytime;
    }

    public String getDocumentaryclass() {
        return documentaryclass;
    }

    public void setDocumentaryclass(String documentaryclass) {
        this.documentaryclass = documentaryclass;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }

    public Integer getContractpriority() {
        return contractpriority;
    }

    public void setContractpriority(Integer contractpriority) {
        this.contractpriority = contractpriority;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "DocumentaryBo{" +
                "documentaryid=" + documentaryid +
                ", processid=" + processid +
                ", theme='" + theme + '\'' +
                ", documentarytime='" + documentarytime + '\'' +
                ", documentaryclass='" + documentaryclass + '\'' +
                ", userid=" + userid +
                ", detail='" + detail + '\'' +
                ", attachment='" + attachment + '\'' +
                ", contractpriority=" + contractpriority +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", deptname='" + deptname + '\'' +
                ", role='" + role + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
