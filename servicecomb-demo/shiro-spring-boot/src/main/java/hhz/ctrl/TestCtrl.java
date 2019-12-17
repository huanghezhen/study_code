package hhz.ctrl;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @ClassName: TestCtrl
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/12/17 16:56
 */
@Controller
public class TestCtrl {
    @GetMapping("/templateTest")
    public String templateTest(Model model) {
        model.addAttribute("name", "hhh");
        return "test";
    }

    @GetMapping("/add")
    public String add() {
        return "user/add";
    }

    @GetMapping("/update")
    public String update() {
        return "user/update";
    }

    @GetMapping("/needLogin")
    public String needLogin() {
        return "login";
    }

    @PostMapping("/login")
    public String login(String username,String password) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        try {
            subject.login(token);
            return "test";
        } catch (AuthenticationException e) {
            e.printStackTrace();
            return "login";
        }
    }

}
