package cn.altaria.demo.login.shiro.realm;

import javax.annotation.Resource;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import cn.altaria.demo.login.pojo.UserPojo;
import cn.altaria.demo.login.service.IUserService;


/**
 * CustomRealm
 *
 * @author xuzhou
 * @version v1.0.0
 * @create 2021/8/17 18:56
 */
public class CustomRealm extends AuthorizingRealm {

    @Resource
    private IUserService userService;

    /**
     * 权限配置
     *
     * @param principals {@link PrincipalCollection}
     * @return {@link AuthorizationInfo}
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

        return null;
    }

    /**
     * 认证配置
     *
     * @param token {@link AuthenticationToken}
     * @return {@link AuthenticationInfo}
     * @throws AuthenticationException 认证异常
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = (String) token.getPrincipal();
        if (username == null) {
            return null;
        }
        UserPojo userPojo = userService.load(null, username, null, null);
        if (userPojo == null) {
            return null;
        }
        return new SimpleAuthenticationInfo(username, userPojo.getPassword(), getName());
    }
}
