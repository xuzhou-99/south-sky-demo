package cn.altaria.demo.login.service;


import cn.altaria.demo.login.exception.LoginException;
import cn.altaria.demo.login.pojo.UserPojo;

/**
 * ILoginService
 *
 * @author xuzhou
 * @version v1.0.0
 * @create 2021/5/31 10:33
 */
public interface ILoginService {

    /**
     * 登录
     *
     * @param email    {@link UserPojo#getEmail()}
     * @param password {@link UserPojo#getPassword()}
     * @throws LoginException {@link LoginException}
     */
    void login(final String email, final String password) throws LoginException;

    /**
     * 登出
     */
    void logout();
}
