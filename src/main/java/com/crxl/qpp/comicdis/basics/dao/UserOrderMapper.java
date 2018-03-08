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
}