package com.crxl.qpp.comicdis.basics.service.impl;

import com.crxl.qpp.comicdis.basics.dao.DistributorWithdrawalsMapper;
import com.crxl.qpp.comicdis.basics.entity.DistributorTotalYmd;
import com.crxl.qpp.comicdis.tool.PageInfo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DistributorWithdrawalsServiceImpl {

    @Autowired
    private DistributorWithdrawalsMapper distributorWithdrawalsMapper;
    /**
     *    分页 时间查询结算单
     *
     * @author pengpai
     * @date 2018/3/6 16:03
     * @param [authorization, pageInfo]
     * @return com.github.pagehelper.Page<com.crxl.qpp.comicdis.basics.entity.DistributorTotalYmd>
     */
    public Page<DistributorTotalYmd> selectWithdrawals(String authorization, PageInfo pageInfo) {
        PageHelper.startPage(pageInfo.getPageNum(),pageInfo.getPageSize());
        return distributorWithdrawalsMapper.selectWithdrawals(authorization,pageInfo.getStartDate()+"00:00:00",pageInfo.getEndDate()+"23:59:59");
    }
}
