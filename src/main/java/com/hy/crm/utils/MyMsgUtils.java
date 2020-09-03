package com.hy.crm.utils;

import lombok.Data;

/**
 * @Author: 李梦莹
 * @create: 2020/9/2 8:52
 * @Description:
 */
@Data
public class MyMsgUtils {
    //0：成功  1：失败
    private Integer code;
    //说明
    private String msg;
    //数据
    private String data;

}
