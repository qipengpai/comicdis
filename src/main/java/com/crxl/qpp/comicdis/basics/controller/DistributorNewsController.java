package com.crxl.qpp.comicdis.basics.controller;

import com.crxl.qpp.comicdis.basics.entity.Cartoon;
import com.crxl.qpp.comicdis.basics.entity.DistributorNews;
import com.crxl.qpp.comicdis.basics.entity.DistributorTotalYmd;
import com.crxl.qpp.comicdis.basics.service.impl.DistributorNewsServiceImpl;
import com.crxl.qpp.comicdis.system.ActionUrl;
import com.crxl.qpp.comicdis.tool.Model;
import com.crxl.qpp.comicdis.tool.PageInfo;
import com.crxl.qpp.comicdis.tool.ParaClick;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DistributorNewsController {

    @Autowired
    private DistributorNewsServiceImpl distributorNewsServiceImpl;

    /**
     *    查询分销商公告
     *
     * @author pengpai
     * @date 2018/3/8 11:24
     * @param [pageInfo]
     * @return com.crxl.qpp.comicdis.tool.Model
     */
    @RequestMapping(value = ActionUrl.DISTRIBUTOR_GET_NEWS, method = RequestMethod.POST)
    @RequiresAuthentication
    public Model selectNews(PageInfo pageInfo)
            throws Exception {
        //  查询分销商最近30天每天收益
        List<DistributorNews> list= distributorNewsServiceImpl.selectNews();
        if (!ParaClick.clickList(list)) {
            return new Model(500, "查询失败");
        }
        for (DistributorNews distributorNews:list) {
            if(distributorNews.getImpldate().length()>10) {
                distributorNews.setImpldate(distributorNews.getImpldate().substring(0, 11));
            }
        }
        return new Model(list);
    }
}
