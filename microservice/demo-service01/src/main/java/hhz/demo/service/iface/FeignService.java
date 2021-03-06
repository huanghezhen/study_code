package hhz.demo.service.iface;

import hhz.demo.service.impl.fallback.FeignServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @ClassName: FeignService
 * @Description: TODO(概况)
 * @author: huanghz
 * @date: 2019/10/29 上午 03:47
 */
@FeignClient(value = "service02", fallback = FeignServiceFallback.class)
public interface FeignService
{
    @GetMapping("/echo/{data}")
    String echo(@PathVariable String data);
}
