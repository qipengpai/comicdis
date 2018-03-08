package com.crxl.qpp.comicdis.basics.dao;

import com.crxl.qpp.comicdis.basics.entity.MallCartoonOrder;

public interface MallCartoonOrderMapper {
    int deleteByPrimaryKey(String id);

    int insert(MallCartoonOrder record);

    int insertSelective(MallCartoonOrder record);

    MallCartoonOrder selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(MallCartoonOrder record);

    int updateByPrimaryKey(MallCartoonOrder record);
}