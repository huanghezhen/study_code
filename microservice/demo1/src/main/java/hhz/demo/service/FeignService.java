package hhz.demo.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @ClassName: FeignService
 * @Description: TODO(概况)
 * @author: huanghz
 * @date: 2019/10/31 下午 02:56
 */
@FeignClient("demo2")
public interface FeignService
{
    @GetMapping("/echo/{data}")
    String echo(@PathVariable String data);
}
