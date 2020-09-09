package com.hy.crm.bo.lmy;

import lombok.Data;

/**
 * @Author: 李梦莹
 * @create: 2020/9/8 10:20
 * @Description:
 */
@Data
public class TradeBo {
    //行业
    private String trade;
    //商机数
    private Integer count;
    //金额
    private float money;
    //行业别名
    private String nickname;

}
