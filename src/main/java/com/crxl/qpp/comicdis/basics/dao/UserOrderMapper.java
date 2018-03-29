package com.crxl.qpp.comicdis.basics.dao;

import com.crxl.qpp.comicdis.basics.entity.UserOrder;
import com.crxl.qpp.comicdis.basics.entity.data.Withdrawals;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserOrderMapper {
    int deleteByPrimaryKey(String id);

    int insert(UserOrder record);

    int insertSelective(UserOrder record);

    UserOrder selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(UserOrder record);

    int updateByPrimaryKey(UserOrder record);

    //查该分销商当日流水统计
    Withdrawals getUserOrderWithdrawals(@Param("qd") String qd,@Param("orderDescription") String orderDescription);

    //查该分销商本月收益
    Withdrawals distributorTotalYmd(@Param("qd")String qd,@Param("description")String description);

    //查该分销商全部收益
    Withdrawals distributorTotalAll(@Param("qd")String qd,@Param("description")String description);

    //定时统计每天各个渠道商的各项数据
    Withdrawals distributorOrderTotal(@Param("qd")String qd, @Param("description")String description);

    //定时统计各分销商昨日结算单
    Withdrawals selectDistributorWithdrawals(@Param("qd")String qd);

    //查该分销商今日收益
    Withdrawals distributorTotalToday(@Param("qd")String qd, @Param("description")String description);
}