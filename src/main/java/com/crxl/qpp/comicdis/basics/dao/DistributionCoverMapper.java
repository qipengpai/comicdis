package com.crxl.qpp.comicdis.basics.dao;

import com.crxl.qpp.comicdis.basics.entity.DistributionCover;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DistributionCoverMapper {
    int deleteByPrimaryKey(String id);

    int insert(DistributionCover record);

    int insertSelective(DistributionCover record);

    DistributionCover selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DistributionCover record);

    int updateByPrimaryKey(DistributionCover record);
    //登录
    DistributionCover selectByLogin(@Param("cartoonid") String cartoonid, @Param("impldate") String impldate);
}