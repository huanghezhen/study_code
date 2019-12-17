package hhz.shiro;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * @ClassName: UserRealm
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/12/17 17:16
 */
public class UserRealm extends AuthorizingRealm {
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("授权");

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        info.addStringPermission("");

        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("认证");
        String name = "1";
        String password = "1";

        UsernamePasswordToken token1 = (UsernamePasswordToken) token;
        if (!token1.getUsername().equals(name)) {
            return null;
        }
        return new SimpleAuthenticationInfo("",password,"");
    }
}
