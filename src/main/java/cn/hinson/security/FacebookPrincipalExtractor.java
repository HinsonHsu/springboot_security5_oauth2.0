package cn.hinson.security;

import cn.hinson.domain.SysRole;
import cn.hinson.domain.SysUser;
import org.springframework.stereotype.Component;

@Component
public class FacebookPrincipalExtractor extends AbstractPrincipalExtractor {

    @Override
    public SysUser getUserByOpenId(String id) {
        return super.userService.getUserByFacebookId(id);
    }

    @Override
    public SysRole getUserRoleByOauth2ClientName() {
        SysRole role = new SysRole();
        role.setName("FACEBOOK");
        return role;
    }
}
