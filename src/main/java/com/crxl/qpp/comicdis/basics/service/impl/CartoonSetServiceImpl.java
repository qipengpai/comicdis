package com.crxl.qpp.comicdis.basics.service.impl;

import com.crxl.qpp.comicdis.basics.dao.CartoonSetMapper;
import com.crxl.qpp.comicdis.basics.entity.Cartoon;
import com.crxl.qpp.comicdis.basics.entity.CartoonSet;
import com.crxl.qpp.comicdis.tool.PageInfo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartoonSetServiceImpl {

    @Autowired
    private CartoonSetMapper cartoonSetMapper;

    /**
     *    查詢漫畫集數列表
     *
     * @author pengpai
     * @date 2018/3/5 15:01
     * @param [pageInfo, cartoonId]
     * @return com.github.pagehelper.Page<com.crxl.qpp.comicdis.basics.entity.CartoonSet>
     */
    @Cacheable(value="CartoonSet",key="#root.methodName.concat(#cartoonId)")
    public List<CartoonSet> getCartoonSetByDistributor(String cartoonId) {
       // PageHelper.startPage(pageInfo.getPageNum(), pageInfo.getPageSize());
        List<CartoonSet> list=cartoonSetMapper.selectCartoonSet(cartoonId);
        System.out.println("缓存");
        return list;
    }
    /**
     *    獲取下一集id
     *
     * @author pengpai
     * @date 2018/3/5 15:43
     * @param [id]
     * @return com.crxl.qpp.comicdis.basics.entity.CartoonSet
     */
    @Cacheable(value="CartoonSet",key="#root.methodName.concat(#id)")
    public CartoonSet getNextCartoonSetId(String id) {
        CartoonSet cartoonSet= cartoonSetMapper.selectByPrimaryKey(id);
        if (cartoonSet==null)
            return cartoonSet;
        return  cartoonSetMapper.selectBySort(cartoonSet.getCartoonid(),cartoonSet.getSort()+1);
    }
}
