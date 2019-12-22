package hhz.system;

import hhz.common.shiro.session.CustomSessionManager;
import hhz.system.shiro.realm.IhrmRealm;
import hhz.system.shiro.realm.UserRealm;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.crazycake.shiro.RedisCacheManager;
import org.crazycake.shiro.RedisManager;
import org.crazycake.shiro.RedisSessionDAO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfiguration {

    //1.创建realm
    @Bean
    public IhrmRealm getRealm() {
        return new UserRealm();
    }

    @Bean
    public SecurityManager getSecurityManager(IhrmRealm realm,DefaultWebSessionManager defaultWebSessionManager,RedisCacheManager redisCacheManager) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(realm);
        securityManager.setSessionManager(defaultWebSessionManager);
        securityManager.setCacheManager(redisCacheManager);
        return securityManager;
    }

    @Bean
    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager) {
        ShiroFilterFactoryBean filterFactory = new ShiroFilterFactoryBean();
        filterFactory.setSecurityManager(securityManager);
        filterFactory.setLoginUrl("/authError?code=1");//跳转url地址
        filterFactory.setUnauthorizedUrl("/authError?code=2");//未授权的url
        Map<String,String> filterMap = new LinkedHashMap<>();
        //filterMap.put("/user/home","anon");//当前请求地址可以匿名访问
        //filterMap.put("/user/home", "perms[user-home]");
        filterMap.put("/sys/login", "anon");
        filterMap.put("/authError", "anon");
        filterMap.put("/**","authc");//当前请求地址必须认证之后可以访问
        filterFactory.setFilterChainDefinitionMap(filterMap);
        return filterFactory;
    }

    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
        advisor.setSecurityManager(securityManager);
        return advisor;
    }


    /**
     * 1 redis
     * 2 sessionDao
     * 3 会话管理器
     * 4 缓存管理器
     */


    @Value("${spring.redis.host}")
    private String host;
    @Value("${spring.redis.port}")
    private int port;

    @Bean
    public RedisManager redisManager() {
        RedisManager redisManager = new RedisManager();
        redisManager.setHost(host);
        redisManager.setPort(port);
        return redisManager;
    }

    @Bean
    public RedisSessionDAO redisSessionDAO(RedisManager redisManager) {
        RedisSessionDAO redisSessionDAO = new RedisSessionDAO();
        redisSessionDAO.setRedisManager(redisManager);
        return redisSessionDAO;
    }

    /**
     * 会话管理器
     * @param redisSessionDAO
     * @return
     */
    @Bean
    public DefaultWebSessionManager defaultWebSessionManager(RedisSessionDAO redisSessionDAO) {
        CustomSessionManager sessionManager = new CustomSessionManager();
        sessionManager.setSessionDAO(redisSessionDAO);
        return sessionManager;
    }

    @Bean
    public RedisCacheManager redisCacheManager(RedisManager redisManager) {
        RedisCacheManager redisCacheManager = new RedisCacheManager();
        redisCacheManager.setRedisManager(redisManager);
        return redisCacheManager;
    }
}
