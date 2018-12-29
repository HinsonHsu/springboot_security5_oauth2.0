# springboot_security5_oauth2.0
Springboot Security5 Oauth2 集成Github、Facebook社交账号SSO登录

# 修改
登陆成功后，生成token
下次访问时候header中带有Authorization参数，参数值为：“Bearer “ + token
