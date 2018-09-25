package cn.hinson.controller;

import cn.hinson.domain.SysUser;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/user")
public class UserController {
    protected final Log logger = LogFactory.getLog(this.getClass());
    @GetMapping
    public Principal getUsers(Principal principal) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        logger.info(authentication.getName());
        return principal;
    }
}
