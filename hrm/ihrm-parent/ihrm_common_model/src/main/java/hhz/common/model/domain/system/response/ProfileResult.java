package hhz.common.model.domain.system.response;


import hhz.common.model.domain.system.Permission;
import hhz.common.model.domain.system.Role;
import hhz.common.model.domain.system.User;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.*;

@Setter
@Getter
public class ProfileResult implements Serializable {

    private static final long serialVersionUID = -7130312081850155744L;

    private String mobile;
    private String username;
    private String company;
    private String companyId;
    private Map<String, Object> roles = new HashMap<>();


    /**
     * @param user
     */
    public ProfileResult(User user, List<Permission> list) {
        this.mobile = user.getMobile();
        this.username = user.getUsername();
        this.company = user.getCompanyName();

        Set<String> menus = new HashSet<>();
        Set<String> points = new HashSet<>();
        Set<String> apis = new HashSet<>();

        for (Permission perm : list) {
            String code = perm.getCode();
            if (perm.getType() == 1) {
                menus.add(code);
            } else if (perm.getType() == 2) {
                points.add(code);
            } else {
                apis.add(code);
            }
        }
        this.roles.put("menus", menus);
        this.roles.put("points", points);
        this.roles.put("apis", apis);
    }

    public ProfileResult(User user) {
        this.mobile = user.getMobile();
        this.username = user.getUsername();
        this.company = user.getCompanyName();

        Set<Role> roles = user.getRoles();
        Set<String> menus = new HashSet<>();
        Set<String> points = new HashSet<>();
        Set<String> apis = new HashSet<>();
        for (Role role : roles) {
            Set<Permission> perms = role.getPermissions();
            for (Permission perm : perms) {
                String code = perm.getCode();
                if (perm.getType() == 1) {
                    menus.add(code);
                } else if (perm.getType() == 2) {
                    points.add(code);
                } else {
                    apis.add(code);
                }
            }
        }

        this.roles.put("menus", menus);
        this.roles.put("points", points);
        this.roles.put("apis", apis);
    }
}
