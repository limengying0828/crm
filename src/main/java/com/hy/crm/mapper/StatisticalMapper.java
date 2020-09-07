package com.hy.crm.mapper;

import com.hy.crm.sqlclass.StatisticalSql;
import org.apache.ibatis.annotations.SelectProvider;

/**
 * @Author: 李梦莹
 * @create: 2020/9/7 10:14
 * @Description:
 */
public interface StatisticalMapper {
    @SelectProvider(type = StatisticalSql.class,method = "queryMyStaBusiness")
    public Integer queryMyStaBusiness(String time);
    @SelectProvider(type = StatisticalSql.class,method = "querySuccessCount")
    public Integer quertMyStaBusprocess(String time);
    @SelectProvider(type = StatisticalSql.class,method = "queryDocumentaryCount")
    public Integer quertMyStaDocumentary(String time);
}
