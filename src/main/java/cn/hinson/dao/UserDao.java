package cn.hinson.dao;

import cn.hinson.domain.SysUser;

public interface UserDao {
    SysUser findByUserName(String username);
    SysUser findByFacebook(String facebookId);
    SysUser findByTwitter(String twitterId);
    SysUser findByGithub(String githubId);
    void create(SysUser sysUseruser);
}