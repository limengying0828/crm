package com.hy.crm.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 售后服务处理流程表
 * </p>
 *
 * @author zzx
 * @since 2020-08-28
 */
@ApiModel(value="After对象", description="售后服务处理流程表")
public class After implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "流程编号")
    @TableId(value = "afterid", type = IdType.AUTO)
    private Integer afterid;

    @ApiModelProperty(value = "服务编号")
    private Integer serviceid;

    @ApiModelProperty(value = "处理人(用户id)")
    private Integer userid;

    @ApiModelProperty(value = "处理时间")
    private String disposetime;

    @ApiModelProperty(value = "处理内容（转服务人员处理，本次服务完成）")
    private String disposecontent;

    public Integer getAfterid() {
        return afterid;
    }

    public void setAfterid(Integer afterid) {
        this.afterid = afterid;
    }
    public Integer getServiceid() {
        return serviceid;
    }

    public void setServiceid(Integer serviceid) {
        this.serviceid = serviceid;
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
    public String getDisposecontent() {
        return disposecontent;
    }

    public void setDisposecontent(String disposecontent) {
        this.disposecontent = disposecontent;
    }

    @Override
    public String toString() {
        return "After{" +
            "afterid=" + afterid +
            ", serviceid=" + serviceid +
            ", userid=" + userid +
            ", disposetime=" + disposetime +
            ", disposecontent=" + disposecontent +
        "}";
    }
}
