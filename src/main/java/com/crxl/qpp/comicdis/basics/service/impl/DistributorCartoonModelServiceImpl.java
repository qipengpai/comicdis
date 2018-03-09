package com.crxl.qpp.comicdis.basics.service.impl;

import com.crxl.qpp.comicdis.basics.dao.DistributorCartoonModelMapper;
import com.crxl.qpp.comicdis.basics.entity.DistributorCartoonModel;
import com.crxl.qpp.comicdis.basics.entity.data.CartoonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistributorCartoonModelServiceImpl {

    @Autowired
    private DistributorCartoonModelMapper distributorCartoonModelMapper;

    /**
     *    查询漫画封面
     *
     * @author pengpai
     * @date 2018/3/6 14:49
     * @param [cartoonData]
     * @return java.util.List<com.crxl.qpp.comicdis.basics.entity.DistributorCartoonModel>
     */
    @Cacheable(value = "DistributorCartoonModel",key = "#root.methodName.concat(#cartoonData.getId())")
    public List<DistributorCartoonModel> selectCartoonModel(CartoonData cartoonData) {
        return distributorCartoonModelMapper.selectCartoonModel(cartoonData.getId());
    }
}
