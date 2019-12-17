package hhz.entity;

import lombok.Data;

import java.util.ArrayList;

/**
 * @ClassName: XcUserExt
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/12/17 13:40
 */
@Data
public class XcUserExt {
    private String username;
    private String password;
    private ArrayList<XcMenu> permissions;
    private String id;
    private String utype;
    private String companyId;
    private String name;
    private String userpic;
}
