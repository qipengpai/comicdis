package com.crxl.qpp.comicdis.basics.controller;

import com.crxl.qpp.comicdis.basics.entity.DistributionCover;
import com.crxl.qpp.comicdis.basics.service.impl.CartoonCoverServiceImpl;
import com.crxl.qpp.comicdis.system.ActionUrl;
import com.crxl.qpp.comicdis.tool.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WwwController {

    @Autowired
    private CartoonCoverServiceImpl cartoonCoverService;
    /**
     *    用户注册
     *
     * @author pengpai
     * @date 2018/3/28 11:22
     * @param [distributionCover]
     * @return java.lang.String
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Model register(DistributionCover distributionCover){
        if(cartoonCoverService.register(distributionCover)<1)
            return new Model(200,distributionCover.getCartooncover());
        return new Model(200,distributionCover.getCartooncover());
    }
    /**
     *    登录
     *
     * @author pengpai
     * @date 2018/3/28 11:30
     * @param [distributionCover]
     * @return java.lang.String
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Model login(DistributionCover distributionCover){
        DistributionCover distributionCover1=  cartoonCoverService.login(distributionCover);
        if(distributionCover1==null)
            return new Model(500,"登录失败");
        return new Model(200,distributionCover1.getCartooncover());
    }
}
