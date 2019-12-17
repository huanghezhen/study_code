package hhz.ctrl;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: TestCtrl
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/12/17 16:56
 */
@RestController
public class TestCtrl {
    @GetMapping("/templateTest")
    public String templateTest(Model model) {
        return "test";
    }
}
