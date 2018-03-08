package com.crxl.qpp.comicdis.basics.dao;

import com.crxl.qpp.comicdis.basics.entity.FirstType;

public interface FirstTypeMapper {
    int deleteByPrimaryKey(String id);

    int insert(FirstType record);

    int insertSelective(FirstType record);

    FirstType selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(FirstType record);

    int updateByPrimaryKey(FirstType record);
}