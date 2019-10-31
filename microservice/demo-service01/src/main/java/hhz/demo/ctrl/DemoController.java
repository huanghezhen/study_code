package hhz.demo.ctrl;

import hhz.demo.service.iface.FeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

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

    private final RestTemplate restTemplate;

    @Autowired
    public DemoController(RestTemplate restTemplate) {this.restTemplate = restTemplate;}


    @GetMapping("/echo/{data}")
    public String echo(@PathVariable String data)
    {
        return "service01 " + data;
    }

    @GetMapping("/echoService02/{data}")
    public String echoService02(@PathVariable String data) {
        return restTemplate.getForObject("http://service02/echo/" + data, String.class);
    }

    @GetMapping("/echoFeignService02/{data}")
    public String echoFeignService02(@PathVariable String data) {
        return feignService.echo(data);
    }

}
