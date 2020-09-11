package com.hy.crm.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hy.crm.bo.lmy.*;
import com.hy.crm.mapper.StatisticalMapper;
import com.hy.crm.mapper.UserMapper;
import com.hy.crm.pojo.User;
import com.hy.crm.utils.MsgUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.NumberFormat;
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
    @Autowired
    private UserMapper userMapper;
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
        busprocessLastYear.setType("buprocess");
        busprocessLastYear.setCount(busprocessLastYearCount);
        list.add(busprocessLastYear);

        //跟单数
        Integer documentaryWeekCount=statisticalMapper.quertMyStaDocumentary("本周");
        MyStatisticalBo documentaryWeek=new MyStatisticalBo();
        documentaryWeek.setTime("本周");
        documentaryWeek.setType("documentary");
        documentaryWeek.setCount(documentaryWeekCount);
        list.add(documentaryWeek);

        Integer documentaryLastWeekCount=statisticalMapper.quertMyStaDocumentary("上周");
        MyStatisticalBo documentaryLastWeek=new MyStatisticalBo();
        documentaryLastWeek.setTime("上周");
        documentaryLastWeek.setType("documentary");
        documentaryLastWeek.setCount(documentaryLastWeekCount);
        list.add(documentaryLastWeek);

        Integer documentaryMonthCount=statisticalMapper.quertMyStaDocumentary("本月");
        MyStatisticalBo documentaryMonth=new MyStatisticalBo();
        documentaryMonth.setTime("本月");
        documentaryMonth.setType("documentary");
        documentaryMonth.setCount(documentaryMonthCount);
        list.add(documentaryMonth);

        Integer documentaryLastMonthCount=statisticalMapper.quertMyStaDocumentary("上月");
        MyStatisticalBo documentaryLastMonth=new MyStatisticalBo();
        documentaryLastMonth.setTime("上月");
        documentaryLastMonth.setType("documentary");
        documentaryLastMonth.setCount(documentaryLastMonthCount);
        list.add(documentaryLastMonth);

        Integer documentaryQuarterCount=statisticalMapper.quertMyStaDocumentary("本季度");
        MyStatisticalBo documentaryQuarter=new MyStatisticalBo();
        documentaryQuarter.setTime("本季度");
        documentaryQuarter.setType("documentary");
        documentaryQuarter.setCount(documentaryQuarterCount);
        list.add(documentaryQuarter);

        Integer documentaryLastQuarterCount=statisticalMapper.quertMyStaDocumentary("上季度");
        MyStatisticalBo documentaryLastQuarter=new MyStatisticalBo();
        documentaryLastQuarter.setTime("上季度");
        documentaryLastQuarter.setType("documentary");
        documentaryLastQuarter.setCount(documentaryLastQuarterCount);
        list.add(documentaryLastQuarter);

        Integer documentaryYearCount=statisticalMapper.quertMyStaDocumentary("本年度");
        MyStatisticalBo documentaryYear=new MyStatisticalBo();
        documentaryYear.setTime("本年度");
        documentaryYear.setType("documentary");
        documentaryYear.setCount(documentaryYearCount);
        list.add(documentaryYear);

        Integer  documentaryLastYearCount=statisticalMapper.quertMyStaDocumentary("上年度");
        MyStatisticalBo  documentaryLastYear=new MyStatisticalBo();
        documentaryLastYear.setTime("上年度");
        documentaryLastYear.setType("documentary");
        documentaryLastYear.setCount(documentaryLastYearCount);
        list.add(documentaryLastYear);

        //合同数
        Integer contractWeekCount=statisticalMapper.queryContractCount("本周");
        MyStatisticalBo contractWeek=new MyStatisticalBo();
        contractWeek.setTime("本周");
        contractWeek.setType("contract");
        contractWeek.setCount(contractWeekCount);
        list.add(contractWeek);

        Integer contractLastWeekCount=statisticalMapper.queryContractCount("上周");
        MyStatisticalBo contractLastWeek=new MyStatisticalBo();
        contractLastWeek.setTime("上周");
        contractLastWeek.setType("contract");
        contractLastWeek.setCount(contractLastWeekCount);
        list.add(contractLastWeek);

        Integer contractMonthCount=statisticalMapper.queryContractCount("本月");
        MyStatisticalBo contractMonth=new MyStatisticalBo();
        contractMonth.setTime("本月");
        contractMonth.setType("contract");
        contractMonth.setCount(contractMonthCount);
        list.add(contractMonth);

        Integer contractLastMonthCount=statisticalMapper.queryContractCount("上月");
        MyStatisticalBo contractLastMonth=new MyStatisticalBo();
        contractLastMonth.setTime("上月");
        contractLastMonth.setType("contract");
        contractLastMonth.setCount(contractLastMonthCount);
        list.add(contractLastMonth);

        Integer contractQuarterCount=statisticalMapper.queryContractCount("本季度");
        MyStatisticalBo contractQuarter=new MyStatisticalBo();
        contractQuarter.setTime("本季度");
        contractQuarter.setType("contract");
        contractQuarter.setCount(contractQuarterCount);
        list.add(contractQuarter);

        Integer contractLastQuarterCount=statisticalMapper.queryContractCount("上季度");
        MyStatisticalBo contractLastQuarter=new MyStatisticalBo();
        contractLastQuarter.setTime("上季度");
        contractLastQuarter.setType("contract");
        contractLastQuarter.setCount(contractLastQuarterCount);
        list.add(contractLastQuarter);

        Integer contractYearCount=statisticalMapper.queryContractCount("本年度");
        MyStatisticalBo contractYear=new MyStatisticalBo();
        contractYear.setTime("本年度");
        contractYear.setType("contract");
        contractYear.setCount(contractYearCount);
        list.add(contractYear);

        Integer  contractLastYearCount=statisticalMapper.queryContractCount("上年度");
        MyStatisticalBo  contractLastYear=new MyStatisticalBo();
        contractLastYear.setTime("上年度");
        contractLastYear.setType("contract");
        contractLastYear.setCount(contractLastYearCount);
        list.add(contractLastYear);
        return list;
    }

    public MsgUtils queryFunnel(String time){
        FunnelBo oneFunnelBo=statisticalMapper.queryFunnel("初期沟通",time);
        if(0!=oneFunnelBo.getCount()){
            oneFunnelBo.setCountPercent(1);
            NumberFormat format = NumberFormat.getPercentInstance();
            format.setMaximumFractionDigits(2);//设置保留几位小数
            System.out.println(oneFunnelBo.getCountPercent());
            oneFunnelBo.setCountp(format.format(oneFunnelBo.getCountPercent()));
        }else {
            oneFunnelBo.setCountPercent(1);
            oneFunnelBo.setCountp("0%");
        }
        if(0!=oneFunnelBo.getMoney()){
            oneFunnelBo.setMoneyPercent(1);
            NumberFormat format = NumberFormat.getPercentInstance();
            format.setMaximumFractionDigits(2);//设置保留几位小数
            oneFunnelBo.setMoneyp(format.format(oneFunnelBo.getMoneyPercent()));
        }else{
            oneFunnelBo.setMoneyPercent(0);
            oneFunnelBo.setMoneyp("0%");
        }

        FunnelBo twoFunnelBo=statisticalMapper.queryFunnel("方案和报价",time);
        if(0!=twoFunnelBo.getCount() && oneFunnelBo.getCount()!=0){
            twoFunnelBo.setCountPercent(twoFunnelBo.getCount()/oneFunnelBo.getCount());
            NumberFormat format = NumberFormat.getPercentInstance();
            format.setMaximumFractionDigits(2);//设置保留几位小数
            twoFunnelBo.setCountp(format.format(twoFunnelBo.getCountPercent()));
        }else{
            twoFunnelBo.setCountPercent(0);
            twoFunnelBo.setCountp("0%");
        }
        if(0!=twoFunnelBo.getMoney() && oneFunnelBo.getMoney()!=0){
            twoFunnelBo.setMoneyPercent(twoFunnelBo.getMoney()/oneFunnelBo.getMoney());
            NumberFormat format = NumberFormat.getPercentInstance();
            format.setMaximumFractionDigits(2);//设置保留几位小数
            twoFunnelBo.setMoneyp(format.format(twoFunnelBo.getMoneyPercent()));
        }else{
             twoFunnelBo.setMoneyp("0%");
        }

        FunnelBo threeFunnelBo=statisticalMapper.queryFunnel("竞争或投标",time);
        if(0!=threeFunnelBo.getCount() && oneFunnelBo.getCount()!=0){
            threeFunnelBo.setCountPercent(threeFunnelBo.getCount()/oneFunnelBo.getCount());
            NumberFormat format = NumberFormat.getPercentInstance();
            format.setMaximumFractionDigits(2);//设置保留几位小数
            threeFunnelBo.setCountp(format.format(threeFunnelBo.getCountPercent()));
        }else{
            threeFunnelBo.setCountPercent(0);
            threeFunnelBo.setCountp("0%");
        }
        if(0!=threeFunnelBo.getMoney() && oneFunnelBo.getMoney()!=0){
            threeFunnelBo.setMoneyPercent(threeFunnelBo.getMoney()/oneFunnelBo.getMoney());
            NumberFormat format = NumberFormat.getPercentInstance();
            format.setMaximumFractionDigits(2);//设置保留几位小数
            threeFunnelBo.setMoneyp(format.format(threeFunnelBo.getMoneyPercent()));
        }else{
            threeFunnelBo.setMoneyp("0%");
        }

        FunnelBo fourFunnelBo=statisticalMapper.queryFunnel("商务谈判",time);
        if(0!=fourFunnelBo.getCount() && oneFunnelBo.getCount()!=0){
            fourFunnelBo.setCountPercent(fourFunnelBo.getCount()/oneFunnelBo.getCount());
            NumberFormat format = NumberFormat.getPercentInstance();
            format.setMaximumFractionDigits(2);//设置保留几位小数
            fourFunnelBo.setCountp(format.format(fourFunnelBo.getCountPercent()));
        }else{
            fourFunnelBo.setCountp("0%");
        }
        if(0!=fourFunnelBo.getMoney() && oneFunnelBo.getMoney()!=0){
            fourFunnelBo.setMoneyPercent(fourFunnelBo.getMoney()/oneFunnelBo.getMoney());
            NumberFormat format = NumberFormat.getPercentInstance();
            format.setMaximumFractionDigits(2);//设置保留几位小数
            fourFunnelBo.setMoneyp(format.format(fourFunnelBo.getMoneyPercent()));
        }else{
            fourFunnelBo.setMoneyp("0%");
        }


        FunnelBo fiveFunnelBo=statisticalMapper.queryFunnel("成交",time);
        if(0!=fiveFunnelBo.getCount() && oneFunnelBo.getCount()!=0){
            fiveFunnelBo.setCountPercent(fiveFunnelBo.getCount()/oneFunnelBo.getCount());
            NumberFormat format = NumberFormat.getPercentInstance();
            format.setMaximumFractionDigits(2);//设置保留几位小数
            fiveFunnelBo.setCountp(format.format(fiveFunnelBo.getCountPercent()));
        }else{
            fiveFunnelBo.setCountp("0%");
        }
        if(0!=fiveFunnelBo.getMoney() && oneFunnelBo.getMoney()!=0){
            fiveFunnelBo.setMoneyPercent(fiveFunnelBo.getMoney()/oneFunnelBo.getMoney());
            NumberFormat format = NumberFormat.getPercentInstance();
            format.setMaximumFractionDigits(2);//设置保留几位小数
            fiveFunnelBo.setMoneyp(format.format(fiveFunnelBo.getMoneyPercent()));
        }else{
            fiveFunnelBo.setMoneyp("0%");
        }


        List<FunnelBo> list=new ArrayList<>();
        list.add(oneFunnelBo);
        list.add(twoFunnelBo);
        list.add(threeFunnelBo);
        list.add(fourFunnelBo);
        list.add(fiveFunnelBo);
        MsgUtils msgUtils=new MsgUtils();
        msgUtils.setCode(0);
        msgUtils.setCount(0);
        msgUtils.setMsg("");
        msgUtils.setData(list);
        return msgUtils;
    }

    public MsgUtils queryTrade(){
        List<TradeBo> list=statisticalMapper.queryBusinessByTrade();
        ArrayList<String> arrayList=new ArrayList<>();
        if(null!=list && list.size()>0){
            for (TradeBo tradeBo:list) {
                arrayList.add(tradeBo.getTrade());
            }
            if(!arrayList.contains("IT|互联网|通信|电子")){
                TradeBo tradeBo1=new TradeBo();
                tradeBo1.setCount(0);
                tradeBo1.setMoney(0);
                tradeBo1.setTrade("IT|互联网|通信|电子");
                list.add(tradeBo1);
            }
            if(!arrayList.contains("房产|建筑建设|物业")){
                TradeBo tradeBo2=new TradeBo();
                tradeBo2.setCount(0);
                tradeBo2.setMoney(0);
                tradeBo2.setTrade("房产|建筑建设|物业");
                list.add(tradeBo2);
            }
            if(!arrayList.contains("管理咨询|教育科研|中介服务")){
                TradeBo tradeBo3=new TradeBo();
                tradeBo3.setCount(0);
                tradeBo3.setMoney(0);
                tradeBo3.setTrade("管理咨询|教育科研|中介服务");
                list.add(tradeBo3);
            }
            if(!arrayList.contains("加工制造|仪表设备")){
                TradeBo tradeBo4=new TradeBo();
                tradeBo4.setCount(0);
                tradeBo4.setMoney(0);
                tradeBo4.setTrade("加工制造|仪表设备");
                list.add(tradeBo4);
            }
            if(!arrayList.contains("金融|银行|保险")){
                TradeBo tradeBo5=new TradeBo();
                tradeBo5.setCount(0);
                tradeBo5.setMoney(0);
                tradeBo5.setTrade("金融|银行|保险");
                list.add(tradeBo5);
            }
            if(!arrayList.contains("酒店旅游")){
                TradeBo tradeBo6=new TradeBo();
                tradeBo6.setCount(0);
                tradeBo6.setMoney(0);
                tradeBo6.setTrade("酒店旅游");
                list.add(tradeBo6);
            }
            if(!arrayList.contains("能源矿产|石油化工")){
                TradeBo tradeBo7=new TradeBo();
                tradeBo7.setCount(0);
                tradeBo7.setMoney(0);
                tradeBo7.setTrade("能源矿产|石油化工");
                list.add(tradeBo7);
            }
            if(!arrayList.contains("消费零售|贸易|交通物流")){
                TradeBo tradeBo8=new TradeBo();
                tradeBo8.setCount(0);
                tradeBo8.setMoney(0);
                tradeBo8.setTrade("消费零售|贸易|交通物流");
                list.add(tradeBo8);
            }
            if(!arrayList.contains("医药生物|医疗保健")){
                TradeBo tradeBo9=new TradeBo();
                tradeBo9.setCount(0);
                tradeBo9.setMoney(0);
                tradeBo9.setTrade("医药生物|医疗保健");
                list.add(tradeBo9);
            }
            if(!arrayList.contains("政府|非赢利机构|科研")){
                TradeBo tradeBo10=new TradeBo();
                tradeBo10.setCount(0);
                tradeBo10.setMoney(0);
                tradeBo10.setTrade("政府|非赢利机构|科研");
                list.add(tradeBo10);
            }
            if(!arrayList.contains("其他")){
                TradeBo tradeBo11=new TradeBo();
                tradeBo11.setCount(0);
                tradeBo11.setMoney(0);
                tradeBo11.setTrade("其他");
                list.add(tradeBo11);
            }
        }
        String str="a";
        Integer num=0;
        ArrayList<TradeBo> arrayList1=new ArrayList<>();
        for (TradeBo tradeBo:list) {
            num+=1;
            tradeBo.setNickname(str+num);
            arrayList1.add(tradeBo);
        }
        MsgUtils msgUtils=new MsgUtils();
        msgUtils.setMsg("");
        msgUtils.setCount(0);
        msgUtils.setCode(0);
        msgUtils.setData(arrayList1);
        return  msgUtils;
    }

    public MsgUtils queryBusinessByOrigin(){
        List<OriginBo> list=statisticalMapper.queryBusinessByOrigin();
        ArrayList<String> arrayList=new ArrayList<>();
        if(null!=list && list.size()>0){
            for (OriginBo originBo:list) {
                arrayList.add(originBo.getOriginname());
            }
            if(!arrayList.contains("电话访问")){
                OriginBo originBo1=new OriginBo();
                originBo1.setCount(0);
                originBo1.setMoney(0);
                originBo1.setOriginname("电话访问");
                list.add(originBo1);
            }
            if(!arrayList.contains("独立开发")){
                OriginBo originBo2=new OriginBo();
                originBo2.setCount(0);
                originBo2.setMoney(0);
                originBo2.setOriginname("独立开发");
                list.add(originBo2);
            }
            if(!arrayList.contains("二次销售")){
                OriginBo originBo3=new OriginBo();
                originBo3.setCount(0);
                originBo3.setMoney(0);
                originBo3.setOriginname("二次销售");
                list.add(originBo3);
            }
            if(!arrayList.contains("合作伙伴")){
                OriginBo originBo4=new OriginBo();
                originBo4.setCount(0);
                originBo4.setMoney(0);
                originBo4.setOriginname("合作伙伴");
                list.add(originBo4);
            }
            if(!arrayList.contains("互联网")){
                OriginBo originBo5=new OriginBo();
                originBo5.setCount(0);
                originBo5.setMoney(0);
                originBo5.setOriginname("互联网");
                list.add(originBo5);
            }
            if(!arrayList.contains("客户介绍")){
                OriginBo originBo6=new OriginBo();
                originBo6.setCount(0);
                originBo6.setMoney(0);
                originBo6.setOriginname("客户介绍");
                list.add(originBo6);
            }
            if(!arrayList.contains("客户来电")){
                OriginBo originBo7=new OriginBo();
                originBo7.setCount(0);
                originBo7.setMoney(0);
                originBo7.setOriginname("客户来电");
                list.add(originBo7);
            }
            if(!arrayList.contains("老客户")){
                OriginBo originBo8=new OriginBo();
                originBo8.setCount(0);
                originBo8.setMoney(0);
                originBo8.setOriginname("老客户");
                list.add(originBo8);
            }
            if(!arrayList.contains("媒体宣传")){
                OriginBo originBo9=new OriginBo();
                originBo9.setCount(0);
                originBo9.setMoney(0);
                originBo9.setOriginname("媒体宣传");
                list.add(originBo9);
            }
        }
        MsgUtils msgUtils=new MsgUtils();
        msgUtils.setMsg("");
        msgUtils.setCount(0);
        msgUtils.setCode(0);
        msgUtils.setData(list);
        return  msgUtils;

    }
    public MsgUtils queryBusinessByTime(String time, Page page){
        IPage<User> iPage=userMapper.selectPage(page,null);
        List<BusinessUserBo> businessUserBoList=new ArrayList<>();
        for (User user:iPage.getRecords()) {
            BusinessUserBo businessUserBo=new BusinessUserBo();
            List<BusinessUserBo> businessWeek=statisticalMapper.queryBusinessByTime(time,user.getUserid());
            businessUserBo.setUsername(user.getUsername());
            businessUserBo.setBusinessWeekCount(businessWeek.size());
            List<BusinessUserBo> businessLastWeek=statisticalMapper.queryBusinessByTime("上周",user.getUserid());
            businessUserBo.setBusinessLastWeekCount(businessLastWeek.size());
            List<BusinessUserBo> successWeek=statisticalMapper.querySuccessByTime(time,user.getUserid());
            businessUserBo.setSuccessWeekCount(successWeek.size());
            List<BusinessUserBo> successLastWeek=statisticalMapper.querySuccessByTime("上周",user.getUserid());
            businessUserBo.setSuccessLastWeekCount(successLastWeek.size());
            List<BusinessUserBo> documentaryWeek=statisticalMapper.queryDocumentaryByTime(time,user.getUserid());
            businessUserBo.setDocumentaryWeekCount(documentaryWeek.size());
            List<BusinessUserBo> documentaryLastWeek=statisticalMapper.queryDocumentaryByTime("上周",user.getUserid());
            businessUserBo.setDocumentaryLastWeekCount(documentaryLastWeek.size());
            List<BusinessUserBo> contractWeek=statisticalMapper.queryContractByTime(time,user.getUsername());
            businessUserBo.setContractWeekCount(contractWeek.size());
            List<BusinessUserBo> contractLastWeek=statisticalMapper.queryContractByTime("上周",user.getUsername());
            businessUserBo.setContractLastWeekCount(contractLastWeek.size());
            businessUserBoList.add(businessUserBo);
        }
        MsgUtils msgUtils=new MsgUtils();
        msgUtils.setMsg("");
        msgUtils.setCount(Integer.parseInt(String.valueOf(iPage.getTotal())));
        msgUtils.setCode(0);
        msgUtils.setData(businessUserBoList);
        return msgUtils;
    }

    public MsgUtils queryBusinessByMonth(String time, Page page){
        IPage<User> iPage=userMapper.selectPage(page,null);
        List<BusinessUserBo> businessUserBoList=new ArrayList<>();
        for (User user:iPage.getRecords()) {
            BusinessUserBo businessUserBo=new BusinessUserBo();
            List<BusinessUserBo> businessWeek=statisticalMapper.queryBusinessByTime(time,user.getUserid());
            businessUserBo.setUsername(user.getUsername());
            businessUserBo.setBusinessWeekCount(businessWeek.size());
            List<BusinessUserBo> businessLastWeek=statisticalMapper.queryBusinessByTime("上月",user.getUserid());
            businessUserBo.setBusinessLastWeekCount(businessLastWeek.size());
            List<BusinessUserBo> successWeek=statisticalMapper.querySuccessByTime(time,user.getUserid());
            businessUserBo.setSuccessWeekCount(successWeek.size());
            List<BusinessUserBo> successLastWeek=statisticalMapper.querySuccessByTime("上月",user.getUserid());
            businessUserBo.setSuccessLastWeekCount(successLastWeek.size());
            List<BusinessUserBo> documentaryWeek=statisticalMapper.queryDocumentaryByTime(time,user.getUserid());
            businessUserBo.setDocumentaryWeekCount(documentaryWeek.size());
            List<BusinessUserBo> documentaryLastWeek=statisticalMapper.queryDocumentaryByTime("上月",user.getUserid());
            businessUserBo.setDocumentaryLastWeekCount(documentaryLastWeek.size());
            List<BusinessUserBo> contractWeek=statisticalMapper.queryContractByTime(time,user.getUsername());
            businessUserBo.setContractWeekCount(contractWeek.size());
            List<BusinessUserBo> contractLastWeek=statisticalMapper.queryContractByTime("上月",user.getUsername());
            businessUserBo.setContractLastWeekCount(contractLastWeek.size());
            businessUserBoList.add(businessUserBo);
        }
        MsgUtils msgUtils=new MsgUtils();
        msgUtils.setMsg("");
        msgUtils.setCount(Integer.parseInt(String.valueOf(iPage.getTotal())));
        msgUtils.setCode(0);
        msgUtils.setData(businessUserBoList);
        return msgUtils;
    }

    public MsgUtils queryBusinessByQuarter(String time, Page page){
        IPage<User> iPage=userMapper.selectPage(page,null);
        List<BusinessUserBo> businessUserBoList=new ArrayList<>();
        for (User user:iPage.getRecords()) {
            BusinessUserBo businessUserBo=new BusinessUserBo();
            List<BusinessUserBo> businessWeek=statisticalMapper.queryBusinessByTime(time,user.getUserid());
            businessUserBo.setUsername(user.getUsername());
            businessUserBo.setBusinessWeekCount(businessWeek.size());
            List<BusinessUserBo> businessLastWeek=statisticalMapper.queryBusinessByTime("上季度",user.getUserid());
            businessUserBo.setBusinessLastWeekCount(businessLastWeek.size());
            List<BusinessUserBo> successWeek=statisticalMapper.querySuccessByTime(time,user.getUserid());
            businessUserBo.setSuccessWeekCount(successWeek.size());
            List<BusinessUserBo> successLastWeek=statisticalMapper.querySuccessByTime("上季度",user.getUserid());
            businessUserBo.setSuccessLastWeekCount(successLastWeek.size());
            List<BusinessUserBo> documentaryWeek=statisticalMapper.queryDocumentaryByTime(time,user.getUserid());
            businessUserBo.setDocumentaryWeekCount(documentaryWeek.size());
            List<BusinessUserBo> documentaryLastWeek=statisticalMapper.queryDocumentaryByTime("上季度",user.getUserid());
            businessUserBo.setDocumentaryLastWeekCount(documentaryLastWeek.size());
            List<BusinessUserBo> contractWeek=statisticalMapper.queryContractByTime(time,user.getUsername());
            businessUserBo.setContractWeekCount(contractWeek.size());
            List<BusinessUserBo> contractLastWeek=statisticalMapper.queryContractByTime("上季度",user.getUsername());
            businessUserBo.setContractLastWeekCount(contractLastWeek.size());
            businessUserBoList.add(businessUserBo);
        }
        MsgUtils msgUtils=new MsgUtils();
        msgUtils.setMsg("");
        msgUtils.setCount(Integer.parseInt(String.valueOf(iPage.getTotal())));
        msgUtils.setCode(0);
        msgUtils.setData(businessUserBoList);
        return msgUtils;
    }

    public MsgUtils queryBusinessByYear(String time, Page page){
        IPage<User> iPage=userMapper.selectPage(page,null);
        List<BusinessUserBo> businessUserBoList=new ArrayList<>();
        for (User user:iPage.getRecords()) {
            BusinessUserBo businessUserBo=new BusinessUserBo();
            List<BusinessUserBo> businessWeek=statisticalMapper.queryBusinessByTime(time,user.getUserid());
            businessUserBo.setUsername(user.getUsername());
            businessUserBo.setBusinessWeekCount(businessWeek.size());
            List<BusinessUserBo> businessLastWeek=statisticalMapper.queryBusinessByTime("上年度",user.getUserid());
            businessUserBo.setBusinessLastWeekCount(businessLastWeek.size());
            List<BusinessUserBo> successWeek=statisticalMapper.querySuccessByTime(time,user.getUserid());
            businessUserBo.setSuccessWeekCount(successWeek.size());
            List<BusinessUserBo> successLastWeek=statisticalMapper.querySuccessByTime("上年度",user.getUserid());
            businessUserBo.setSuccessLastWeekCount(successLastWeek.size());
            List<BusinessUserBo> documentaryWeek=statisticalMapper.queryDocumentaryByTime(time,user.getUserid());
            businessUserBo.setDocumentaryWeekCount(documentaryWeek.size());
            List<BusinessUserBo> documentaryLastWeek=statisticalMapper.queryDocumentaryByTime("上年度",user.getUserid());
            businessUserBo.setDocumentaryLastWeekCount(documentaryLastWeek.size());
            List<BusinessUserBo> contractWeek=statisticalMapper.queryContractByTime(time,user.getUsername());
            businessUserBo.setContractWeekCount(contractWeek.size());
            List<BusinessUserBo> contractLastWeek=statisticalMapper.queryContractByTime("上年度",user.getUsername());
            businessUserBo.setContractLastWeekCount(contractLastWeek.size());
            businessUserBoList.add(businessUserBo);
        }
        MsgUtils msgUtils=new MsgUtils();
        msgUtils.setMsg("");
        msgUtils.setCount(Integer.parseInt(String.valueOf(iPage.getTotal())));
        msgUtils.setCode(0);
        msgUtils.setData(businessUserBoList);
        return msgUtils;
    }
}
