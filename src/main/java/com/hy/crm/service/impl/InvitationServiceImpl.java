package com.hy.crm.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hy.crm.bo.pml.InvitationBo;
import com.hy.crm.mapper.BusinessMapper;
import com.hy.crm.mapper.InvitationMapper;
import com.hy.crm.mapper.ReplyMapper;
import com.hy.crm.mapper.UserMapper;
import com.hy.crm.pojo.Business;
import com.hy.crm.pojo.Invitation;
import com.hy.crm.pojo.User;
import com.hy.crm.service.IInvitationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 帖子讨论表 服务实现类
 * </p>
 *
 * @author zzx
 * @since 2020-08-28
 */
@Service
public class InvitationServiceImpl extends ServiceImpl<InvitationMapper, Invitation> implements IInvitationService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private BusinessMapper businessMapper;
    @Autowired
    private InvitationMapper invitationMapper;
    @Autowired
    private ReplyMapper replyMapper;


    @Override
    public List<InvitationBo> queryInvitation(Page page, String classification,String key) {
        List<Invitation> list=invitationMapper.queryInvitation(page,classification,key);
        List<InvitationBo> listpostExt=new ArrayList<>();
        for(Invitation pos:list){
            Business bus =businessMapper.selectById(pos.getProcessid());
            User use =userMapper.selectById(pos.getUserid());
            Integer replyes=replyMapper.countreply(pos.getInvitationid());
            InvitationBo postExt1=new InvitationBo(pos,bus,use,replyes);
            listpostExt.add(postExt1);
        }
        return listpostExt;
    }

    @Override
    public InvitationBo queryInvitationById(Integer invitationid) {
       return invitationMapper.queryInvitationById(invitationid);
    }
}
