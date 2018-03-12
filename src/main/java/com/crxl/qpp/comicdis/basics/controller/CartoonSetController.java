package com.crxl.qpp.comicdis.basics.controller;

import com.crxl.qpp.comicdis.basics.entity.Cartoon;
import com.crxl.qpp.comicdis.basics.entity.CartoonSet;
import com.crxl.qpp.comicdis.basics.entity.Distributor;
import com.crxl.qpp.comicdis.basics.entity.data.CartoonSetData;
import com.crxl.qpp.comicdis.basics.service.impl.CartoonServiceImpl;
import com.crxl.qpp.comicdis.basics.service.impl.CartoonSetServiceImpl;
import com.crxl.qpp.comicdis.basics.service.impl.DistributorServiceImpl;
import com.crxl.qpp.comicdis.system.ActionUrl;
import com.crxl.qpp.comicdis.tool.Model;
import com.crxl.qpp.comicdis.tool.PageInfo;
import com.crxl.qpp.comicdis.tool.ParaClick;
import com.crxl.qpp.comicdis.weChat.url.GetUrl;
import com.github.pagehelper.Page;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CartoonSetController {

    @Autowired
    private CartoonSetServiceImpl cartoonSetServiceImpl;
    @Autowired
    private CartoonServiceImpl cartoonServiceImpl;
    @Autowired
    private DistributorServiceImpl distributorServiceImpl;
    /**
     *    查询漫画集数列表
     *
     * @author pengpai
     * @date 2018/3/5 15:00
     * @param [pageInfo, cartoonSet]
     * @return com.crxl.qpp.comicdis.tool.Model
     */
    @RequestMapping(value = ActionUrl.DISTRIBUTOR_GET_CARTOONSET, method = RequestMethod.POST)
    @RequiresAuthentication
    public Model userRegisterSend(CartoonSetData cartoonSetData)
            throws Exception {
        //  查询漫画集数列表
        List<CartoonSet> list= cartoonSetServiceImpl
                .getCartoonSetByDistributor(cartoonSetData.getCartoonid());
        if (!ParaClick.clickList(list))
            return new Model(500, "查询失败");
        // 查询漫画主鍵
        Cartoon cartoon=cartoonServiceImpl.getById(list.get(0).getCartoonid());
        if (cartoon==null)
            return new Model(500, "查询失败");
        return new Model(list,cartoon);
    }
    /**
     *    生成漫畫每集本集鏈接
     *
     * @author pengpai
     * @date 2018/3/5 15:28
     * @param [authorization, cartoonSetData]
     * @return com.crxl.qpp.comicdis.tool.Model
     */
    @RequestMapping(value = ActionUrl.DISTRIBUTOR_GENERATE_URL, method = RequestMethod.POST)
    @RequiresAuthentication
    public Model generateUrl(@RequestParam("distributorId")String distributorId,CartoonSetData cartoonSetData)
            throws Exception {
        Distributor distributor=distributorServiceImpl.getDistributorById(distributorId);
        if (distributor==null)
            return new Model(500,"不存在分銷商");
        //  生成链接
        String url=GetUrl.getComicUrl(cartoonSetData.getCartoonid(),cartoonSetData.getId(),distributor.getQd());
        return new Model(url);
    }
    /**
     *    生成漫畫当前话下一话鏈接
     *
     * @author pengpai
     * @date 2018/3/5 16:31
     * @param [authorization, cartoonSetData]
     * @return com.crxl.qpp.comicdis.tool.Model
     */
    @RequestMapping(value = ActionUrl.DISTRIBUTOR_GENERATE_NEXTURL, method = RequestMethod.POST)
    @RequiresAuthentication
    public Model generateNextUrl(@RequestParam("distributorId")String distributorId, CartoonSetData cartoonSetData)
            throws Exception {
        Distributor distributor=distributorServiceImpl.getDistributorById(distributorId);
        if(distributor==null)
            return new Model(200,"获取分销商失败");
        CartoonSet cartoonSet= cartoonSetServiceImpl.getNextCartoonSetId(cartoonSetData.getId());
        if(cartoonSet==null)
            return new Model(200,"获取集数失败");
        //  生成链接
        String url=GetUrl.getComicUrl(cartoonSetData.getCartoonid(),cartoonSet.getId(),distributor.getQd());
        return new Model(url);
    }

}
