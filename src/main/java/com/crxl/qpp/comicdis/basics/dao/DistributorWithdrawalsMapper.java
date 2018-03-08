package com.crxl.qpp.comicdis.basics.dao;

import com.crxl.qpp.comicdis.basics.entity.DistributorTotalYmd;
import com.crxl.qpp.comicdis.basics.entity.DistributorWithdrawals;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DistributorWithdrawalsMapper {
    int deleteByPrimaryKey(String id);

    int insert(DistributorWithdrawals record);

    int insertSelective(DistributorWithdrawals record);

    DistributorWithdrawals selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DistributorWithdrawals record);

    int updateByPrimaryKey(DistributorWithdrawals record);

    //分页 时间查询结算单
    Page<DistributorTotalYmd> selectWithdrawals(@Param("authorization") String authorization, @Param("startDate") String startDate, @Param("endDate") String endDate);
}