package com.hy.crm.mapper;

import com.hy.crm.pojo.Reply;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 帖子回复表 Mapper 接口
 * </p>
 *
 * @author zzx
 * @since 2020-08-28
 */
public interface ReplyMapper extends BaseMapper<Reply> {

    @Select("select count(*) from reply where invitationid=#{value}")
    Integer countreply(Integer replyid);

    @Select("select * from reply where invitationid=#{invitationid}")
    List<Reply> queryIdByInvitationid(Integer invitationid);
}
