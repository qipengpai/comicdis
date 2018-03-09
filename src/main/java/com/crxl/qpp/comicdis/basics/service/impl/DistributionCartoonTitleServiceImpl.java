package com.crxl.qpp.comicdis.basics.service.impl;

import com.crxl.qpp.comicdis.basics.dao.DistributionCartoonTitleMapper;
import com.crxl.qpp.comicdis.basics.entity.DistributionCartoonTitle;
import com.crxl.qpp.comicdis.basics.entity.data.CartoonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistributionCartoonTitleServiceImpl {

    @Autowired
    private DistributionCartoonTitleMapper distributionCartoonTitleMapper;

    /**
     *    查询漫画标题
     *
     * @author pengpai
     * @date 2018/3/6 14:42
     * @param [cartoonData]
     * @return java.util.List<com.crxl.qpp.comicdis.basics.entity.DistributionCartoonTitle>
     */

    @Cacheable(value = "DistributorCartoonTitle",key = "#root.methodName.concat(#cartoonData.getId())")
    public List<DistributionCartoonTitle> selectCartoonTitle(CartoonData cartoonData) {
        return distributionCartoonTitleMapper.selectByCartoonId(cartoonData.getId());
    }
}
