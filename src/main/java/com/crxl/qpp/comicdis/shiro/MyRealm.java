package com.crxl.qpp.comicdis.shiro;

import com.crxl.qpp.comicdis.basics.entity.Distributor;
import com.crxl.qpp.comicdis.basics.entity.data.DistributorData;
import com.crxl.qpp.comicdis.basics.service.impl.DistributorServiceImpl;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import com.crxl.qpp.comicdis.tool.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Service
public class MyRealm extends AuthorizingRealm {

    private static final Logger LOGGER = LogManager.getLogger(MyRealm.class);

    private DistributorServiceImpl distributorServiceImpl;

    @Autowired
    public void setUserService(DistributorServiceImpl distributorServiceImpl) {
        this.distributorServiceImpl = distributorServiceImpl;
    }

    /**
     *    大坑！，必须重写此方法，不然Shiro会报错
     *
     * @author pengpai
     * @date 2018/3/8 13:50
     * @param [token]
     * @return boolean
     */
    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JWTToken;
    }

    /**
     *    只有当需要检测用户权限的时候才会调用此方法，例如checkRole,checkPermission之类的
     *
     * @author pengpai
     * @date 2018/3/8 13:50
     * @param
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

//    @Override
//    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
//        String username = JWTUtil.getUsername(principals.toString());
//        DistributorData user = distributorServiceImpl.getDistributorData(username);
//        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
//        simpleAuthorizationInfo.addRole(user.getRole());
//      /*  Set<String> permission = new HashSet<String>(Arrays.asList(user.getPermission().split(",")));
//        simpleAuthorizationInfo.addStringPermissions(permission);*/
//        return simpleAuthorizationInfo;
//    }

    /**
     *   默认使用此方法进行用户名正确与否验证，
     *   错误抛出异常即可。
     * @author pengpai
     * @date 2018/3/8 13:50
     * @param [auth]
     * @return org.apache.shiro.authc.AuthenticationInfo
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken auth) throws AuthenticationException {
        String token = (String) auth.getCredentials();
        // 解密获得username，用于和数据库进行对比
        String username = JWTUtil.getUsername(token);
        if (username == null) {
            throw new AuthenticationException("token invalid");
        }

        Distributor distributor = distributorServiceImpl.getUser(username);
        if (distributor == null) {
            throw new AuthenticationException("User didn't existed!");
        }

        if (! JWTUtil.verify(token, username, distributor.getUserpwd())) {
            throw new AuthenticationException("Username or password error");
        }

        return new SimpleAuthenticationInfo(token, token, "my_realm");
    }


}
