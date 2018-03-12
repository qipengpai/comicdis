package com.crxl.qpp.comicdis.basics.service.impl;

import com.crxl.qpp.comicdis.basics.dao.CartoonPhotoMapper;
import com.crxl.qpp.comicdis.basics.dao.CartoonSetMapper;
import com.crxl.qpp.comicdis.basics.entity.CartoonPhoto;
import com.crxl.qpp.comicdis.basics.entity.CartoonSet;
import com.crxl.qpp.comicdis.basics.entity.data.CartoonPhotoData;
import com.crxl.qpp.comicdis.basics.entity.data.CartoonPhotoVo;
import com.crxl.qpp.comicdis.tool.PageInfo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartoonPhotoServiceImpl {

    @Autowired
    private CartoonPhotoMapper cartoonPhotoMapper;

    /**
     *    獲取漫畫图片
     *
     * @author pengpai
     * @date 2018/3/8 17:39
     * @param [cartoonPhotoData]
     * @return java.util.List<com.crxl.qpp.comicdis.basics.entity.CartoonPhoto>
     */
    @Cacheable(value = "CartoonPhoto", key = "#root.methodName.concat(#cartoonPhotoData.cartoonid).concat(#cartoonPhotoData.cartoonsetid)")
    public List<CartoonPhoto> getCartoonPhotoByDistributor(CartoonPhotoData cartoonPhotoData) {
        return cartoonPhotoMapper.selectCartoonPhotoByDistributor(cartoonPhotoData.getCartoonid(), cartoonPhotoData.getCartoonsetid());
    }

    /**
     * 生成推广文案
     *
     * @param [pageInfo, cartoonPhotoData]
     * @return com.github.pagehelper.Page<com.crxl.qpp.comicdis.basics.entity.CartoonPhoto>
     * @author pengpai
     * @date 2018/3/5 18:09
     */
    @Cacheable(value = "CartoonPhoto",key="#root.methodName.concat(#cartoonPhotoData.cartoonid).concat(#cartoonPhotoData.getSort())")
    public List<CartoonPhoto> generateCover(CartoonPhotoData cartoonPhotoData) {
        List<CartoonPhoto> list = cartoonPhotoMapper.generateCover(cartoonPhotoData.getCartoonid(), Integer.parseInt(cartoonPhotoData.getSort()) + 1);
        return list;
    }
}
