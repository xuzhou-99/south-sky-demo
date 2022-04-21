package cn.altaria.demo.login.login.service;

/**
 * ISsoService
 *
 * @author xuzhou
 * @version v1.0.0
 * @date 2022/4/19 16:50
 */
public interface ISsoService {
    /**
     * 注销
     *
     * @param logoutUrl 登出url
     * @param token     sso发布的令牌
     */
    void logout(String logoutUrl, String token);

    /**
     * 校验令牌
     *
     * @param url   sso校验令牌请求
     * @param token 令牌
     * @return 校验结果
     */
    boolean verify(String url, String token);
}
