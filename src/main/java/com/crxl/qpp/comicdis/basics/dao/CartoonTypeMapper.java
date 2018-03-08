package com.crxl.qpp.comicdis.basics.dao;

import com.crxl.qpp.comicdis.basics.entity.CartoonType;

public interface CartoonTypeMapper {
    int deleteByPrimaryKey(String id);

    int insert(CartoonType record);

    int insertSelective(CartoonType record);

    CartoonType selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(CartoonType record);

    int updateByPrimaryKey(CartoonType record);
}