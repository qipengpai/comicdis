package com.crxl.qpp.comicdis.basics.dao;

import com.crxl.qpp.comicdis.basics.entity.PhoneVerification;

public interface PhoneVerificationMapper {
    int deleteByPrimaryKey(String id);

    int insert(PhoneVerification record);

    int insertSelective(PhoneVerification record);

    PhoneVerification selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(PhoneVerification record);

    int updateByPrimaryKey(PhoneVerification record);
}