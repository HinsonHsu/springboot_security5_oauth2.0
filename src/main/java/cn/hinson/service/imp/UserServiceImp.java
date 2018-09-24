package cn.hinson.service.imp;

import cn.hinson.dao.UserDao;
import cn.hinson.domain.SysUser;
import cn.hinson.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public void createUser(SysUser sysUser) {
        userDao.create(sysUser);
    }

    @Override
    public SysUser getUserByName(String username) {
        return userDao.findByUserName(username);
    }

    @Override
    public SysUser getUserByTwitterId(String twitterId) {
        return userDao.findByTwitter(twitterId);
    }

    @Override
    public SysUser getUserByFacebookId(String facebookId) {
        return userDao.findByFacebook(facebookId);
    }

    @Override
    public SysUser getUserByGithubId(String githubId) {
        return userDao.findByGithub(githubId);
    }
}
