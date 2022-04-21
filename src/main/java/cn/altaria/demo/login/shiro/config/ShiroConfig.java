package cn.altaria.demo.login.shiro.config;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.Filter;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.mgt.SessionsSecurityManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import cn.altaria.demo.login.login.config.LoginFilter;
import cn.altaria.demo.login.shiro.realm.CustomRealm;



/**
 * ShiroConfig
 *
 * @author xuzhou
 * @version v1.0.0
 * @create 2021/8/17 19:05
 */
@Configuration
public class ShiroConfig {

    @Bean
    public CustomRealm myRealm() {
        return new CustomRealm();
    }

    @Bean
    public SessionsSecurityManager securityManager(@Qualifier("myRealm") CustomRealm myRealm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(myRealm);
        return securityManager;
    }

    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(@Qualifier("securityManager") SessionsSecurityManager sessionsSecurityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        // 设置安全管理器
        shiroFilterFactoryBean.setSecurityManager(sessionsSecurityManager);

        Map<String, Filter> filters = shiroFilterFactoryBean.getFilters();
        filters.put("sso", new LoginFilter());
        shiroFilterFactoryBean.setFilters(filters);


        // 设置无权限时跳转url，登录请求
//        shiroFilterFactoryBean.setLoginUrl("/login");
        // 登录成功后进入页面
        shiroFilterFactoryBean.setSuccessUrl("/home");
        // 添加内置过滤器
        shiroFilterFactoryBean.setFilterChainDefinitionMap(initFilterChain());

        return shiroFilterFactoryBean;
    }

    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(@Qualifier("securityManager") SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }

    /**
     * 定义shiro过滤器配置
     * anon：无需认证就可以访问
     * authc：必须认证才能访问
     * user：必须拥有 记住我 功能才能用
     * perms：拥有对某个资源的权限能访问
     * role：拥有某个角色权限能访问
     *
     * @return map
     */
    private Map<String, String> initFilterChain() {
        Map<String, String> filterMap = new LinkedHashMap<>();


        // 静态资源放开验证
        filterMap.put("/**/*.js", "anon");
        filterMap.put("/**/*.js.map", "anon");
        filterMap.put("/**/*.css", "anon");
        filterMap.put("/**/*.png", "anon");
        filterMap.put("/**/*.jpg", "anon");
        filterMap.put("/**/*.gif", "anon");
        filterMap.put("/**/*.swf", "anon");
        filterMap.put("/**/*.ico", "anon");
        filterMap.put("/**/*.svg", "anon");
        filterMap.put("/**/*.eot", "anon");
        filterMap.put("/**/*.otf", "anon");
        filterMap.put("/**/*.ttf", "anon");
        filterMap.put("/**/*.woff", "anon");
        filterMap.put("/**/**.woff2", "anon");

        // 自定义过滤配置
        filterMap.put("/static/**", "anon");
        filterMap.put("/editor/**", "anon");
        filterMap.put("/region/**", "anon");
        filterMap.put("/register/**", "anon");
        filterMap.put("/wps/**", "anon");
        filterMap.put("/login/**", "anon");
        // 登出
//        filterMap.put("/logout", "logout");
        // 所有请求需要授权
        filterMap.put("/**", "sso");
        return filterMap;
    }

}
