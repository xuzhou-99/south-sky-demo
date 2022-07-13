package cn.altaria.demo.login.service;


import cn.altaria.demo.login.pojo.UserPojo;

/**
 * IUserService
 *
 * @author xuzhou
 * @version 1.0.0
 * @date 2021/4/9 17:06
 */
public interface IUserService {


    /**
     * 获取用户
     *
     * @param id       用户ID
     * @param email    邮箱
     * @param username 用户名
     * @param mobile   手机号
     * @return {@link UserPojo}
     */
    UserPojo load(String id, String email, String username, String mobile);
}
