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

    /**
     * 查询所有跟单信息
     * @param documentaryBo
     * @param
     * @param
     * @return
     */
    public List<DocumentaryBo> queryAll(DocumentaryBo documentaryBo);


    public List<DocumentaryBo> select();

    /**
     * 通过跟单主题查询跟单信息
     * @param theme
     * @return
     */
    public List<DocumentaryBo> selectTheme(String theme);

    public DocumentaryBo selectUpdate(String theme);
}
