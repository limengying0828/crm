package com.hy.crm.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hy.crm.bo.pml.DocumentaryBo;
import com.hy.crm.pojo.Documentary;

import java.util.List;

/**
 * <p>
 * 跟单表 服务类
 * </p>
 *
 * @author zzx
 * @since 2020-08-28
 */
public interface IDocumentaryService extends IService<Documentary> {

    public List<DocumentaryBo> queryAll(DocumentaryBo documentaryBo, Integer m,Integer n);


    public List<DocumentaryBo> select();
}
