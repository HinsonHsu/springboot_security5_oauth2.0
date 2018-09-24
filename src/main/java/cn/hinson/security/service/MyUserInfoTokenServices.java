package cn.hinson.security.service;

import cn.hinson.dao.UserDao;
import cn.hinson.domain.SysUser;
import cn.hinson.security.AbstractPrincipalExtractor;
import org.springframework.boot.autoconfigure.security.oauth2.resource.UserInfoTokenServices;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Map;

public class MyUserInfoTokenServices extends UserInfoTokenServices {


    private UserDao userDao;

    private String oauth2Type;
    public MyUserInfoTokenServices(String userInfoEndPointUrl, String clienId, AbstractPrincipalExtractor principalExtractor) {
        super(userInfoEndPointUrl, clienId);
        super.setPrincipalExtractor(principalExtractor);
    }
}
