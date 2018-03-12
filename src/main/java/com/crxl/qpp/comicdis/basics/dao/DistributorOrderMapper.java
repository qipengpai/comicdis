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

    //增加每天各个渠道商的各项数据
    int addDistributorOrderTotal(@Param("distridutionid")String distridutionid, @Param("impldate")String impldate,
                                 @Param("totaltype")Integer totaltype, @Param("recharge")Double recharge,
                                 @Param("ordinaryrecharge")Double ordinaryrecharge,@Param("ordinaryrechargenum") Integer ordinaryrechargenum,
                                 @Param("noordinaryrechargenum")Integer noordinaryrechargenum, @Param("ordinarycompletionrate") Double ordinarycompletionrate,
                                 @Param("viprecharge")Double viprecharge, @Param("noviprechargenum")Integer noviprechargenum,
                                 @Param("viprechargenum")Integer viprechargenum,@Param("vipcompletionrate") Double vipcompletionrate,
                                 @Param("rechargepersonnum")Integer rechargepersonnum,@Param("percapitarecharge")Double percapitarecharge);
}