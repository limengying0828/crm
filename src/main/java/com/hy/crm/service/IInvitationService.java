package com.hy.crm.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hy.crm.bo.pml.InvitationBo;
import com.hy.crm.pojo.Invitation;

import java.util.List;

/**
 * <p>
 * 帖子讨论表 服务类
 * </p>
 *
 * @author zzx
 * @since 2020-08-28
 */
public interface IInvitationService extends IService<Invitation> {
    public List<InvitationBo> queryInvitation(Page page, String classification, String key);

    InvitationBo queryInvitationById(Integer invitationid);
}
