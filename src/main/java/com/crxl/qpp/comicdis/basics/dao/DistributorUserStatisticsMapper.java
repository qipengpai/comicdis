package com.crxl.qpp.comicdis.basics.dao;

import com.crxl.qpp.comicdis.basics.entity.DistributorUserStatistics;
import org.springframework.stereotype.Repository;

@Repository
public interface DistributorUserStatisticsMapper {
    int deleteByPrimaryKey(String id);

    int insert(DistributorUserStatistics record);

    int insertSelective(DistributorUserStatistics record);

    DistributorUserStatistics selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DistributorUserStatistics record);

    int updateByPrimaryKey(DistributorUserStatistics record);
}