package com.crxl.qpp.comicdis.basics.controller;

import com.crxl.qpp.comicdis.basics.entity.Cartoon;
import com.crxl.qpp.comicdis.basics.service.impl.CartoonServiceImpl;
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


@RestController
public class CartoonController {

    @Autowired
    private CartoonServiceImpl cartoonServiceImpl;

    /**
     *    查询漫画列表
     *
     * @author pengpai
     * @date 2018/3/5 10:49
     * @param [cartoonData]
     * @return com.crxl.qpp.comicdis.tool.Model
     */
    @RequestMapping(value = ActionUrl.DISTRIBUTOR_GET_CARTOON, method = RequestMethod.POST)
    @RequiresAuthentication
    public Model userRegisterSend(PageInfo pageInfo)
            throws Exception {
        //  查询漫画列表
        Page<Cartoon> list= cartoonServiceImpl
                .getCartoonByDistributor(pageInfo);
        if (!ParaClick.clickList(list)) {
            return new Model(500, "查询失败");
        }
        PageInfo<Cartoon> pageInfos = new PageInfo<>(list);
        return new Model(pageInfos);
    }

}
