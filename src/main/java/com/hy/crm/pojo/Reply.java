package com.hy.crm.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * <p>
 * 帖子回复表
 * </p>
 *
 * @author zzx
 * @since 2020-08-28
 */
@ApiModel(value="Reply对象", description="帖子回复表")
public class Reply implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "replyid", type = IdType.AUTO)
    private Integer replyid;

    @ApiModelProperty(value = "帖子编号")
    private Integer invitationid;

    @ApiModelProperty(value = "用户编号")
    private Integer userid;

    @ApiModelProperty(value = "回复内容")
    private String replycontent;

    @ApiModelProperty(value = "回复时间")
    private String replytime;

    @ApiModelProperty(value = "被回复人编号")
    private Integer respondentid;

    public Integer getReplyid() {
        return replyid;
    }

    public void setReplyid(Integer replyid) {
        this.replyid = replyid;
    }
    public Integer getInvitationid() {
        return invitationid;
    }

    public void setInvitationid(Integer invitationid) {
        this.invitationid = invitationid;
    }
    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }
    public String getReplycontent() {
        return replycontent;
    }

    public void setReplycontent(String replycontent) {
        this.replycontent = replycontent;
    }
    public String getReplytime() {
        return replytime;
    }

    public void setReplytime(String replytime) {
        this.replytime = replytime;
    }

    public Integer getRespondentid() {
        return respondentid;
    }

    public void setRespondentid(Integer respondentid) {
        this.respondentid = respondentid;
    }

    @Override
    public String toString() {
        return "Reply{" +
            "replyid=" + replyid +
            ", invitationid=" + invitationid +
            ", userid=" + userid +
            ", replycontent=" + replycontent +
            ", replytime=" + replytime +
            ", respondentid=" + respondentid +
        "}";
    }
}
