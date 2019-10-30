package hhz.demo.service.impl;

import hhz.demo.service.iface.FeignService;
import org.springframework.stereotype.Component;

/**
 * @ClassName: FeignServiceFailback
 * @Description: TODO(概况)
 * @author: huanghz
 * @date: 2019/10/29 下午 03:59
 */
@Component
public class FeignServiceFailback implements FeignService
{
    @Override
    public String echo(String string)
    {
        return "error";
    }
}
