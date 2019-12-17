package hhz.ctrl;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
}
