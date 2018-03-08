package com.crxl.qpp.comicdis.basics.service.impl;

import com.crxl.qpp.comicdis.basics.dao.DistributorTotalYmdMapper;
import com.crxl.qpp.comicdis.basics.entity.DistributorTotalYmd;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistributorTotalYmdServiceImpl {

    @Autowired
    private DistributorTotalYmdMapper distributorTotalYmdMapper;
    /**
     *    查询分销商本月和全部收益
     *
     * @author pengpai
     * @date 2018/3/6 15:27
     * @param [authorization]
     * @return java.util.List<com.crxl.qpp.comicdis.basics.entity.DistributorTotalYmd>
     */
    public List<DistributorTotalYmd> selectOrderTotalThisMonth(String authorization) {
        return distributorTotalYmdMapper.selectOrderTotalThisMonth(authorization);
    }
}
