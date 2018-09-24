package cn.hinson.service;

import cn.hinson.domain.SysUser;

public interface UserService {
    void createUser(SysUser sysUser);
    SysUser getUserByName(String username);
    SysUser getUserByTwitterId(String twitterId);
    SysUser getUserByFacebookId(String facebookId);
    SysUser getUserByGithubId(String githubId);
}
