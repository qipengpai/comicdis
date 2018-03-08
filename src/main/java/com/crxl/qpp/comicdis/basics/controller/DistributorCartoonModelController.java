package com.crxl.qpp.comicdis.basics.controller;

import com.crxl.qpp.comicdis.basics.entity.DistributorCartoonModel;
import com.crxl.qpp.comicdis.basics.entity.data.CartoonData;
import com.crxl.qpp.comicdis.basics.service.impl.DistributorCartoonModelServiceImpl;
import com.crxl.qpp.comicdis.system.ActionUrl;
import com.crxl.qpp.comicdis.tool.Model;
import com.crxl.qpp.comicdis.tool.ParaClick;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DistributorCartoonModelController {

    @Autowired
    private DistributorCartoonModelServiceImpl distributorCartoonModelServiceImpl;

    /**
     *    查询漫画封面
     *
     * @author pengpai
     * @date 2018/3/6 14:49
     * @param [cartoonData]
     * @return com.crxl.qpp.comicdis.tool.Model
     */
    @RequestMapping(value = ActionUrl.DISTRIBUTOR_GET_CARTOONMODEL, method = RequestMethod.POST)
    @RequiresAuthentication
    public Model selectCartoonTitle(CartoonData cartoonData)
            throws Exception {
        //  查询漫画标题
        List<DistributorCartoonModel> list= distributorCartoonModelServiceImpl.selectCartoonModel(cartoonData);
        if (!ParaClick.clickList(list)) {
            return new Model(500, "查询失败");
        }
        return new Model(list);
    }
}
