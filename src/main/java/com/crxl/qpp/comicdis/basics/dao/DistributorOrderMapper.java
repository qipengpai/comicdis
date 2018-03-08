package com.crxl.qpp.comicdis.basics.dao;

import com.crxl.qpp.comicdis.basics.entity.DistributorOrder;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DistributorOrderMapper {
    int deleteByPrimaryKey(String id);

    int insert(DistributorOrder record);

    int insertSelective(DistributorOrder record);

    DistributorOrder selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DistributorOrder record);

    int updateByPrimaryKey(DistributorOrder record);

    //查询分销商最近30天每天收益
    List<DistributorOrder> selectOrderTotalNear30Days(@Param("authorization") String authorization);
}