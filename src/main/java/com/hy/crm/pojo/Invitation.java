package com.hy.crm.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * <p>
 * 帖子讨论表
 * </p>
 *
 * @author zzx
 * @since 2020-08-28
 */
@ApiModel(value="Invitation对象", description="帖子讨论表")
public class Invitation implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "帖子编号")
    @TableId(value = "invitationid", type = IdType.AUTO)
    private Integer invitationid;

    @ApiModelProperty(value = "商机编号")
    private Integer processid;

    @ApiModelProperty(value = "帖子分类")
    private String invitationclass;

    private String tagging;

    private String theme;

    @ApiModelProperty(value = "相关附件")
    private String attachment;

    private Integer userid;

    @ApiModelProperty(value = "发表内容")
    private String releasematter;

    private String releasetime;

    @ApiModelProperty(value = "点击数")
    private Integer clickcount;

    @ApiModelProperty(value = "回复数")
    private Integer replycount;

    @ApiModelProperty(value = "分类")
    private String classify;

    @ApiModelProperty(value = "设置（精华、顶置）")
    private String set;

    @ApiModelProperty(value = "最后回复时间")
    @TableField("lastReplytime")
    private String lastReplytime;

    public Integer getInvitationid() {
        return invitationid;
    }

    public void setInvitationid(Integer invitationid) {
        this.invitationid = invitationid;
    }
    public Integer getProcessid() {
        return processid;
    }

    public void setProcessid(Integer processid) {
        this.processid = processid;
    }
    public String getInvitationclass() {
        return invitationclass;
    }

    public void setInvitationclass(String invitationclass) {
        this.invitationclass = invitationclass;
    }
    public String getTagging() {
        return tagging;
    }

    public void setTagging(String tagging) {
        this.tagging = tagging;
    }
    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }
    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }
    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }
    public String getReleasematter() {
        return releasematter;
    }

    public void setReleasematter(String releasematter) {
        this.releasematter = releasematter;
    }
    public String getReleasetime() {
        return releasetime;
    }

    public void setReleasetime(String releasetime) {
        this.releasetime = releasetime;
    }
    public Integer getClickcount() {
        return clickcount;
    }

    public void setClickcount(Integer clickcount) {
        this.clickcount = clickcount;
    }
    public Integer getReplycount() {
        return replycount;
    }

    public void setReplycount(Integer replycount) {
        this.replycount = replycount;
    }

    public String getClassify() {
        return classify;
    }

    public void setClassify(String classify) {
        this.classify = classify;
    }

    public String getSet() {
        return set;
    }

    public void setSet(String set) {
        this.set = set;
    }
    public String getLastReplytime() {
        return lastReplytime;
    }

    public void setLastReplytime(String lastReplytime) {
        this.lastReplytime = lastReplytime;
    }

    @Override
    public String toString() {
        return "Invitation{" +
            "invitationid=" + invitationid +
            ", processid=" + processid +
            ", invitationclass=" + invitationclass +
            ", tagging=" + tagging +
            ", theme=" + theme +
            ", attachment=" + attachment +
            ", userid=" + userid +
            ", releasematter=" + releasematter +
            ", releasetime=" + releasetime +
            ", clickcount=" + clickcount +
            ", replycount=" + replycount +
            ", classify=" + classify +
            ", set=" + set +
            ", lastReplytime=" + lastReplytime +
        "}";
    }
}
