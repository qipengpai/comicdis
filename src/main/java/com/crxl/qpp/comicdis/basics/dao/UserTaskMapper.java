package com.crxl.qpp.comicdis.basics.dao;

import com.crxl.qpp.comicdis.basics.entity.UserTask;

public interface UserTaskMapper {
    int deleteByPrimaryKey(String id);

    int insert(UserTask record);

    int insertSelective(UserTask record);

    UserTask selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(UserTask record);

    int updateByPrimaryKey(UserTask record);
}