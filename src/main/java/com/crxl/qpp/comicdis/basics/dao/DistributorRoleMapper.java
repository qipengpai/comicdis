package com.crxl.qpp.comicdis.basics.dao;

import com.crxl.qpp.comicdis.basics.entity.DistributorRole;

public interface DistributorRoleMapper {
    int deleteByPrimaryKey(String id);

    int insert(DistributorRole record);

    int insertSelective(DistributorRole record);

    DistributorRole selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DistributorRole record);

    int updateByPrimaryKey(DistributorRole record);
}