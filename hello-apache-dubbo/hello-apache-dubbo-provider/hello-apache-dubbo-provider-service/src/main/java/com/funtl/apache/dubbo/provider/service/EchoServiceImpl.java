package com.funtl.apache.dubbo.provider.service;

import com.funtl.apache.dubbo.provider.api.EchoService;
import org.apache.dubbo.config.annotation.Service;

/**
 * @ClassName: EchoServiceImpl
 * @Description: TODO(概况)
 * @author: huanghz
 * @date: 2019/10/4 下午 10:52
 */

@Service(version = "1.0.0")
public class EchoServiceImpl implements EchoService
{
    @Override
    public String echo(String string)
    {
        return "Echo Hello Dubbo " + string;
    }
}
