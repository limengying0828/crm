package com.hy.crm.bo.pml;

import com.hy.crm.pojo.Invitation;
import com.hy.crm.pojo.Reply;
import com.hy.crm.pojo.User;

import java.util.List;

/**
 * @Author 潘梦丽
 * @create 2020/9/9
 */
public class InvitationBos {

    //帖子表
    private Invitation invitation;
    //回复表
    private List<Reply> replie;
    //用户表
    private List<User> userList;
    //回复数
    private Integer replies;

    public InvitationBos(Invitation invitation, List<Reply> replie, List<User> userList, Integer replies) {
        this.invitation = invitation;
        this.replie = replie;
        this.userList = userList;
        this.replies = replies;
    }

    public Invitation getInvitation() {
        return invitation;
    }

    public void setInvitation(Invitation invitation) {
        this.invitation = invitation;
    }

    public List<Reply> getReplie() {
        return replie;
    }

    public void setReplie(List<Reply> replie) {
        this.replie = replie;
    }

    @Override
    public String toString() {
        return "InvitationBos{" +
                "invitation=" + invitation +
                ", replie=" + replie +
                ", userList=" + userList +
                ", replies=" + replies +
                '}';
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public Integer getReplies() {
        return replies;
    }

    public void setReplies(Integer replies) {
        this.replies = replies;
    }

}
