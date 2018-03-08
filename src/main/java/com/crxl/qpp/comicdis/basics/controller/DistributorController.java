package com.crxl.qpp.comicdis.basics.controller;

import com.crxl.qpp.comicdis.basics.entity.Distributor;
import com.crxl.qpp.comicdis.basics.entity.data.DistributorData;
import com.crxl.qpp.comicdis.basics.service.impl.DistributorServiceImpl;
import com.crxl.qpp.comicdis.system.ActionUrl;
import com.crxl.qpp.comicdis.tool.JWTUtil;
import com.crxl.qpp.comicdis.tool.MD5;
import com.crxl.qpp.comicdis.tool.Model;
import com.crxl.qpp.comicdis.tool.ParaClick;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class DistributorController {

    @Autowired
    private DistributorServiceImpl distributorService;

    /**
     *    分销商登录
     *
     * @author pengpai
     * @date 2018/3/2 14:52
     * @param [distributor]
     * @return com.crxl.qpp.comicdis.tool.Model
     */
    @RequestMapping(value = ActionUrl.DISTRIBUTOR_LOGIN, method = RequestMethod.POST)
    public Model userRegisterSend(Distributor distributor)
            throws Exception {
        if (ParaClick.clickString(distributor.getUsername()))
            return new Model(500, "请输入账号");
        if (ParaClick.clickString(distributor.getUserpwd()))
            return new Model(500, "请输入密码");
        //  登录
        Distributor distributorId = distributorService
                .distributorLogin(distributor);
        if (distributorId==null)
            return new Model(500, "用户名或密码错误");
        //System.out.println(JWTUtil.sign(distributor.getUsername(), MD5.getMd5(distributor.getUserpwd())));
        return new Model(distributorId, JWTUtil.sign(distributor.getUsername(), MD5.getMd5(distributor.getUserpwd())));
    }
    /**
     *    分销商修改密码
     *
     * @author pengpai
     * @date 2018/3/3 17:27
     * @param [distributorData, authorization]
     * @return com.crxl.qpp.comicdis.tool.Model
     */
    @RequestMapping(value = ActionUrl.DISTRIBUTOR_UPDATEPWD, method = RequestMethod.POST)
    @RequiresAuthentication
  //  @RequiresRoles("admin")
    public Model userUpdatePwd(DistributorData distributorData)
            throws Exception {
        if (ParaClick.clickString(distributorData.getNewUserPwd())) {
            return new Model(500, "请输入新密码");
        }
        if (ParaClick.clickString(distributorData.getUserPwd())) {
            return new Model(500, "请输入原密码");
        }
        //  修改密码
        boolean flag = distributorService
                .distributorUpdateUserPwd(distributorData.getId(),distributorData.getNewUserPwd(),distributorData.getUserPwd());
        if (!flag) {
            return new Model(500, "修改密码失败");
        }
        return new Model(200, "修改密码成功");
    }
    /**
     *    401
     *
     * @author pengpai
     * @date 2018/3/7 15:29
     * @param []
     * @return com.crxl.qpp.comicdis.tool.Model
     */
    @RequestMapping(path = "/401")
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public Model unauthorized() {
        return new Model(401, "Unauthorized", null);
    }
}
