package hhz.demo.service.iface;

import hhz.demo.service.impl.FeignServiceFailback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @ClassName: FeignService
 * @Description: TODO(概况)
 * @author: huanghz
 * @date: 2019/10/29 上午 03:47
 */
@FeignClient(value = "service02")
public interface FeignService
{
    @RequestMapping(value = "/echo/{string}", method = RequestMethod.GET)
    String echo(@PathVariable String string);
}
