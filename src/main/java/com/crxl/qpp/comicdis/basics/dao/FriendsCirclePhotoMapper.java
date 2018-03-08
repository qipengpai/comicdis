package com.crxl.qpp.comicdis.basics.dao;

import com.crxl.qpp.comicdis.basics.entity.FriendsCirclePhoto;

public interface FriendsCirclePhotoMapper {
    int deleteByPrimaryKey(String id);

    int insert(FriendsCirclePhoto record);

    int insertSelective(FriendsCirclePhoto record);

    FriendsCirclePhoto selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(FriendsCirclePhoto record);

    int updateByPrimaryKey(FriendsCirclePhoto record);
}