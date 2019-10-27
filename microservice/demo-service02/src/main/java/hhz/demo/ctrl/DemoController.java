package hhz.demo.ctrl;

import hhz.demo.service.impl.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
    @Autowired
    private DemoService demoService;

    @RequestMapping(value = "/echo/{string}", method = RequestMethod.GET)
    public String echo(@PathVariable String string) {
        return "service02 " + string;
    }

    @RequestMapping(value = "/echoService01/{string}", method = RequestMethod.GET)
    public String echoService01(@PathVariable String string) {

        return demoService.echoService01(string);
    }
}
