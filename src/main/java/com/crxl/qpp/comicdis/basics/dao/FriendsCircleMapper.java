package com.crxl.qpp.comicdis.basics.dao;

import com.crxl.qpp.comicdis.basics.entity.FriendsCircle;

public interface FriendsCircleMapper {
    int deleteByPrimaryKey(String id);

    int insert(FriendsCircle record);

    int insertSelective(FriendsCircle record);

    FriendsCircle selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(FriendsCircle record);

    int updateByPrimaryKey(FriendsCircle record);
}