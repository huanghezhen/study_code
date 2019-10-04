package hhz.spring.cloud.alibaba.consumer.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @ClassName: EchoService
 * @Description: TODO(概况)
 * @author: huanghz
 * @date: 2019/10/4 下午 04:36
 */

@FeignClient("service-provider")
public interface EchoService
{
    @GetMapping("/echo/{string}")
    String echo(@PathVariable("string") String string);

    @GetMapping("/lb")
    String lb();
}
