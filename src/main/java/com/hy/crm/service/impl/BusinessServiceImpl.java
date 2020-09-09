package com.hy.crm.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hy.crm.bo.lmy.ExpectedMoneyBo;
import com.hy.crm.bo.ykz.BusinessBo;
import com.hy.crm.mapper.CustomerMapper;
import com.hy.crm.pojo.*;
import com.hy.crm.mapper.BusinessMapper;
import com.hy.crm.service.*;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    /**
     * //桌面各种状态预计成交金额
     * @return
     */
    @Override
    public List<ExpectedMoneyBo> queryMoney() {
        return businessMapper.queryMoney();
    }

    /**
     * 查商机
     * @param businessname
     * @param todaystate
     * @param userId
     * @param makemoney
     * @param documentarytime
     * @param forum
     * @return
     */
    @Override
    public List<BusinessBo> businessQueryall(IPage<Business> page, String businessname, String todaystate, String userId, String makemoney, String documentarytime, String forum) {
        List<BusinessBo> boList = new ArrayList<>();
        IPage iPage=businessMapper.selectPage(page,null);
        List<Business> list = iPage.getRecords();

        for (Business li : list) {
            BusinessBo businessBo = new BusinessBo();
            Integer buid = li.getBusinessid();
            businessBo.setBusinessid(buid);
            String bname = li.getBusinessname();
            businessBo.setBusinessname(bname);//商机名称
            businessBo.setMakemoney(String.valueOf(li.getMakemoney()));//预计成交金额
            QueryWrapper queryWrapper = new QueryWrapper();
            queryWrapper.eq("businessid", buid);
            List<Busprocess> busprocessList = iBusprocessService.list(queryWrapper);
            for (Busprocess lp : busprocessList) {
                businessBo.setTodaystate(lp.getTodaystate());//商机阶段
            }
            int uid=li.getUserId();
            QueryWrapper queryWrapper1=new QueryWrapper();
            queryWrapper1.eq("userid",uid);
            List<User> listuser=iUserService.list(queryWrapper1);
            for(User lu:listuser){
                businessBo.setUserId(lu.getUsername());//商机负责人
            }
            QueryWrapper queryWrapper2=new QueryWrapper();
            queryWrapper2.eq("processid",buid);
            List<Documentary> documentaryList=iDocumentaryService.list(queryWrapper2);
            for(Documentary ld:documentaryList){
                businessBo.setDocumentarytime(ld.getDocumentarytime());//最后跟单时间
            }
            QueryWrapper queryWrapper3=new QueryWrapper();
            queryWrapper3.eq("processid",buid);
            List<Invitation> invitationList=iInvitationService.list(queryWrapper3);
            businessBo.setForum(String.valueOf(invitationList.size()));//讨论版
            boList.add(businessBo);
        }
        return boList;
    }
}




























/*QueryWrapper queryWrapper5=new QueryWrapper();
        if(businessname !="" && businessname !=null){

        }else if(todaystate !="" && todaystate !=null){

        }else if(userId !="" && userId !=null){

        }else if(makemoney !="" && makemoney!=null ){

        }else if(documentarytime !="" && documentarytime!=null ){

        }else if(forum !="" && forum!=null ){

        }*/