package hhz.spring.cloud.alibaba.consumer.service;

import hhz.spring.cloud.alibaba.consumer.service.failback.EchoServiceFailback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @ClassName: EchoService
 * @Description: TODO(概况)
 * @author: huanghz
 * @date: 2019/10/4 下午 04:36
 */

@FeignClient(value = "service-provider" , fallback = EchoServiceFailback.class)
public interface EchoService
{
    @GetMapping("/echo/{string}")
    String echo(@PathVariable("string") String string);

    @GetMapping("/lb")
    String lb();
}
