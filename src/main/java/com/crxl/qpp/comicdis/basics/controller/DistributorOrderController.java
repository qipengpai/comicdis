package com.crxl.qpp.comicdis.basics.controller;

import com.crxl.qpp.comicdis.basics.entity.DistributorOrder;
import com.crxl.qpp.comicdis.basics.entity.data.DistributorOrderData;
import com.crxl.qpp.comicdis.basics.service.impl.DistributorOrderServiceImpl;
import com.crxl.qpp.comicdis.system.ActionUrl;
import com.crxl.qpp.comicdis.tool.Model;
import com.crxl.qpp.comicdis.tool.ParaClick;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DistributorOrderController {

    @Autowired
    private DistributorOrderServiceImpl distributorOrderServiceImpl;

    /**
     *    查询分销商最近30天每天收益
     *
     * @author pengpai
     * @date 2018/3/6 15:01
     * @param [authorization]
     * @return com.crxl.qpp.comicdis.tool.Model
     */
    @RequestMapping(value = ActionUrl.DISTRIBUTOR_GET_ORDERTOTAL_NEAR30DAYS, method = RequestMethod.POST)
    @RequiresAuthentication
    public Model selectOrderTotal(@RequestParam("id")String id)
            throws Exception {
        List<DistributorOrderData> array=new ArrayList<>();
        //  查询分销商最近30天每天收益
        List<DistributorOrder> list= distributorOrderServiceImpl.selectOrderTotalNear30Days(id);
        if (!ParaClick.clickList(list)) {
            return new Model(500, "查询失败");
        }
        for (int i = 0; i <list.size() ; i++) {
            DistributorOrderData distributorOrderData=new DistributorOrderData();
            distributorOrderData.setDistridutionid(list.get(i).getDistridutionid());
            distributorOrderData.setId(list.get(i).getId());
            distributorOrderData.setImpldate(list.get(i).getImpldate());
            distributorOrderData.setOrdinaryrecharge(list.get(i).getOrdinaryrecharge()+"");
            distributorOrderData.setOrdinaryrechargenum(list.get(i).getOrdinaryrechargenum()+"");
            distributorOrderData.setPercapitarecharge((list.get(i).getPercapitarecharge()+"").substring(0,(list.get(i).getPercapitarecharge()+"").lastIndexOf(".")+4));
            distributorOrderData.setRecharge(list.get(i).getRecharge()+"");
            distributorOrderData.setRechargepersonnum(list.get(i).getRechargepersonnum()+"");
            distributorOrderData.setTotaltype(list.get(i).getTotaltype());
            distributorOrderData.setViprecharge(list.get(i).getViprecharge()+"");
            distributorOrderData.setViprechargenum(list.get(i).getViprechargenum());
            array.add(distributorOrderData);
        }
        return new Model(array);
    }
}
