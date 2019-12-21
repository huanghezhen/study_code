package hhz.shiro.controller;

import hhz.shiro.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Enumeration;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequiresPermissions("user-home")
    @RequestMapping(value = "/user/home",method = RequestMethod.GET)
    public String home() {
        return "主页";
    }


    //添加
    @RequestMapping(value = "/user",method = RequestMethod.POST)
    public String add() {
        return "添加用户成功";
    }
	
    //查询
    @RequestMapping(value = "/user",method = RequestMethod.GET)
    public String find() {
        return "查询用户成功";
    }
	
    //更新
    @RequestMapping(value = "/user/{id}",method = RequestMethod.GET)
    public String update(String id) {
        return "更新用户成功";
    }
	
    //删除
    @RequestMapping(value = "/user/{id}",method = RequestMethod.DELETE)
    public String delete() {
        return "删除用户成功";
    }

    //用户登录
    @RequestMapping(value = "/login")
    public String login(String username, String password) {

        password = new Md5Hash(password, "hhz",5).toString();

        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, password);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(usernamePasswordToken);
        } catch (AuthenticationException e) {
            return "用户名或者密码错误";
        }
        return "登录成功";
    }


    @RequestMapping("/show")
    public String show(HttpSession session) {
        Enumeration enumeration = session.getAttributeNames();
        while (enumeration.hasMoreElements()) {
            String name = enumeration.nextElement().toString();
            Object attribute = session.getAttribute(name);
            System.out.println("<B>"+name+"</B>"+attribute+"<br/>/n");
        }
        return "成功";
    }
    @RequestMapping("/authError")
    public String authError(int code) {
        return code == 1 ? "未授权" : "未登录";
    }
}
