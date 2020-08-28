package com.hy.crm.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 开票处理过程表
 * </p>
 *
 * @author zzx
 * @since 2020-08-28
 */
@ApiModel(value="Makeprocess对象", description="开票处理过程表")
public class Makeprocess implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "过程编号")
    @TableId(value = "markprocessid", type = IdType.AUTO)
    private Integer markprocessid;

    @ApiModelProperty(value = "开票编号")
    private Integer makeid;

    @ApiModelProperty(value = "处理人(用户编号)")
    private Integer userid;

    @ApiModelProperty(value = "处理时间")
    private String disposetime;

    public Integer getMarkprocessid() {
        return markprocessid;
    }

    public void setMarkprocessid(Integer markprocessid) {
        this.markprocessid = markprocessid;
    }
    public Integer getMakeid() {
        return makeid;
    }

    public void setMakeid(Integer makeid) {
        this.makeid = makeid;
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

    @Override
    public String toString() {
        return "Makeprocess{" +
            "markprocessid=" + markprocessid +
            ", makeid=" + makeid +
            ", userid=" + userid +
            ", disposetime=" + disposetime +
        "}";
    }
}
