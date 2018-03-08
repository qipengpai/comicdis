package com.crxl.qpp.comicdis.basics.dao;

import com.crxl.qpp.comicdis.basics.entity.CommentVeryOk;

public interface CommentVeryOkMapper {
    int deleteByPrimaryKey(String id);

    int insert(CommentVeryOk record);

    int insertSelective(CommentVeryOk record);

    CommentVeryOk selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(CommentVeryOk record);

    int updateByPrimaryKey(CommentVeryOk record);
}