package hhz.demo.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName: TestCtrl
 * @Description: TODO(概况)
 * @author: huanghz
 * @date: 2019/10/31 下午 02:35
 */
@RestController
public class TestCtrl
{
    @GetMapping("/echo/{data}")
    public String echo(@PathVariable String data)
    {
        return "demo2 " + data;
    }
}
