package com.crxl.qpp.comicdis.basics.controller;

import com.crxl.qpp.comicdis.basics.entity.DistributorTotalYmd;
import com.crxl.qpp.comicdis.basics.entity.data.DistributorTotalYmdData;
import com.crxl.qpp.comicdis.basics.service.impl.DistributorTotalYmdServiceImpl;
import com.crxl.qpp.comicdis.system.ActionUrl;
import com.crxl.qpp.comicdis.tool.Model;
import com.crxl.qpp.comicdis.tool.ParaClick;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
        List<DistributorTotalYmdData> array=new ArrayList<>();
        //  查询分销商本月收益
        List<DistributorTotalYmd> list= distributorTotalYmdServiceImpl.selectOrderTotalThisMonth(id);
        if (!ParaClick.clickList(list)) {
            return new Model(500, "查询失败");
        }
        for (int i = 0; i <list.size() ; i++) {
            DistributorTotalYmdData distributorOrderData=new DistributorTotalYmdData();
            distributorOrderData.setDistridutionid(list.get(i).getDistridutionid());
            distributorOrderData.setId(list.get(i).getId());
            distributorOrderData.setImpldate(list.get(i).getImpldate());
            distributorOrderData.setOrdinaryrecharge(list.get(i).getOrdinaryrecharge()+"");
            distributorOrderData.setOrdinaryrechargenum(list.get(i).getOrdinaryrechargenum()+"");
            if(list.get(i).getPercapitarecharge()>0){
                distributorOrderData.setPercapitarecharge((list.get(i).getPercapitarecharge()+"").substring(0,(list.get(i).getPercapitarecharge()+"").lastIndexOf(".")+4));
            }else{
                distributorOrderData.setPercapitarecharge("0");
            }
            distributorOrderData.setRecharge(list.get(i).getRecharge()+"");
            distributorOrderData.setRechargepersonnum(list.get(i).getRechargepersonnum()+"");
            distributorOrderData.setTotaltype(list.get(i).getTotaltype()+"");
            distributorOrderData.setViprecharge(list.get(i).getViprecharge()+"");
            distributorOrderData.setViprechargenum(list.get(i).getViprechargenum()+"");
            array.add(distributorOrderData);
        }
        return new Model(array);
    }

}
