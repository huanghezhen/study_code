package hhz.demo.ctrl;

import hhz.demo.service.EchoService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: EchoCtrl
 * @Description: TODO(概况)
 * @author: huanghz
 * @date: 2019/10/31 下午 09:55
 */
@RestController
public class EchoCtrl
{
    @Reference(version = "1.0.0")
    private EchoService echoService;

    @GetMapping("/echo/{data}")
    public String echo(@PathVariable String data)
    {
        return echoService.echo(data);
    }
}
