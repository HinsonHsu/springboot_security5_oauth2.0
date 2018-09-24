package cn.hinson.security;

import cn.hinson.domain.SysRole;
import cn.hinson.domain.SysUser;
import cn.hinson.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.resource.PrincipalExtractor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class AbstractPrincipalExtractor implements PrincipalExtractor {

  @Autowired
  UserService userService;
  //用户openid
  public abstract SysUser getUserByOpenId(String id);
  //用户角色，用“FACEBOOK"代表facebook用户，”GITHUB"代表"github用户
  public abstract SysRole getUserRoleByOauth2ClientName();

  @Override
  public Object extractPrincipal(Map<String, Object> map) {
    //得到对于的社交平台的openid
    String id =  map.get("id").toString();
    // Check if we've already registered this uer
    System.out.println("id: " + id);
    SysUser user = getUserByOpenId(id);
    if (user == null) {
      // If we haven't registered this user yet, create a new one
//      Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//      // This Details object exposes a token that allows us to interact with Facebook on this user's behalf
//      String token = ((OAuth2AuthenticationDetails) authentication.getDetails()).getTokenValue();
      user = new SysUser();
      user.setUsername(map.get("id").toString());
      user.setGithubId(id);
      // Set the default Roles for users registered via Facebook
      List<SysRole> authorities = new ArrayList<>();
      SysRole role = new SysRole();
      role.setName("USER");
      authorities.add(role);
      //Oauth2Client客戶端特有角色
      authorities.add(getUserRoleByOauth2ClientName());
      user.setRoles(authorities);
      userService.createUser(user);
    }
    return user;
  }
}
