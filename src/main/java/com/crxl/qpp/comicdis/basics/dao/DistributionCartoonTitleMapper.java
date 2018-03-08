package com.crxl.qpp.comicdis.basics.dao;

import com.crxl.qpp.comicdis.basics.entity.DistributionCartoonTitle;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DistributionCartoonTitleMapper {
    int deleteByPrimaryKey(String id);

    int insert(DistributionCartoonTitle record);

    int insertSelective(DistributionCartoonTitle record);

    DistributionCartoonTitle selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DistributionCartoonTitle record);

    int updateByPrimaryKey(DistributionCartoonTitle record);

    //查询漫画标题
    List<DistributionCartoonTitle> selectByCartoonId(@Param("cartoonid") String cartoonid);
}