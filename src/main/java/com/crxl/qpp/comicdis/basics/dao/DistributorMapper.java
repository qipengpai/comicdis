package com.crxl.qpp.comicdis.basics.dao;

import com.crxl.qpp.comicdis.basics.entity.Distributor;
import com.crxl.qpp.comicdis.basics.entity.data.DistributorData;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DistributorMapper {
    int deleteByPrimaryKey(String id);

    int insert(Distributor record);

    int insertSelective(Distributor record);

    Distributor selectByPrimaryKey( String id);

    int updateByPrimaryKeySelective(Distributor record);

    int updateByPrimaryKey(Distributor record);

    //分销商登录
    Distributor distributorLogin(@Param("userName")String userName,@Param("userPwd")String userPwd);

    //修改最後登陸時間
    int updateLastlogindate(@Param("lastlogindate")String lastlogindate,@Param("id")String id);

    //分销商修改密码
    int updateUserPwd(@Param("authorization")String authorization, @Param("newUserPwd")String newUserPwd, @Param("userPwd")String  userPwd);

    //获取分销商渠道
    Distributor selectQdByPrimaryKey(@Param("id") String id);

    //身份认证为生成用户token
    Distributor getDistributor(@Param("username") String username);

    //（暫時不用）查詢用戶角色
    DistributorData getDistributorData(@Param("username") String username);
}