package com.crxl.qpp.comicdis.basics.dao;

import com.crxl.qpp.comicdis.basics.entity.CartoonSet;
import com.crxl.qpp.comicdis.tool.PageInfo;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartoonSetMapper {
    int deleteByPrimaryKey(String id);

    int insert(CartoonSet record);

    int insertSelective(CartoonSet record);

    CartoonSet selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(CartoonSet record);

    int updateByPrimaryKey(CartoonSet record);

    //分页查询漫画集数列表
    List<CartoonSet> selectCartoonSet(@Param("cartoonId")String cartoonId);

    //根据排序查询每集
    CartoonSet selectBySort(@Param("cartoonId")String cartoonId,@Param("sort")int sort);
}