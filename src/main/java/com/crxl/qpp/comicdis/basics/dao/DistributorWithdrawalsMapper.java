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
    Page<DistributorWithdrawals> selectWithdrawals(@Param("authorization") String authorization, @Param("startDate") String startDate, @Param("endDate") String endDate);

    //增加每日结算单
    boolean addDistributorWithdrawals(@Param("todayrecharge") Double todayrecharge,@Param("withdrawalsmoney") Double withdrawalsmoney,
                                      @Param("ordersum")Integer ordersum,@Param("distridutionid") String distridutionid,
                                      @Param("proportion")Double proportion, @Param("remarks")String remarks,
                                      @Param("impldate")String impldate,@Param("withdrawalsstate")Integer withdrawalsstate,
                                      @Param("withdrawalsdate")String withdrawalsdate);
}