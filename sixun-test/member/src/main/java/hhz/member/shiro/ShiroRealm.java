package hhz.member.shiro;

import hhz.common.entity.member.User;
import hhz.member.dao.MemberMapper;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @ClassName: ShiroRelm
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/12/23 13:34
 */
@Component
public class ShiroRealm extends AuthorizingRealm {

    @Autowired
    private MemberMapper memberMapper;

    /**
     * 授权
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        return null;
    }


    /**
     * 认证
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken upToken = (UsernamePasswordToken) authenticationToken;
        String username = upToken.getUsername();
        String password = new String(upToken.getPassword());
        User user = memberMapper.getUserByUsername(username);
        if (user != null && password.equals(user.getFPassword())) {
            return new SimpleAuthenticationInfo();
        }
        return null;
    }
}
