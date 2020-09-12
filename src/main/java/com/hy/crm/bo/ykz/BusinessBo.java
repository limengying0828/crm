package com.hy.crm.bo.ykz;

/**
 * @author yukangze
 * @version 1.0
 * @description
 * @date 2020-09-07 10:20
 */
public class BusinessBo {
    private Integer businessid;

    //商机名称
    private String businessname;

    //商机阶段
    private String todaystate;

    //商机负责人
    private String userId;

    //预计成交金额
    private float makemoney;

    //最后跟单时间
    private String documentarytime;

    //讨论版
    private Integer forum;

    public Integer getBusinessid() {
        return businessid;
    }

    public void setBusinessid(Integer businessid) {
        this.businessid = businessid;
    }

    public String getBusinessname() {
        return businessname;
    }

    public void setBusinessname(String businessname) {
        this.businessname = businessname;
    }

    public String getTodaystate() {
        return todaystate;
    }

    public void setTodaystate(String todaystate) {
        this.todaystate = todaystate;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public float getMakemoney() {
        return makemoney;
    }

    public void setMakemoney(float makemoney) {
        this.makemoney = makemoney;
    }

    public String getDocumentarytime() {
        return documentarytime;
    }

    public void setDocumentarytime(String documentarytime) {
        this.documentarytime = documentarytime;
    }

    public Integer getForum() {
        return forum;
    }

    public void setForum(Integer forum) {
        this.forum = forum;
    }

    @Override
    public String toString() {
        return "BusinessBo{" +
                "businessid=" + businessid +
                ", businessname='" + businessname + '\'' +
                ", todaystate='" + todaystate + '\'' +
                ", userId='" + userId + '\'' +
                ", makemoney='" + makemoney + '\'' +
                ", documentarytime='" + documentarytime + '\'' +
                ", forum='" + forum + '\'' +
                '}';
    }
}
