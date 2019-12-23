package hhz.shirodemo.ctrl;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: DemoTest
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/12/23 14:46
 */
@RestController
@RequestMapping("/demo")
public class DemoTest {

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }
}
