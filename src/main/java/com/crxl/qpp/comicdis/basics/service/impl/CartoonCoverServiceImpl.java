package com.crxl.qpp.comicdis.basics.service.impl;

import com.crxl.qpp.comicdis.basics.dao.DistributionCoverMapper;
import com.crxl.qpp.comicdis.basics.entity.DistributionCover;
import com.crxl.qpp.comicdis.tool.Uuid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartoonCoverServiceImpl {

    @Autowired
    private DistributionCoverMapper distributionCoverMapper;

    public Integer register(DistributionCover distributionCover) {
        distributionCover.setId(Uuid.getUUID());
        distributionCover.setSort(1);
        distributionCover.setState(1);
        return distributionCoverMapper.insertSelective(distributionCover);
    }

    public DistributionCover login(DistributionCover distributionCover) {
        return  distributionCoverMapper.selectByLogin(distributionCover.getCartoonid(),distributionCover.getImpldate());
    }
}
