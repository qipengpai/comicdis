package com.crxl.qpp.comicdis.basics.service.impl;

import com.crxl.qpp.comicdis.basics.dao.UserEntityMapper;
import com.crxl.qpp.comicdis.basics.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl {

    @Autowired
    private UserEntityMapper userEntityMapper;

    /**
     *   用户表
     *   根据主键查询（第一个方法）
     * @author pengpai
     * @date 2018/2/25 13:50
     * @param [userId]
     * @return com.crxl.qpp.comicdis.basics.entity.UserEntity
     */
    @Transactional(propagation = Propagation.SUPPORTS)
    public UserEntity select(String userId){
        return userEntityMapper.selectByPrimaryKey(userId);
    }



}
