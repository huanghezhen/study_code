package com.funtl.apache.dubbo.consumer.controller;

import com.funtl.apache.dubbo.provider.api.EchoService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: EchoController
 * @Description: TODO(概况)
 * @author: huanghz
 * @date: 2019/10/5 上午 10:48
 */
@RestController
public class EchoController {
    @Reference(version = "1.0.0")
    private EchoService echoService;
    @GetMapping(value = "/echo/{string}")
    public String echo(@PathVariable String string) {
        return echoService.echo(string);
    }
}
