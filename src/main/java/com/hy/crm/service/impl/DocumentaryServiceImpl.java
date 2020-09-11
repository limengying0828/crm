package com.hy.crm.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hy.crm.bo.pml.DocumentaryBo;
import com.hy.crm.bo.pml.DocumentaryBos;
import com.hy.crm.mapper.BusinessMapper;
import com.hy.crm.mapper.DocumentaryMapper;
import com.hy.crm.mapper.UserMapper;
import com.hy.crm.pojo.Business;
import com.hy.crm.pojo.Documentary;
import com.hy.crm.pojo.User;
import com.hy.crm.service.IDocumentaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    @Autowired
    private BusinessMapper businessMapper;

    @Autowired
    private UserMapper userMapper;

    /**
     * 查询全部跟单
     * @param
     * @param
     * @param
     * @return
     */
   /* @Override
    public List<DocumentaryBo> queryAll(String classification,String key,Integer page,Integer limit) {
        return documentaryMapper.queryAll(classification,key,page,limit);
    }
*/
    @Override
    public List<DocumentaryBos> queryAllDoc(String classification,String key,Integer page,Integer limit) {
        List<Documentary> documentaryList=documentaryMapper.queryAllDoc(classification,key,page,limit);
        List<DocumentaryBos> documentaryBosList=new ArrayList<>();
        for (Documentary doc:documentaryList) {
            Business bus =businessMapper.selectById(doc.getProcessid());
            User use =userMapper.selectById(doc.getUserid());
            DocumentaryBos bos=new DocumentaryBos(doc,use,bus);
            documentaryBosList.add(bos);
        		}
        return documentaryBosList;
    }

    @Override
    public List<DocumentaryBo> select(){
       return documentaryMapper.query();
    }

    @Override
    public List<DocumentaryBo> selectTheme(String theme) {
        return documentaryMapper.selectTheme(theme);
    }

    @Override
    public DocumentaryBo selectUpdate(String theme) {
        return documentaryMapper.selectUpdate(theme);
    }

    @Override
    public List<DocumentaryBo> queryAllMy(String classification, String key, Integer page, Integer limit, Integer userid) {
        return documentaryMapper.queryAllMy(classification,key,page,limit,userid);
    }

    @Override
    public List<DocumentaryBos> queryAllMyDoc(String classification, String key, Integer page, Integer limit, Integer userid) {
        List<Documentary> documentaryList=documentaryMapper.queryAllMyDoc(classification,key,page,limit,userid);
        List<DocumentaryBos> documentaryBosList=new ArrayList<>();
        for (Documentary doc:documentaryList) {
            Business bus =businessMapper.selectById(doc.getProcessid());
            User use =userMapper.selectById(doc.getUserid());
            DocumentaryBos bos=new DocumentaryBos(doc,use,bus);
            documentaryBosList.add(bos);
        }
        return documentaryBosList;
    }


}
