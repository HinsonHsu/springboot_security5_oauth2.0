package cn.hinson.controller;

import cn.hinson.dao.UserDao;
import cn.hinson.domain.SysUser;
import cn.hinson.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    UserService userService;

    @GetMapping
    public String test(){
        //访问这个url注册一个username：hinson1 password：password的用户
        SysUser sysUser = userService.getUserByName("hinson");
        if(sysUser == null){
            sysUser = new SysUser();
            sysUser.setUsername("hinson");
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            String tmp = passwordEncoder.encode("password");
            sysUser.setPassword(tmp);
            userService.createUser(sysUser);
        }
        return "success";
    }
}
