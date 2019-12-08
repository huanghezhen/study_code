package hhz.demo.ctrl;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: DemoCtrl
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/12/7 11:00
 */
@RestController
public class DemoCtrl {

    @PostMapping("/getString")
    public String getString() {
        return "demo02";
    }
}
