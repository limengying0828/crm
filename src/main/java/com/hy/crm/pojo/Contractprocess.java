package com.hy.crm.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * <p>
 * 合同处理流程表
 * </p>
 *
 * @author zzx
 * @since 2020-08-28
 */
@ApiModel(value="Contractprocess对象", description="合同处理流程表")
public class Contractprocess implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "处理编号")
    @TableId(value = "conprocessid", type = IdType.AUTO)
    private Integer conprocessid;

    @ApiModelProperty(value = "合同编号")
    private String contractid;

    @ApiModelProperty(value = "处理人编号")
    private Integer userid;

    @ApiModelProperty(value = "处理时间")
    private String disposetime;

    @ApiModelProperty(value = "当前状态")
    private String todaystate;

    public Integer getConprocessid() {
        return conprocessid;
    }

    public void setConprocessid(Integer conprocessid) {
        this.conprocessid = conprocessid;
    }

    public String getContractid() {
        return contractid;
    }

    public void setContractid(String contractid) {
        this.contractid = contractid;
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

    @Override
    public String toString() {
        return "Contractprocess{" +
            "conprocessid=" + conprocessid +
            ", contractid=" + contractid +
            ", userid=" + userid +
            ", disposetime=" + disposetime +
            ", todaystate=" + todaystate +
        "}";
    }
}
