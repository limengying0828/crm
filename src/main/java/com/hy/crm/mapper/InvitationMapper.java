package com.hy.crm.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hy.crm.bo.pml.InvitationBo;
import com.hy.crm.bo.pml.SqlDocumentary;
import com.hy.crm.pojo.Invitation;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * <p>
 * 帖子讨论表 Mapper 接口
 * </p>
 *
 * @author zzx
 * @since 2020-08-28
 */
public interface InvitationMapper extends BaseMapper<Invitation> {

    @SelectProvider(type = SqlDocumentary.class,method = "queryInvitation")
    List<Invitation> queryInvitation(@Param("page") IPage page , @Param("classification")String classification, @Param("key")String key);

    @Select("select * from invitation where invitationid=#{invitationid}")
    InvitationBo queryInvitationById(Integer invitationid);
}
