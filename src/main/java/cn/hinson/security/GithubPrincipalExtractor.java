package cn.hinson.security;

import cn.hinson.domain.SysRole;
import cn.hinson.domain.SysUser;
import cn.hinson.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GithubPrincipalExtractor extends AbstractPrincipalExtractor {
    @Autowired
    UserService userService;
    @Override
    public SysUser getUserByOpenId(String id) {
        System.out.println("GithubPrincipalExtractor");
        return userService.getUserByGithubId(id);
    }

    @Override
    public SysRole getUserRoleByOauth2ClientName() {
        SysRole role = new SysRole();
        role.setName("GITHUB");
        return role;
    }
}
