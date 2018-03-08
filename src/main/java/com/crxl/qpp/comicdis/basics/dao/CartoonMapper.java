package com.crxl.qpp.comicdis.basics.dao;

import com.crxl.qpp.comicdis.basics.entity.Cartoon;
import com.crxl.qpp.comicdis.basics.entity.data.CartoonData;
import com.crxl.qpp.comicdis.tool.PageInfo;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartoonMapper {
    int deleteByPrimaryKey(String id);

    int insert(Cartoon record);

    int insertSelective(Cartoon record);

    Cartoon selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Cartoon record);

    int updateByPrimaryKey(Cartoon record);

    Page<Cartoon> selectCartoon(PageInfo pageInfo);

    //主鍵查詢
    Cartoon selectById(@Param("id") String id);
}