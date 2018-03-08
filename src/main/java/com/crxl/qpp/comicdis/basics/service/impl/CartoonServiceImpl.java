package com.crxl.qpp.comicdis.basics.service.impl;

import com.crxl.qpp.comicdis.basics.dao.CartoonMapper;
import com.crxl.qpp.comicdis.basics.entity.Cartoon;
import com.crxl.qpp.comicdis.tool.PageInfo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartoonServiceImpl {

    @Autowired
    private CartoonMapper cartoonMapper;

    /**
     *    查询漫画列表
     *
     * @author pengpai
     * @date 2018/3/5 13:39
     * @param [pageInfo]
     * @return com.github.pagehelper.Page<com.crxl.qpp.comicdis.basics.entity.Cartoon>
     */
    public  Page<Cartoon> getCartoonByDistributor(PageInfo pageInfo) {
        PageHelper.startPage(pageInfo.getPageNum(), pageInfo.getPageSize());
        return cartoonMapper.selectCartoon(pageInfo);
    }

    /**
     *   主鍵查詢漫畫
     *
     * @author pengpai
     * @date 2018/3/8 11:52
     * @param [cartoonid]
     * @return com.crxl.qpp.comicdis.basics.entity.Cartoon
     */
    public Cartoon getById(String cartoonid) {
        return cartoonMapper.selectById(cartoonid);
    }
}
