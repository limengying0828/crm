package com.hy.crm.bo.pml;

import com.hy.crm.pojo.Business;
import com.hy.crm.pojo.Invitation;
import com.hy.crm.pojo.User;

/**
 * @Author 潘梦丽
 * @create 2020/9/9
 */
public class InvitationBo {

    //帖子表
    private Invitation invitation;
    //商机表
    private Business business;
    //用户表
    private User user;
    //回复数
    private Integer replies;

    public Invitation getInvitation() {
        return invitation;
    }

    public InvitationBo(Invitation invitation, Business business, User user, Integer replies) {
        this.invitation = invitation;
        this.business = business;
        this.user = user;
        this.replies = replies;
    }

    public InvitationBo(Invitation invitation) {
        this.invitation = invitation;
    }

    public void setInvitation(Invitation invitation) {
        this.invitation = invitation;
    }

    public Business getBusiness() {
        return business;
    }

    public void setBusiness(Business business) {
        this.business = business;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getReplies() {
        return replies;
    }

    public void setReplies(Integer replies) {
        this.replies = replies;
    }

    @Override
    public String toString() {
        return "InvitationBo{" +
                "invitation=" + invitation +
                ", business=" + business +
                ", user=" + user +
                ", replies=" + replies +
                '}';
    }
}
