package com.crxl.qpp.comicdis.basics.service.impl;

import com.crxl.qpp.comicdis.basics.dao.DistributorMapper;
import com.crxl.qpp.comicdis.basics.entity.Distributor;
import com.crxl.qpp.comicdis.basics.entity.data.DistributorData;
import com.crxl.qpp.comicdis.exception.BusinessException;
import com.crxl.qpp.comicdis.tool.DateUtil;
import com.crxl.qpp.comicdis.tool.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DistributorServiceImpl {

    @Autowired
    private DistributorMapper distributorMapper;

    /**
     *  分销商登录
     *
     * @author pengpai
     * @date 2018/3/2 13:40
     * @param [distributorData]
     * @return com.crxl.qpp.comicdis.basics.entity.Distributor
     */
    @Transactional(propagation = Propagation.SUPPORTS)
    public Distributor distributorLogin(Distributor distributor) {
        String userPwd=MD5.getMd5(distributor.getUserpwd());
        Distributor distributorId=distributorMapper.distributorLogin(distributor.getUsername(),userPwd);
        if(distributorId==null){
            return distributorId;
        }
        distributorId.setLastlogindate(DateUtil.getdate_yyyy_MM_dd_HH_MM_SS());
        int index=distributorMapper.updateLastlogindate(DateUtil.getdate_yyyy_MM_dd_HH_MM_SS(),distributorId.getId());
       // int index=distributorMapper.updateByPrimaryKeySelective(distributorId);
        if(index<1){
            throw new BusinessException("修改异常");
        }
        return distributorId;
    }
    /**
     *    分销商修改密码
     *
     * @author pengpai
     * @date 2018/3/3 17:47
     * @param [authorization, newUserPwd, userPwd]
     * @return boolean
     */
    public boolean distributorUpdateUserPwd(String authorization, String newUserPwd, String userPwd) {
        boolean flag=false;
        int sign =distributorMapper.updateUserPwd(authorization,MD5.getMd5(newUserPwd),MD5.getMd5(userPwd));
        if(sign<1){
            return flag;
        }
        flag=true;
        return flag;
    }
    /**
     *    查詢分銷商qd根據id
     *
     * @author pengpai
     * @date 2018/3/5 15:29
     * @param [authorization]
     * @return com.crxl.qpp.comicdis.basics.entity.Distributor
     */
    public Distributor getDistributorById(String distributorId) {
        return distributorMapper.selectQdByPrimaryKey(distributorId);
    }

    /**
     *    为生成用户token
     *
     * @author pengpai
     * @date 2018/3/7 15:29
     * @param [username]
     * @return com.crxl.qpp.comicdis.basics.entity.Distributor
     */
    public Distributor getUser(String username) {

        return distributorMapper.getDistributor(username);
    }


    public DistributorData getDistributorData(String username) {
        return distributorMapper.getDistributorData(username);
    }
}
