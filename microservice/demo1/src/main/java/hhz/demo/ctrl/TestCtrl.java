package hhz.demo.ctrl;

import hhz.demo.service.FeignService;
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
    private final RestTemplate restTemplate;

    @Autowired
    public TestCtrl(RestTemplate restTemplate) {this.restTemplate = restTemplate;}

    @Autowired
    private FeignService feignService;


    @GetMapping("/echo/{data}")
    public String echo(@PathVariable String data)
    {
        return "demo1 " + data;
    }

    @GetMapping("/getDemo2/{data}")
    public String getDemo2(@PathVariable String data)
    {
        return restTemplate.getForObject("http://demo2/echo/" + data, String.class);
    }

    @GetMapping("/getFeignDemo2/{data}")
    public String getFeignDemo2(@PathVariable String data)
    {
        return feignService.echo(data);
    }
}
