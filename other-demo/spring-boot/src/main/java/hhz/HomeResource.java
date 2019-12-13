package hhz;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: HomeResource
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/12/13 13:08
 */
@RestController
@RequestMapping("/api")
public class HomeResource {
    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }
}
