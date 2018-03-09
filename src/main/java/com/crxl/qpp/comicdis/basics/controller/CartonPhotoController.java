package com.crxl.qpp.comicdis.basics.controller;


import com.crxl.qpp.comicdis.basics.entity.CartoonPhoto;
import com.crxl.qpp.comicdis.basics.entity.data.CartoonPhotoData;
import com.crxl.qpp.comicdis.basics.entity.data.CartoonPhotoVo;
import com.crxl.qpp.comicdis.basics.service.impl.CartoonPhotoServiceImpl;
import com.crxl.qpp.comicdis.system.ActionUrl;
import com.crxl.qpp.comicdis.tool.Model;
import com.crxl.qpp.comicdis.tool.PageInfo;
import com.crxl.qpp.comicdis.tool.ParaClick;
import com.github.pagehelper.Page;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CartonPhotoController {

    @Autowired
    private CartoonPhotoServiceImpl cartoonPhotoServiceImpl;

    /**
     *    獲取漫畫图片
     *
     * @author pengpai
     * @date 2018/3/5 17:31
     * @param [pageInfo, cartoonPhotoData]
     * @return com.crxl.qpp.comicdis.tool.Model
     */
    @RequestMapping(value = ActionUrl.DISTRIBUTOR_GET_CARTOONPHOTO, method = RequestMethod.POST)
    @RequiresAuthentication
    public Model getCartoonPhotoByDistributor(CartoonPhotoData cartoonPhotoData)
            throws Exception {
        //  查询漫画图片列表
        List<CartoonPhoto> list= cartoonPhotoServiceImpl.getCartoonPhotoByDistributor(cartoonPhotoData);
        if (!ParaClick.clickList(list)) {
            return new Model(500, "查询失败");
        }
        return new Model(list);
    }


    /**
     *    生成推广文案
     *
     * @author pengpai
     * @date 2018/3/7 12:12
     * @param [pageInfo, cartoonPhotoData]
     * @return com.crxl.qpp.comicdis.tool.Model
     */
    @RequestMapping(value = ActionUrl.DISTRIBUTOR_GET_CARTOONPHOTO_COVER, method = RequestMethod.POST)
    @RequiresAuthentication
    public Model generateCover(CartoonPhotoData cartoonPhotoData)
            throws Exception {
        //  查询漫画图片列表
        List<CartoonPhoto> list= cartoonPhotoServiceImpl.generateCover(cartoonPhotoData);
        if (!ParaClick.clickList(list))
            return new Model(500, "查询失败");
        //PageInfo<CartoonPhoto> pageInfos = new PageInfo<>(list);
        return new Model(list);
    }
}
