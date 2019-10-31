package hhz.demo.ctrl;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: TestController
 * @Description: TODO(概况)
 * @author: huanghz
 * @date: 2019/10/27 下午 09:33
 */
@RestController
public class DemoController
{

    @GetMapping("/echo/{string}")
    public String echo(@PathVariable String string) {
        return "service02 " + string;
    }

}
