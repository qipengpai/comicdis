package com.crxl.qpp.comicdis.basics.controller;

import com.crxl.qpp.comicdis.basics.entity.CartoonPhoto;
import com.crxl.qpp.comicdis.basics.entity.DistributionCartoonTitle;
import com.crxl.qpp.comicdis.basics.entity.data.CartoonData;
import com.crxl.qpp.comicdis.basics.entity.data.CartoonPhotoData;
import com.crxl.qpp.comicdis.basics.service.impl.DistributionCartoonTitleServiceImpl;
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
public class DistributionCartoonTitleController {

    @Autowired
    private DistributionCartoonTitleServiceImpl distributionCartoonTitleServiceImpl;

    /**
     *   查询漫画标题
     *
     * @author pengpai
     * @date 2018/3/6 14:26
     * @param [pageInfo, cartoonData]
     * @return com.crxl.qpp.comicdis.tool.Model
     */
    @RequestMapping(value = ActionUrl.DISTRIBUTOR_GET_CARTOONTITLE, method = RequestMethod.POST)
    @RequiresAuthentication
    public Model selectCartoonTitle(CartoonData cartoonData)
            throws Exception {
        //  查询漫画标题
        List<DistributionCartoonTitle> list= distributionCartoonTitleServiceImpl.selectCartoonTitle(cartoonData);
        if (!ParaClick.clickList(list)) {
            return new Model(500, "查询失败");
        }
        return new Model(list);
    }
}
