package com.crxl.qpp.comicdis.basics.dao;

import com.crxl.qpp.comicdis.basics.entity.DistributorNews;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DistributorNewsMapper {
    int deleteByPrimaryKey(String id);

    int insert(DistributorNews record);

    int insertSelective(DistributorNews record);

    DistributorNews selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DistributorNews record);

    int updateByPrimaryKey(DistributorNews record);

    //查询分销商公告
    List<DistributorNews> selectNews();
}