package hhz.system.shiro.realm;

import hhz.common.model.domain.system.Permission;
import hhz.common.model.domain.system.User;
import hhz.common.model.domain.system.response.ProfileResult;
import hhz.system.service.PermissionService;
import hhz.system.service.UserService;
import org.apache.shiro.authc.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: UserRealm
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/12/22 15:18
 */
public class UserRealm extends IhrmRealm {

    @Autowired
    private UserService userService;
    @Autowired
    private PermissionService permissionService;

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
        String mobile = usernamePasswordToken.getUsername();
        String password = new String(usernamePasswordToken.getPassword());

        User user = userService.findByMobile(mobile);
        if (user != null && user.getPassword().equals(password)) {


            ProfileResult result = null;

            if ("user".equals(user.getLevel())) {
                result = new ProfileResult(user);
            }else{
                Map map = new HashMap();
                if ("coAdmin".equals(user.getLevel())) {
                    map.put("enVisible", "1");
                }
                List<Permission> all = permissionService.findAll(map);
                result = new ProfileResult(user,all);
            }

            return new SimpleAuthenticationInfo(result, user.getPassword(), this.getName());
        }


        return null;
    }
}
