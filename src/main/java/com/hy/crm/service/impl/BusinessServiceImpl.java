package com.hy.crm.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hy.crm.bo.lmy.ExpectedMoneyBo;
import com.hy.crm.bo.ykz.BusinessBo;
import com.hy.crm.mapper.BusprocessMapper;
import com.hy.crm.mapper.CustomerMapper;
import com.hy.crm.pojo.*;
import com.hy.crm.mapper.BusinessMapper;
import com.hy.crm.service.*;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mysql.jdbc.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 商机表 服务实现类
 * </p>
 *
 * @author zzx
 * @since 2020-08-28
 */
@Service
public class BusinessServiceImpl extends ServiceImpl<BusinessMapper, Business> implements IBusinessService {
    @Autowired
    private BusinessMapper businessMapper;

    @Autowired
    private CustomerMapper customerMapper;

    @Autowired
    private IBusinessService iBusinessService;

    @Autowired
    private IBusprocessService iBusprocessService;

    @Autowired
    private IUserService iUserService;

    @Autowired
    private IDocumentaryService iDocumentaryService;

    @Autowired
    private IInvitationService iInvitationService;

    @Autowired
    private BusprocessMapper busprocessMapper;

    /**
     * //桌面各种状态预计成交金额
     * @return
     */
    @Override
    public List<ExpectedMoneyBo> queryMoney() {
        return businessMapper.queryMoney();
    }

    /**
     * 查全部商机
     * @param businessname
     * @param todaystate
     * @param userId
     * @param makemoney
     * @param overdate
     * @param post
     * @return
     */
    @Override
    public List<BusinessBo> businessQueryall(IPage<Business> page, String businessname, String todaystate, String userId, String makemoney, String overdate, String post,String status) {
        QueryWrapper queryWrapper5=new QueryWrapper();

        if(!StringUtils.isNullOrEmpty(businessname) || !StringUtils.isNullOrEmpty(businessname)){
            queryWrapper5.like("businessname",businessname);
        }
        /*if(StringUtils.isNullOrEmpty(todaystate) || StringUtils.isNullOrEmpty(todaystate)){
            queryWrapper5.like("todaystate",todaystate);
        }*/
        if(!StringUtils.isNullOrEmpty(userId) || !StringUtils.isNullOrEmpty(userId)){
            queryWrapper5.eq("userId",userId);
        }
        if(!StringUtils.isNullOrEmpty(makemoney) || !StringUtils.isNullOrEmpty(makemoney)){
            queryWrapper5.like("makemoney",makemoney);
        }
        if(!StringUtils.isNullOrEmpty(overdate) || !StringUtils.isNullOrEmpty(overdate)){
            queryWrapper5.eq("overdate",overdate);
        }
        if(!StringUtils.isNullOrEmpty(post) || !StringUtils.isNullOrEmpty(post)){
            queryWrapper5.like("post",post);
        }

        IPage iPage=null;
        if(queryWrapper5==null){
            if(!StringUtils.isNullOrEmpty(status) && status.equals("本周")){
                queryWrapper5.apply("YEARWEEK(date_format(addbusinesstime,'%Y-%m-%d'),-1) = YEARWEEK(date_format(NOW(),'%Y-%m-%d'))");
                iPage=businessMapper.selectPage(page,queryWrapper5);
            }else if(!StringUtils.isNullOrEmpty(status) && status.equals("上周")){
                queryWrapper5.apply("YEARWEEK(date_format(addbusinesstime,'%Y-%m-%d'),1) = YEARWEEK(date_format(NOW(),'%Y-%m-%d'))");
                iPage=businessMapper.selectPage(page,queryWrapper5);
            }else if(!StringUtils.isNullOrEmpty(status) && status.equals("本月")){
                queryWrapper5.apply("DATE_FORMAT(addbusinesstime, '%Y%m' ) = DATE_FORMAT( CURDATE( ) , '%Y%m' )");
                iPage=businessMapper.selectPage(page,queryWrapper5);
            }else if(!StringUtils.isNullOrEmpty(status) && status.equals("上月")){
                queryWrapper5.apply("PERIOD_DIFF( date_format( now( ) , '%Y%m' ) , date_format( addbusinesstime, '%Y%m' ) ) =1");
                iPage=businessMapper.selectPage(page,queryWrapper5);
            }else if(!StringUtils.isNullOrEmpty(status) && status.equals("本季")){
                queryWrapper5.apply("QUARTER(addbusinesstime)=QUARTER(now()) and  year(addbusinesstime)=year(now())");
                iPage=businessMapper.selectPage(page,queryWrapper5);
            }else if(!StringUtils.isNullOrEmpty(status) && status.equals("上季")){
                queryWrapper5.apply("QUARTER(addbusinesstime)=QUARTER(DATE_SUB(now(),interval 1 QUARTER)) and  YEAR (addbusinesstime)=YEAR(DATE_SUB(now(),interval 1 QUARTER))");
                iPage=businessMapper.selectPage(page,queryWrapper5);
            }else if(!StringUtils.isNullOrEmpty(status) && status.equals("成交")){

                iPage=businessMapper.selectPage(page,queryWrapper5);
            }else if(!StringUtils.isNullOrEmpty(status) && status.equals("丢单")){

                iPage=businessMapper.selectPage(page,queryWrapper5);
            }else if(!StringUtils.isNullOrEmpty(status) && status.equals("搁置")){

                iPage=businessMapper.selectPage(page,queryWrapper5);
            }else{
                iPage=businessMapper.selectPage(page,null);
            }
        }else{
            if(!StringUtils.isNullOrEmpty(status) && status.equals("本周")){
                queryWrapper5.apply("YEARWEEK(date_format(addbusinesstime,'%Y-%m-%d'),-1) = YEARWEEK(date_format(NOW(),'%Y-%m-%d'))");
                iPage=businessMapper.selectPage(page,queryWrapper5);
            }else if(!StringUtils.isNullOrEmpty(status) && status.equals("上周")){
                queryWrapper5.apply("YEARWEEK(date_format(addbusinesstime,'%Y-%m-%d'),1) = YEARWEEK(date_format(NOW(),'%Y-%m-%d'))");
                iPage=businessMapper.selectPage(page,queryWrapper5);
            }else if(!StringUtils.isNullOrEmpty(status) && status.equals("本月")){
                queryWrapper5.apply("DATE_FORMAT(addbusinesstime, '%Y%m' ) = DATE_FORMAT( CURDATE( ) , '%Y%m' )");
                iPage=businessMapper.selectPage(page,queryWrapper5);
            }else if(!StringUtils.isNullOrEmpty(status) && status.equals("上月")){
                queryWrapper5.apply("PERIOD_DIFF( date_format( now( ) , '%Y%m' ) , date_format( addbusinesstime, '%Y%m' ) ) =1");
                iPage=businessMapper.selectPage(page,queryWrapper5);
            }else if(!StringUtils.isNullOrEmpty(status) && status.equals("本季")){
                queryWrapper5.apply("QUARTER(addbusinesstime)=QUARTER(now()) and  year(addbusinesstime)=year(now())");
                iPage=businessMapper.selectPage(page,queryWrapper5);
            }else if(!StringUtils.isNullOrEmpty(status) && status.equals("上季")){
                queryWrapper5.apply("QUARTER(addbusinesstime)=QUARTER(DATE_SUB(now(),interval 1 QUARTER)) and  YEAR (addbusinesstime)=YEAR(DATE_SUB(now(),interval 1 QUARTER))");
                iPage=businessMapper.selectPage(page,queryWrapper5);
            }else if(!StringUtils.isNullOrEmpty(status) && status.equals("成交")){

                iPage=businessMapper.selectPage(page,queryWrapper5);
            }else if(!StringUtils.isNullOrEmpty(status) && status.equals("丢单")){

                iPage=businessMapper.selectPage(page,queryWrapper5);
            }else if(!StringUtils.isNullOrEmpty(status) && status.equals("搁置")){

                iPage=businessMapper.selectPage(page,queryWrapper5);
            }else{
                iPage=businessMapper.selectPage(page,queryWrapper5);
            }
        }
        List<BusinessBo> boList = new ArrayList<>();
        List<Business> list = iPage.getRecords();
        for (Business li : list) {
            BusinessBo businessBo = new BusinessBo();
            Integer buid = li.getBusinessid();
            businessBo.setBusinessid(buid);
            String bname = li.getBusinessname();
            businessBo.setBusinessname(bname);//商机名称
            if(li.getMakemoney()!=null && li.getMakemoney()!=0){
                businessBo.setMakemoney(Float.parseFloat(String.valueOf(li.getMakemoney())));//预计成交金额
            }else{
                businessBo.setMakemoney(0.0f);
            }
            Busprocess busprocess=new Busprocess();
            busprocess.setBusinessid(buid);
            Busprocess busprocess1=busprocessMapper.seltodaystate(busprocess);
            businessBo.setTodaystate(busprocess1.getTodaystate());//商机阶段

            int uid=li.getUserId();
            QueryWrapper queryWrapper1=new QueryWrapper();
            queryWrapper1.eq("userid",uid);
            List<User> listuser=iUserService.list(queryWrapper1);
            for(User lu:listuser){
                businessBo.setUserId(lu.getUsername());//商机负责人
            }

            Documentary documentary=new Documentary();
            documentary.setProcessid(buid);
            Documentary documentary1=busprocessMapper.seldocumentarytime(documentary);
            if(documentary1==null){
                businessBo.setDocumentarytime("");
            }else{
                businessBo.setDocumentarytime(documentary1.getDocumentarytime());//最后跟单时间
            }


            QueryWrapper queryWrapper3=new QueryWrapper();
            queryWrapper3.eq("processid",buid);
            List<Invitation> invitationList=iInvitationService.list(queryWrapper3);
            businessBo.setForum(invitationList.size());//讨论版
            boList.add(businessBo);
        }
        return boList;
    }





    /**
     * 查我的商机
     * @param businessname
     * @param todaystate
     * @param userId
     * @param makemoney
     * @param overdate
     * @param post
     * @return
     */
    @Override
    public List<BusinessBo> mybusinessQueryall(IPage<Business> page, String businessname, String todaystate, String userId, String makemoney, String overdate, String post, String status, HttpServletRequest request) {
        QueryWrapper queryWrapper5=new QueryWrapper();

        if(!StringUtils.isNullOrEmpty(businessname) || !StringUtils.isNullOrEmpty(businessname)){
            queryWrapper5.like("businessname",businessname);
        }
        /*if(StringUtils.isNullOrEmpty(todaystate) || StringUtils.isNullOrEmpty(todaystate)){
            queryWrapper5.like("todaystate",todaystate);
        }*/
        if(!StringUtils.isNullOrEmpty(userId) || !StringUtils.isNullOrEmpty(userId)){
            queryWrapper5.eq("userId",userId);
        }
        if(!StringUtils.isNullOrEmpty(makemoney) || !StringUtils.isNullOrEmpty(makemoney)){
            queryWrapper5.like("makemoney",makemoney);
        }
        if(!StringUtils.isNullOrEmpty(overdate) || !StringUtils.isNullOrEmpty(overdate)){
            queryWrapper5.eq("overdate",overdate);
        }
        if(!StringUtils.isNullOrEmpty(post) || !StringUtils.isNullOrEmpty(post)){
            queryWrapper5.like("post",post);
        }

        HttpSession session=request.getSession();
        User user=(User)session.getAttribute("user");
        queryWrapper5.eq("userid",user.getUserid());

        IPage iPage=null;
        if(queryWrapper5==null){
            if(!StringUtils.isNullOrEmpty(status) && status.equals("本周")){
                queryWrapper5.apply("YEARWEEK(date_format(addbusinesstime,'%Y-%m-%d'),-1) = YEARWEEK(date_format(NOW(),'%Y-%m-%d'))");
                iPage=businessMapper.selectPage(page,queryWrapper5);
            }else if(!StringUtils.isNullOrEmpty(status) && status.equals("上周")){
                queryWrapper5.apply("YEARWEEK(date_format(addbusinesstime,'%Y-%m-%d'),1) = YEARWEEK(date_format(NOW(),'%Y-%m-%d'))");
                iPage=businessMapper.selectPage(page,queryWrapper5);
            }else if(!StringUtils.isNullOrEmpty(status) && status.equals("本月")){
                queryWrapper5.apply("DATE_FORMAT(addbusinesstime, '%Y%m' ) = DATE_FORMAT( CURDATE( ) , '%Y%m' )");
                iPage=businessMapper.selectPage(page,queryWrapper5);
            }else if(!StringUtils.isNullOrEmpty(status) && status.equals("上月")){
                queryWrapper5.apply("PERIOD_DIFF( date_format( now( ) , '%Y%m' ) , date_format( addbusinesstime, '%Y%m' ) ) =1");
                iPage=businessMapper.selectPage(page,queryWrapper5);
            }else if(!StringUtils.isNullOrEmpty(status) && status.equals("本季")){
                queryWrapper5.apply("QUARTER(addbusinesstime)=QUARTER(now()) and  year(addbusinesstime)=year(now())");
                iPage=businessMapper.selectPage(page,queryWrapper5);
            }else if(!StringUtils.isNullOrEmpty(status) && status.equals("上季")){
                queryWrapper5.apply("QUARTER(addbusinesstime)=QUARTER(DATE_SUB(now(),interval 1 QUARTER)) and  YEAR (addbusinesstime)=YEAR(DATE_SUB(now(),interval 1 QUARTER))");
                iPage=businessMapper.selectPage(page,queryWrapper5);
            }else if(!StringUtils.isNullOrEmpty(status) && status.equals("成交")){
                iPage=businessMapper.selectPage(page,queryWrapper5);
            }else if(!StringUtils.isNullOrEmpty(status) && status.equals("丢单")){
                iPage=businessMapper.selectPage(page,queryWrapper5);
            }else if(!StringUtils.isNullOrEmpty(status) && status.equals("搁置")){
                iPage=businessMapper.selectPage(page,queryWrapper5);
            }else{
                iPage=businessMapper.selectPage(page,null);
            }
        }else{
            if(!StringUtils.isNullOrEmpty(status) && status.equals("本周")){
                queryWrapper5.apply("YEARWEEK(date_format(addbusinesstime,'%Y-%m-%d'),-1) = YEARWEEK(date_format(NOW(),'%Y-%m-%d'))");
                iPage=businessMapper.selectPage(page,queryWrapper5);
            }else if(!StringUtils.isNullOrEmpty(status) && status.equals("上周")){
                queryWrapper5.apply("YEARWEEK(date_format(addbusinesstime,'%Y-%m-%d'),1) = YEARWEEK(date_format(NOW(),'%Y-%m-%d'))");
                iPage=businessMapper.selectPage(page,queryWrapper5);
            }else if(!StringUtils.isNullOrEmpty(status) && status.equals("本月")){
                queryWrapper5.apply("DATE_FORMAT(addbusinesstime, '%Y%m' ) = DATE_FORMAT( CURDATE( ) , '%Y%m' )");
                iPage=businessMapper.selectPage(page,queryWrapper5);
            }else if(!StringUtils.isNullOrEmpty(status) && status.equals("上月")){
                queryWrapper5.apply("PERIOD_DIFF( date_format( now( ) , '%Y%m' ) , date_format( addbusinesstime, '%Y%m' ) ) =1");
                iPage=businessMapper.selectPage(page,queryWrapper5);
            }else if(!StringUtils.isNullOrEmpty(status) && status.equals("本季")){
                queryWrapper5.apply("QUARTER(addbusinesstime)=QUARTER(now()) and  year(addbusinesstime)=year(now())");
                iPage=businessMapper.selectPage(page,queryWrapper5);
            }else if(!StringUtils.isNullOrEmpty(status) && status.equals("上季")){
                queryWrapper5.apply("QUARTER(addbusinesstime)=QUARTER(DATE_SUB(now(),interval 1 QUARTER)) and  YEAR (addbusinesstime)=YEAR(DATE_SUB(now(),interval 1 QUARTER))");
                iPage=businessMapper.selectPage(page,queryWrapper5);
            }else if(!StringUtils.isNullOrEmpty(status) && status.equals("成交")){
                iPage=businessMapper.selectPage(page,queryWrapper5);
            }else if(!StringUtils.isNullOrEmpty(status) && status.equals("丢单")){
                iPage=businessMapper.selectPage(page,queryWrapper5);
            }else if(!StringUtils.isNullOrEmpty(status) && status.equals("搁置")){
                iPage=businessMapper.selectPage(page,queryWrapper5);
            }else{
                iPage=businessMapper.selectPage(page,queryWrapper5);
            }
        }
        List<BusinessBo> boList = new ArrayList<>();
        List<Business> list = iPage.getRecords();
        for (Business li : list) {
            BusinessBo businessBo = new BusinessBo();
            Integer buid = li.getBusinessid();
            businessBo.setBusinessid(buid);
            String bname = li.getBusinessname();
            businessBo.setBusinessname(bname);//商机名称
            if(li.getMakemoney()!=null && li.getMakemoney()!=0){
                businessBo.setMakemoney(Float.parseFloat(String.valueOf(li.getMakemoney())));//预计成交金额
            }else{
                businessBo.setMakemoney(0.0f);
            }

            Busprocess busprocess=new Busprocess();
            busprocess.setBusinessid(buid);
            Busprocess busprocess1=busprocessMapper.seltodaystate(busprocess);
            businessBo.setTodaystate(busprocess1.getTodaystate());//商机阶段

            int uid=li.getUserId();
            QueryWrapper queryWrapper1=new QueryWrapper();
            queryWrapper1.eq("userid",uid);
            List<User> listuser=iUserService.list(queryWrapper1);
            for(User lu:listuser){
                businessBo.setUserId(lu.getUsername());//商机负责人
            }

            Documentary documentary=new Documentary();
            documentary.setProcessid(buid);
            Documentary documentary1=busprocessMapper.seldocumentarytime(documentary);
            if(documentary1==null){
                businessBo.setDocumentarytime("");
            }else{
                businessBo.setDocumentarytime(documentary1.getDocumentarytime());//最后跟单时间
            }


            QueryWrapper queryWrapper3=new QueryWrapper();
            queryWrapper3.eq("processid",buid);
            List<Invitation> invitationList=iInvitationService.list(queryWrapper3);
            businessBo.setForum(invitationList.size());//讨论版
            boList.add(businessBo);
        }
        return boList;
    }
}
