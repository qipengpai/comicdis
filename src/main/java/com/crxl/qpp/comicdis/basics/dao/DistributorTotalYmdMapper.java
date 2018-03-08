package com.crxl.qpp.comicdis.basics.dao;

import com.crxl.qpp.comicdis.basics.entity.DistributorTotalYmd;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DistributorTotalYmdMapper {
    int deleteByPrimaryKey(String id);

    int insert(DistributorTotalYmd record);

    int insertSelective(DistributorTotalYmd record);

    DistributorTotalYmd selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DistributorTotalYmd record);

    int updateByPrimaryKey(DistributorTotalYmd record);

    //查询分销商本月和全部收益
    List<DistributorTotalYmd> selectOrderTotalThisMonth(String authorization);
}