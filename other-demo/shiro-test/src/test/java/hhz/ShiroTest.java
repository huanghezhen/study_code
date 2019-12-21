package hhz;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.subject.Subject;
import org.junit.Before;
import org.junit.Test;

/**
 * @ClassName: ShiroTest
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/12/21 9:50
 */
public class ShiroTest {
    private Subject subject;

    @Before
    public void before() {
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        //IniRealm iniRealm = new IniRealm("classpath:shiro01.ini");
        //IniRealm iniRealm = new IniRealm("classpath:shiro02.ini");
        defaultSecurityManager.setRealm(new PermissionRealm());
        SecurityUtils.setSecurityManager(defaultSecurityManager);
        subject = SecurityUtils.getSubject();
    }

    @Test
    public void shiro01() {
        String username = "zhangsan";
        String password = "123456";
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        try {
            subject.login(token);
            System.out.println(subject.getPrincipal());
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void shiro02() {
        String username = "zhangsan";
        String password = "123456";
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        subject.login(token);

        System.out.println(subject.hasRole("role1"));
        System.out.println(subject.isPermitted("user:delete"));
    }

    @Test
    public void shiro03() {
        String username = "zhangsan";
        String password = "123456";
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        subject.login(token);

        System.out.println(subject.hasRole("role1"));
        System.out.println(subject.isPermitted("user:delete"));
    }
}
