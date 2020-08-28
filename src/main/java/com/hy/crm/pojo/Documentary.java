package com.hy.crm.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 跟单表
 * </p>
 *
 * @author zzx
 * @since 2020-08-28
 */
@ApiModel(value="Documentary对象", description="跟单表")
public class Documentary implements Serializable {

    private static final long serialVersionUID = 1L;

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

    @Override
    public String toString() {
        return "Documentary{" +
            "documentaryid=" + documentaryid +
            ", processid=" + processid +
            ", theme=" + theme +
            ", documentarytime=" + documentarytime +
            ", documentaryclass=" + documentaryclass +
            ", userid=" + userid +
            ", detail=" + detail +
            ", attachment=" + attachment +
            ", contractpriority=" + contractpriority +
        "}";
    }
}
