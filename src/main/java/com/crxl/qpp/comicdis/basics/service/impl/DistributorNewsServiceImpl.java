package com.crxl.qpp.comicdis.basics.service.impl;

import com.crxl.qpp.comicdis.basics.dao.DistributorNewsMapper;
import com.crxl.qpp.comicdis.basics.entity.DistributorNews;
import com.crxl.qpp.comicdis.tool.PageInfo;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistributorNewsServiceImpl {

    @Autowired
    private DistributorNewsMapper distributorNewsMapper;

    /**
     *    查询分销商公告
     *
     * @author pengpai
     * @date 2018/3/8 11:26
     * @param [pageInfo]
     * @return java.util.List<com.crxl.qpp.comicdis.basics.entity.DistributorNews>
     */
    public List<DistributorNews> selectNews() {
        return distributorNewsMapper.selectNews();
    }
}
