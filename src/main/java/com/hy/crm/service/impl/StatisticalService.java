package com.hy.crm.service.impl;

import com.hy.crm.bo.lmy.MyStatisticalBo;
import com.hy.crm.mapper.StatisticalMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: 李梦莹
 * @create: 2020/9/7 10:13
 * @Description:
 */
@Service
public class StatisticalService {
    @Autowired
    private StatisticalMapper statisticalMapper;
    public List<MyStatisticalBo> queryMySta(){
        List<MyStatisticalBo> list=new ArrayList<>();
        //商机数
        Integer businessWeekCount=statisticalMapper.queryMyStaBusiness("本周");
        MyStatisticalBo businessWeek=new MyStatisticalBo();
        businessWeek.setTime("本周");
        businessWeek.setType("business");
        businessWeek.setCount(businessWeekCount);
        list.add(businessWeek);

        Integer businessLastWeekCount=statisticalMapper.queryMyStaBusiness("上周");
        MyStatisticalBo businessLastWeek=new MyStatisticalBo();
        businessLastWeek.setTime("上周");
        businessLastWeek.setType("business");
        businessLastWeek.setCount(businessLastWeekCount);
        list.add(businessLastWeek);

        Integer businessMonthCount=statisticalMapper.queryMyStaBusiness("本月");
        MyStatisticalBo businessMonth=new MyStatisticalBo();
        businessMonth.setTime("本月");
        businessMonth.setType("business");
        businessMonth.setCount(businessMonthCount);
        list.add(businessMonth);

        Integer businessLastMonthCount=statisticalMapper.queryMyStaBusiness("上月");
        MyStatisticalBo businessLastMonth=new MyStatisticalBo();
        businessLastMonth.setTime("上月");
        businessLastMonth.setType("business");
        businessLastMonth.setCount(businessLastMonthCount);
        list.add(businessLastMonth);

        Integer businessQuarterCount=statisticalMapper.queryMyStaBusiness("本季度");
        MyStatisticalBo businessQuarter=new MyStatisticalBo();
        businessQuarter.setTime("本季度");
        businessQuarter.setType("business");
        businessQuarter.setCount(businessQuarterCount);
        list.add(businessQuarter);

        Integer businessLastQuarterCount=statisticalMapper.queryMyStaBusiness("上季度");
        MyStatisticalBo businessLastQuarter=new MyStatisticalBo();
        businessLastQuarter.setTime("上季度");
        businessLastQuarter.setType("business");
        businessLastQuarter.setCount(businessLastQuarterCount);
        list.add(businessLastQuarter);

        Integer businessYearCount=statisticalMapper.queryMyStaBusiness("本年度");
        MyStatisticalBo businessYear=new MyStatisticalBo();
        businessYear.setTime("本年度");
        businessYear.setType("business");
        businessYear.setCount(businessYearCount);
        list.add(businessYear);

        Integer businessLastYearCount=statisticalMapper.queryMyStaBusiness("上年度");
        MyStatisticalBo businessLastYear=new MyStatisticalBo();
        businessLastYear.setTime("上年度");
        businessLastYear.setType("business");
        businessLastYear.setCount(businessLastYearCount);
        list.add(businessLastYear);

        //成交数
        Integer busprocessWeekCount=statisticalMapper.quertMyStaBusprocess("本周");
        MyStatisticalBo busprocessWeek=new MyStatisticalBo();
        busprocessWeek.setTime("本周");
        busprocessWeek.setType("buprocess");
        busprocessWeek.setCount(busprocessWeekCount);
        list.add(busprocessWeek);

        Integer busprocessLastWeekCount=statisticalMapper.quertMyStaBusprocess("上周");
        MyStatisticalBo busprocessLastWeek=new MyStatisticalBo();
        busprocessLastWeek.setTime("上周");
        busprocessLastWeek.setType("buprocess");
        busprocessLastWeek.setCount(busprocessLastWeekCount);
        list.add(busprocessLastWeek);

        Integer busprocessMonthCount=statisticalMapper.quertMyStaBusprocess("本月");
        MyStatisticalBo busprocessMonth=new MyStatisticalBo();
        busprocessMonth.setTime("本月");
        busprocessMonth.setType("buprocess");
        busprocessMonth.setCount(busprocessMonthCount);
        list.add(busprocessMonth);

        Integer busprocessLastMonthCount=statisticalMapper.quertMyStaBusprocess("上月");
        MyStatisticalBo busprocessLastMonth=new MyStatisticalBo();
        busprocessLastMonth.setTime("上月");
        busprocessLastMonth.setType("buprocess");
        busprocessLastMonth.setCount(busprocessLastMonthCount);
        list.add(busprocessLastMonth);

        Integer busprocessQuarterCount=statisticalMapper.quertMyStaBusprocess("本季度");
        MyStatisticalBo busprocessQuarter=new MyStatisticalBo();
        busprocessQuarter.setTime("本季度");
        busprocessQuarter.setType("buprocess");
        busprocessQuarter.setCount(busprocessQuarterCount);
        list.add(busprocessQuarter);

        Integer busprocessLastQuarterCount=statisticalMapper.quertMyStaBusprocess("上季度");
        MyStatisticalBo busprocessLastQuarter=new MyStatisticalBo();
        busprocessLastQuarter.setTime("上季度");
        busprocessLastQuarter.setType("buprocess");
        busprocessLastQuarter.setCount(busprocessLastQuarterCount);
        list.add(busprocessLastQuarter);

        Integer busprocessYearCount=statisticalMapper.quertMyStaBusprocess("本年度");
        MyStatisticalBo busprocessYear=new MyStatisticalBo();
        busprocessYear.setTime("本年度");
        busprocessYear.setType("buprocess");
        busprocessYear.setCount(busprocessYearCount);
        list.add(busprocessYear);

        Integer  busprocessLastYearCount=statisticalMapper.queryMyStaBusiness("上年度");
        MyStatisticalBo  busprocessLastYear=new MyStatisticalBo();
        busprocessLastYear.setTime("上年度");
        busprocessLastYear.setType(" busprocess");
        busprocessLastYear.setCount(busprocessLastYearCount);
        list.add(busprocessLastYear);

        //成交数
        Integer documentaryWeekCount=statisticalMapper.quertMyStaDocumentary("本周");
        MyStatisticalBo documentaryWeek=new MyStatisticalBo();
        documentaryWeek.setTime("本周");
        documentaryWeek.setType("documentary");
        documentaryWeek.setCount(documentaryWeekCount);
        list.add(documentaryWeek);

        Integer documentaryLastWeekCount=statisticalMapper.quertMyStaBusprocess("上周");
        MyStatisticalBo documentaryLastWeek=new MyStatisticalBo();
        documentaryLastWeek.setTime("上周");
        documentaryLastWeek.setType("documentary");
        documentaryLastWeek.setCount(documentaryLastWeekCount);
        list.add(documentaryLastWeek);

        Integer documentaryMonthCount=statisticalMapper.quertMyStaBusprocess("本月");
        MyStatisticalBo documentaryMonth=new MyStatisticalBo();
        documentaryMonth.setTime("本月");
        documentaryMonth.setType("documentary");
        documentaryMonth.setCount(documentaryMonthCount);
        list.add(documentaryMonth);

        Integer documentaryLastMonthCount=statisticalMapper.quertMyStaBusprocess("上月");
        MyStatisticalBo documentaryLastMonth=new MyStatisticalBo();
        documentaryLastMonth.setTime("上月");
        documentaryLastMonth.setType("documentary");
        documentaryLastMonth.setCount(documentaryLastMonthCount);
        list.add(documentaryLastMonth);

        Integer documentaryQuarterCount=statisticalMapper.quertMyStaBusprocess("本季度");
        MyStatisticalBo documentaryQuarter=new MyStatisticalBo();
        documentaryQuarter.setTime("本季度");
        documentaryQuarter.setType("documentary");
        documentaryQuarter.setCount(documentaryQuarterCount);
        list.add(documentaryQuarter);

        Integer documentaryLastQuarterCount=statisticalMapper.quertMyStaBusprocess("上季度");
        MyStatisticalBo documentaryLastQuarter=new MyStatisticalBo();
        documentaryLastQuarter.setTime("上季度");
        documentaryLastQuarter.setType("documentary");
        documentaryLastQuarter.setCount(documentaryLastQuarterCount);
        list.add(documentaryLastQuarter);

        Integer documentaryYearCount=statisticalMapper.quertMyStaBusprocess("本年度");
        MyStatisticalBo documentaryYear=new MyStatisticalBo();
        documentaryYear.setTime("本年度");
        documentaryYear.setType("documentary");
        documentaryYear.setCount(documentaryYearCount);
        list.add(documentaryYear);

        Integer  documentaryLastYearCount=statisticalMapper.queryMyStaBusiness("上年度");
        MyStatisticalBo  documentaryLastYear=new MyStatisticalBo();
        documentaryLastYear.setTime("上年度");
        documentaryLastYear.setType(" documentary");
        documentaryLastYear.setCount(documentaryLastYearCount);
        list.add(documentaryLastYear);
        return list;
    }
}
