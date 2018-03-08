package com.crxl.qpp.comicdis.basics.dao;

import com.crxl.qpp.comicdis.basics.entity.CartoonSetComment;

public interface CartoonSetCommentMapper {
    int deleteByPrimaryKey(String id);

    int insert(CartoonSetComment record);

    int insertSelective(CartoonSetComment record);

    CartoonSetComment selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(CartoonSetComment record);

    int updateByPrimaryKey(CartoonSetComment record);
}