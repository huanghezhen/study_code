package hhz.member.shiro;

import org.apache.shiro.mgt.DefaultSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ShiroConfiguration {
    @Bean
    public DefaultSecurityManager defaultSecurityManager(ShiroRealm shiroRealm) {
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        defaultSecurityManager.setRealm(shiroRealm);
        return defaultSecurityManager;
    }
}
