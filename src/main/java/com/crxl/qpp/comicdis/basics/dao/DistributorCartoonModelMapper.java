package com.crxl.qpp.comicdis.basics.dao;

import com.crxl.qpp.comicdis.basics.entity.DistributorCartoonModel;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DistributorCartoonModelMapper {
    int deleteByPrimaryKey(String id);

    int insert(DistributorCartoonModel record);

    int insertSelective(DistributorCartoonModel record);

    DistributorCartoonModel selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DistributorCartoonModel record);

    int updateByPrimaryKey(DistributorCartoonModel record);

    //查询漫画封面
    List<DistributorCartoonModel> selectCartoonModel(@Param("cartoonid") String cartoonid);
}