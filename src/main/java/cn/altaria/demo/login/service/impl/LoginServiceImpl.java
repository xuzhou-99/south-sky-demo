package cn.altaria.demo.login.service.impl;




import javax.security.auth.login.LoginException;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;


import cn.altaria.demo.login.service.ILoginService;
import lombok.extern.slf4j.Slf4j;

/**
 * LoginServiceImpl
 *
 * @author xuzhou
 * @version v1.0.0
 * @create 2021/5/31 10:34
 */
@Slf4j
@Service
public class LoginServiceImpl implements ILoginService {

    @Override
    public void login(String email, String password) throws LoginException {

        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(email, password);
        try {
            subject.login(token);
        } catch (UnknownAccountException e) {
            throw new LoginException("用户不存在！");
        } catch (IncorrectCredentialsException e) {
            throw new LoginException("用户名或密码错误！");
        }
    }

    @Override
    public void logout() {
        Subject subject = SecurityUtils.getSubject();
        if (null != subject) {
            if (subject.isAuthenticated() || subject.isRemembered()) {
                subject.logout();
            }
        }
        afterLogout();
    }

    /**
     * 登出后事件
     */
    protected void afterLogout() {

    }

}
