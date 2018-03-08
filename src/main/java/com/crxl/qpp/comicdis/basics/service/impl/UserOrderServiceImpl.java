package com.crxl.qpp.comicdis.basics.service.impl;

import com.crxl.qpp.comicdis.basics.dao.UserOrderMapper;
import com.crxl.qpp.comicdis.basics.entity.Cartoon;
import com.crxl.qpp.comicdis.basics.entity.data.Withdrawals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserOrderServiceImpl {

    @Autowired
    private UserOrderMapper userOrderMapper;

    /**
     *    当日流水统计
     *
     * @author pengpai
     * @date 2018/3/6 18:03
     * @param [authorization]
     * @return java.util.List<com.crxl.qpp.comicdis.basics.entity.data.Withdrawals>
     */
    public Withdrawals getUserOrderWithdrawals(String qd,String orderDescription) {
        return userOrderMapper.getUserOrderWithdrawals(qd,orderDescription);
    }

}
