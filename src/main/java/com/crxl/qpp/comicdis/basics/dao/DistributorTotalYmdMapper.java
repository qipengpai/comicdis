package com.crxl.qpp.comicdis.basics.dao;

import com.crxl.qpp.comicdis.basics.entity.DistributorTotalYmd;
import com.crxl.qpp.comicdis.basics.entity.data.Withdrawals;
import org.apache.ibatis.annotations.Param;
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
    List<DistributorTotalYmd> selectOrderTotalThisMonth(@Param("authorization") String authorization);

    //实例化更新后本月和全部收益及数据(新用户)
    int addDistributorTotal(@Param("total")Double total, @Param("numCount")Integer numCount,
                            @Param("distridutionId")String distridutionId, @Param("i")int i,
                            @Param("total102")Double total102, @Param("numCount102")Integer numCount102,
                            @Param("date")String date,@Param("sum")Double sum,
                            @Param("percapitarecharge")Double percapitarecharge,@Param("rechargepersonnum")Integer rechargepersonnum);

    //实例化更新后本月和全部收益及数据(老用户)
    int updateDistributorTotal(@Param("total")Double total, @Param("numCount")Integer numCount,
                               @Param("id")String id, @Param("i")int i,
                               @Param("total102")Double total102, @Param("numCount102")Integer numCount102,
                               @Param("date")String date,@Param("sum")Double sum,
                               @Param("percapitarecharge")Double percapitarecharge,
                               @Param("rechargepersonnum")Integer rechargepersonnum,
                               @Param("distridutionid")String distridutionid);
    //查看分销商是否已有记录
    List<DistributorTotalYmd> selectByDistributorId(@Param("id") String id);


}