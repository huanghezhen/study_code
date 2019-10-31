package hhz.demo.ctrl;

import hhz.demo.service.iface.FeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName: TestController
 * @Description: TODO(概况)
 * @author: huanghz
 * @date: 2019/10/27 下午 09:33
 */
@RestController
public class DemoController
{
    @Autowired
    private FeignService feignService;

    @GetMapping("/echo/{data}")
    public String echo(@PathVariable String data)
    {
        return "service01 " + data;
    }


    @RequestMapping(value = "/echoService02/{string}", method = RequestMethod.GET)
    public String echoService02(@PathVariable String string) {

        return feignService.echo(string);
    }

}
