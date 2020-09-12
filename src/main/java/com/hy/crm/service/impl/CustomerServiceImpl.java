package com.hy.crm.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hy.crm.bo.ykz.BusinessBo;
import com.hy.crm.bo.ykz.CbcaBo;
import com.hy.crm.mapper.BusinessMapper;
import com.hy.crm.mapper.BusprocessMapper;
import com.hy.crm.pojo.*;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hy.crm.bo.ykz.CbcaBo;
import com.hy.crm.mapper.CustomerMapper;
import com.hy.crm.pojo.*;
import com.hy.crm.service.*;
import com.mysql.jdbc.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 客户表 服务实现类
 * </p>
 *
 * @author zzx
 * @since 2020-08-28
 */
@Service
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper, Customer> implements ICustomerService {

    @Autowired
    private CustomerMapper customerMapper;

    @Autowired
    private IBusinessService iBusinessService;

    @Autowired
    private IContractService iContractService;

    @Autowired
    private IAftersaleService iAftersaleService;

    @Autowired
    private IRemitsService iRemitsService;

    /**
     * 查询所有
     * @return
     * RowBounds rowBounds
     */
    @Override
    public List<CbcaBo> queryAll(IPage<Customer> page, String condition,String keyword,String customerclass){
        List<CbcaBo> list1=new ArrayList<>();
        QueryWrapper queryWrapper=new QueryWrapper();
        List<Customer> list=null;
        if(StringUtils.isNullOrEmpty(condition) || StringUtils.isNullOrEmpty(keyword)){
            if(!StringUtils.isNullOrEmpty(customerclass)){
                queryWrapper.eq("customerclass",customerclass);
                IPage iPage=customerMapper.selectPage(page,queryWrapper);//查询所有
                list=iPage.getRecords();
            }else {
                IPage iPage=customerMapper.selectPage(page,null);//查询所有
                list=iPage.getRecords();
            }
        }else {
            if(StringUtils.isNullOrEmpty(customerclass)){
                queryWrapper.like(condition,keyword);
                IPage iPage=customerMapper.selectPage(page,queryWrapper);
                list=iPage.getRecords();
            }else{
                queryWrapper.eq("customerclass",customerclass);
                queryWrapper.like(condition,keyword);
                IPage iPage=customerMapper.selectPage(page,queryWrapper);//查询所有
                list=iPage.getRecords();
            }
        }
        CbcaBo cbcaBo=null;
        for(Customer lid:list){
            cbcaBo=new CbcaBo();
            int cuid=lid.getCustomerid();
            String cuname=lid.getCustomername();
            //拿到客户id,根据客户id去商机表查询有几条商机
            QueryWrapper queryWrapper1=new QueryWrapper();
            queryWrapper1.eq("customerid",cuid);
            List<Business> listbusiness=iBusinessService.list(queryWrapper1);
            int businessNumber=listbusiness.size();
            Float feta = 0.0f;
            for(Business lb:listbusiness){
                if(lb.getMakemoney() !=null && lb.getMakemoney()!=0){
                    feta +=lb.getMakemoney();
                }else{
                    feta = 0.0f;
                }
            }
            cbcaBo.setExpectedTransactionAmount(feta);//预计成交金额
            //拿到客户id,根据客户id去合同表查询有几条合同
            QueryWrapper queryWrapper2=new QueryWrapper();
            queryWrapper2.eq("customername",cuname);
            List<Contract> listcontract=iContractService.list(queryWrapper2);

            int contractNumber=listcontract.size();
            Float con=0.0f;
            Float rem=0.0f;
            for(Contract lc:listcontract){
                con+=lc.getContractmoney();
            }
            cbcaBo.setContractmoney(con);//合同金额

            /*
            * 查回款额
            * */
            for (Contract lct:listcontract) {
                String contractid=lct.getContractid();
                QueryWrapper queryWrapper4=new QueryWrapper();
                queryWrapper4.eq("contractid",contractid);
                List<Remits> listremist=iRemitsService.list(queryWrapper4);
                for(Remits lr:listremist){
                    rem+=lr.getIncomemoney();
                }
            }
            cbcaBo.setReturned(rem);//回款额
            //拿到客户id,根据客户id去售后服务表查询有几条售后服务
            QueryWrapper queryWrapper3=new QueryWrapper();
            queryWrapper3.eq("customerid",cuid);
            List<Aftersale> listaftersale=iAftersaleService.list(queryWrapper3);
            int aftersaleNumbre=listaftersale.size();
            Float score=0.0f;
            Float score1=0.0f;
            for(Aftersale lf:listaftersale){
                if(StringUtils.isNullOrEmpty(lf.getServicesscore())){
                    score1=0.0f;
                }else{
                    score+=Float.parseFloat(lf.getServicesscore());
                    score1=Float.parseFloat(String.valueOf(score/aftersaleNumbre));
                }
            }
            cbcaBo.setCustomerid(cuid);
            cbcaBo.setCustomername(cuname);
            cbcaBo.setBusinessNumber(businessNumber);
            cbcaBo.setContractNumber(contractNumber);
            cbcaBo.setAftersaleNumbre(aftersaleNumbre);
            cbcaBo.setAverage(score1);
            list1.add(cbcaBo);
        }
        return list1;
    }


    @Override
    public Customer queryAllByName(String customername) {
        return customerMapper.queryAllByName(customername);
    }

}
