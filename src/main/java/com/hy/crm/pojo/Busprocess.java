package com.hy.crm.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 商机处理过程表
 * </p>
 *
 * @author zzx
 * @since 2020-08-28
 */
@ApiModel(value="Busprocess对象", description="商机处理过程表")
public class Busprocess implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "过程编号")
    @TableId(value = "busprocessid", type = IdType.AUTO)
    private Integer busprocessid;

    @ApiModelProperty(value = "商机id")
    private Integer businessid;

    @ApiModelProperty(value = "处理人")
    private Integer userid;

    @ApiModelProperty(value = "处理时间")
    private String disposetime;

    @ApiModelProperty(value = "当前状态")
    private String todaystate;

    @ApiModelProperty(value = "审核状态")
    private String auditstatus;

    public Integer getBusprocessid() {
        return busprocessid;
    }

    public void setBusprocessid(Integer busprocessid) {
        this.busprocessid = busprocessid;
    }
    public Integer getBusinessid() {
        return businessid;
    }

    public void setBusinessid(Integer businessid) {
        this.businessid = businessid;
    }
    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }
    public String getDisposetime() {
        return disposetime;
    }

    public void setDisposetime(String disposetime) {
        this.disposetime = disposetime;
    }
    public String getTodaystate() {
        return todaystate;
    }

    public void setTodaystate(String todaystate) {
        this.todaystate = todaystate;
    }

    public String getAuditstatus() {
        return auditstatus;
    }

    public void setAuditstatus(String auditstatus) {
        this.auditstatus = auditstatus;
    }

    @Override
    public String toString() {
        return "Busprocess{" +
                "busprocessid=" + busprocessid +
                ", businessid=" + businessid +
                ", userid=" + userid +
                ", disposetime='" + disposetime + '\'' +
                ", todaystate='" + todaystate + '\'' +
                ", auditstatus='" + auditstatus + '\'' +
                '}';
    }
}
