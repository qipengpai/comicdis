package com.crxl.qpp.comicdis.basics.dao;

import com.crxl.qpp.comicdis.basics.entity.DistributorCartoonModel;
import com.crxl.qpp.comicdis.basics.entity.DistributorOrderTotal;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DistributorOrderTotalMapper {
    int deleteByPrimaryKey(String id);

    int insert(DistributorOrderTotal record);

    int insertSelective(DistributorOrderTotal record);

    DistributorOrderTotal selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DistributorOrderTotal record);

    int updateByPrimaryKey(DistributorOrderTotal record);

}