package hhz;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: PermissionRealm
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/12/21 10:24
 */
public class PermissionRealm extends AuthorizingRealm {

/*
    @Override
    public void setName(String name) {
        super.setName("permissionRealm");
    }
*/

    /**
     * 授权
     *
     * @param principals
     * @return
     */
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

        String username = (String) principals.getPrimaryPrincipal();
        List<String> perms = new ArrayList<String>();
        perms.add("user:save");
        perms.add("user:update");
        perms.add("user:delete");
        List<String> roles = new ArrayList<String>();
        roles.add("role1");
        roles.add("role2");

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addStringPermissions(perms);
        info.addRoles(roles);


        return info;
    }


    /**
     * 认证
     *
     * @param token
     * @return
     * @throws AuthenticationException
     */
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
        String username = usernamePasswordToken.getUsername();
        String password = new String(usernamePasswordToken.getPassword());
        if ("123456".equals(password)) {
            SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(username, password, getName());
            return simpleAuthenticationInfo;
        }else{
            throw new RuntimeException("登录失败");
        }
    }
}
