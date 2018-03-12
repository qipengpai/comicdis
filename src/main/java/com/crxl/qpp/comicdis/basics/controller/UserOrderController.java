package com.crxl.qpp.comicdis.basics.controller;

import com.crxl.qpp.comicdis.basics.entity.Distributor;
import com.crxl.qpp.comicdis.basics.entity.data.Withdrawals;
import com.crxl.qpp.comicdis.basics.service.impl.DistributorServiceImpl;
import com.crxl.qpp.comicdis.basics.service.impl.UserOrderServiceImpl;
import com.crxl.qpp.comicdis.system.ActionUrl;
import com.crxl.qpp.comicdis.tool.DateUtil;
import com.crxl.qpp.comicdis.tool.Model;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Hashtable;

@RestController
public class UserOrderController {

    @Autowired
    private UserOrderServiceImpl userOrderServiceImpl;
    @Autowired
    private DistributorServiceImpl distributorService;

    /**
     *    查询分销商当日流水
     *
     * @author pengpai
     * @date 2018/3/6 17:07
     * @param [authorization]
     * @return com.crxl.qpp.comicdis.tool.Model
     */
    @RequestMapping(value = ActionUrl.DISTRIBUTOR_GET_USERORDER_WITHDRAWALS, method = RequestMethod.POST)
    @RequiresAuthentication
    public Model getUserOrderWithdrawals(@RequestParam("id") String id,@RequestParam("time") String time)
            throws Exception {
        Long date = DateUtil.getdate_yyyy_MM_dd_00_00_00(time).getTime();
        Long now = new Date().getTime();
        if((now-date)<180000)
            return new Model(500, "三分钟可以刷新一次");
        Distributor distributor=distributorService.getDistributorById(id);
        if (distributor==null)
            return new Model(500, "无用戶");
        //  当日101统计
        Withdrawals withdrawals1= userOrderServiceImpl
                .getUserOrderWithdrawals(distributor.getQd(),"101");
        if (withdrawals1==null)
            return new Model(500, "查询失败");
        //  当日102统计
        Withdrawals withdrawals2= userOrderServiceImpl
                .getUserOrderWithdrawals(distributor.getQd(),"102");
        if (withdrawals2==null)
            return new Model(500, "查询失败");
        Hashtable<String,Object> table=new Hashtable<>();
        table.put("ordinaryRecharge",withdrawals1.getTotal());
        table.put("ordinaryRechargeNum",withdrawals1.getNumCount());
        table.put("vipRecharge",withdrawals2.getTotal());
        table.put("vipRechargeNum",withdrawals2.getNumCount());
        table.put("recharge",withdrawals1.getTotal()+withdrawals2.getTotal());
        table.put("time", DateUtil.getdate_yyyy_MM_dd_HH_MM_SS());
        return new Model(table);
    }
}
