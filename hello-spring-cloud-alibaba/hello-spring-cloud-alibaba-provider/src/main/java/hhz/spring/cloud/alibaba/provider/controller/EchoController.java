package hhz.spring.cloud.alibaba.provider.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import rx.annotations.Beta;

/**
 * @ClassName: EchoController
 * @Description: TODO(概况)
 * @author: huanghz
 * @date: 2019/10/4 下午 03:33
 */

@RestController
public class EchoController
{

    @Value("${server.port}")
    private String port;

    @GetMapping("/echo/{string}")
    public String echo(@PathVariable("string") String string)
    {
        System.out.println("请求开始");
        return "Hello Nacos Provider " + string;
    }

    @GetMapping("/lb")
    public String lb()
    {
        return "from Provider " + port;
    }
}
