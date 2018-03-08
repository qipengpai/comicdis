package com.crxl.qpp.comicdis.basics.service.impl;

import com.crxl.qpp.comicdis.basics.dao.DistributorOrderMapper;
import com.crxl.qpp.comicdis.basics.dao.DistributorOrderTotalMapper;
import com.crxl.qpp.comicdis.basics.entity.DistributorCartoonModel;
import com.crxl.qpp.comicdis.basics.entity.DistributorOrder;
import com.crxl.qpp.comicdis.basics.entity.DistributorOrderTotal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistributorOrderServiceImpl {

    @Autowired
    private DistributorOrderMapper distributorOrderMapper;

    /**
     *    查询分销商最近30天每天收益
     *
     * @author pengpai
     * @date 2018/3/6 15:05
     * @param [authorization]
     * @return java.util.List<com.crxl.qpp.comicdis.basics.entity.DistributorOrder>
     */
    public List<DistributorOrder> selectOrderTotalNear30Days(String authorization) {
        return distributorOrderMapper.selectOrderTotalNear30Days(authorization);
    }
}