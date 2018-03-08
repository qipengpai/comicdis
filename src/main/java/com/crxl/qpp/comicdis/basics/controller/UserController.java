package com.crxl.qpp.comicdis.basics.controller;

import com.crxl.qpp.comicdis.basics.entity.UserEntity;
import com.crxl.qpp.comicdis.basics.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserServiceImpl userServiceImpl;

    /**
     *   用户表
     *   根据主键查询（第一个方法）
     * @author pengpai
     * @date 2018/2/25 13:50
     * @param [userId]
     * @return com.crxl.qpp.comicdis.basics.entity.UserEntity
     */
    @RequestMapping(value = "/selectById",method = RequestMethod.GET)
    public UserEntity select(@RequestHeader(value="Authorization", defaultValue = "0")String userId){
       return userServiceImpl.select(userId);
    }

}
