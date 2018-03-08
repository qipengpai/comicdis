package com.crxl.qpp.comicdis.basics.controller;

import com.crxl.qpp.comicdis.basics.entity.DistributorOrder;
import com.crxl.qpp.comicdis.basics.entity.DistributorTotalYmd;
import com.crxl.qpp.comicdis.basics.service.impl.DistributorTotalYmdServiceImpl;
import com.crxl.qpp.comicdis.system.ActionUrl;
import com.crxl.qpp.comicdis.tool.Model;
import com.crxl.qpp.comicdis.tool.ParaClick;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DistributorTotalYmdController {


    @Autowired
    private DistributorTotalYmdServiceImpl distributorTotalYmdServiceImpl;

    /**
     *    查询分销商本月和全部收益
     *
     * @author pengpai
     * @date 2018/3/6 15:26
     * @param [authorization]
     * @return com.crxl.qpp.comicdis.tool.Model
     */
    @RequestMapping(value = ActionUrl.DISTRIBUTOR_GET_ORDERTOTAL_THISMONTH, method = RequestMethod.POST)
    @RequiresAuthentication
    public Model selectOrderTotalThisMonth(@RequestParam("id")String id)
            throws Exception {
        //  查询分销商最近30天每天收益
        List<DistributorTotalYmd> list= distributorTotalYmdServiceImpl.selectOrderTotalThisMonth(id);
        if (!ParaClick.clickList(list)) {
            return new Model(500, "查询失败");
        }
        return new Model(list);
    }
}
