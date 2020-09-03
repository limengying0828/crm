package com.hy.crm.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hy.crm.bo.pml.DocumentaryBo;
import com.hy.crm.mapper.DocumentaryMapper;
import com.hy.crm.pojo.Documentary;
import com.hy.crm.service.IDocumentaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 跟单表 服务实现类
 * </p>
 *
 * @author zzx
 * @since 2020-08-28
 */
@Service
public class DocumentaryServiceImpl extends ServiceImpl<DocumentaryMapper, Documentary> implements IDocumentaryService {

    @Autowired
    private DocumentaryMapper documentaryMapper;

    /**
     * 查询全部跟单
     * @param documentaryBo
     * @param m
     * @param n
     * @return
     */
    @Override
    public List<DocumentaryBo> queryAll(DocumentaryBo documentaryBo, Integer m,Integer n) {
        return documentaryMapper.queryAll(documentaryBo,m,n);
    }

    @Override
    public List<DocumentaryBo> select(){
       return documentaryMapper.query();
    };

}
