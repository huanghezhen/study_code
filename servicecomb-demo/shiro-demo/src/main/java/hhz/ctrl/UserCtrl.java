package hhz.ctrl;

import org.apache.servicecomb.provider.rest.common.RestSchema;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName: UserCtrl
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/12/17 16:26
 */
@RestSchema(schemaId = "userCtrl")
@RequestMapping(path = "/")
public class UserCtrl {
    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/testThymeleaf")
    public String testThymeleaf(Model model) {
        model.addAttribute("name", "hhh");
        return "test";
    }
}
