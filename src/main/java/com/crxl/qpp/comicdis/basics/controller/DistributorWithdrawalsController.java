package com.crxl.qpp.comicdis.basics.controller;

import com.crxl.qpp.comicdis.basics.entity.DistributorTotalYmd;
import com.crxl.qpp.comicdis.basics.service.impl.DistributorWithdrawalsServiceImpl;
import com.crxl.qpp.comicdis.system.ActionUrl;
import com.crxl.qpp.comicdis.tool.DateUtil;
import com.crxl.qpp.comicdis.tool.Model;
import com.crxl.qpp.comicdis.tool.PageInfo;
import com.crxl.qpp.comicdis.tool.ParaClick;
import com.github.pagehelper.Page;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class DistributorWithdrawalsController {

    @Autowired
    private DistributorWithdrawalsServiceImpl distributorWithdrawalsServiceImpl;


    /**
     *   分页 时间查询结算单
     *
     * @author pengpai
     * @date 2018/3/6 16:03
     * @param [authorization, pageInfo]
     * @return com.crxl.qpp.comicdis.tool.Model
     */
    @RequestMapping(value = ActionUrl.DISTRIBUTOR_GET_WITHDRAWALS, method = RequestMethod.POST)
    @RequiresAuthentication
    public Model selectWithdrawals(@RequestParam("id")String id, PageInfo pageInfo)
            throws Exception {
        if ("".equals(pageInfo.getStartDate())
                || null == pageInfo.getStartDate()) {
            pageInfo.setStartDate(DateUtil.getdate_yyyy_MM_dd());
            pageInfo.setEndDate(DateUtil.getdate_yyyy_MM_dd());
        }
        Long start = 0L;
        Long end = 0L;
        start = DateUtil.getdate_yyyy_MM_dd_00_00_00(
                pageInfo.getStartDate() + " 00:00:00").getTime();
        //用户设置结束时间
        end = DateUtil.getdate_yyyy_MM_dd_00_00_00(
                pageInfo.getEndDate() + " 23:59:59").getTime();
        //当前系统结束时间
        long nowend = DateUtil.getdate_yyyy_MM_dd_00_00_00(
                DateUtil.getdate_yyyy_MM_dd() + " 23:59:59").getTime();
        if(end>nowend){
            return new Model(500, "结束时间不能大于当前日期");
        }
        if (start > end) {
            return new Model(500, "开始时间大于结束时间");
        }
        //  查询结算单
        Page<DistributorTotalYmd> list= distributorWithdrawalsServiceImpl.selectWithdrawals(id,pageInfo);
        if (!ParaClick.clickList(list)) {
            return new Model(500, "查询失败");
        }
        PageInfo<DistributorTotalYmd> pageInfos = new PageInfo<>(list);
        return new Model(pageInfos);
    }
}
