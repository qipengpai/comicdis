package com.crxl.qpp.comicdis.basics.dao;

import com.crxl.qpp.comicdis.basics.entity.FriendsComment;

public interface FriendsCommentMapper {
    int deleteByPrimaryKey(String id);

    int insert(FriendsComment record);

    int insertSelective(FriendsComment record);

    FriendsComment selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(FriendsComment record);

    int updateByPrimaryKey(FriendsComment record);
}