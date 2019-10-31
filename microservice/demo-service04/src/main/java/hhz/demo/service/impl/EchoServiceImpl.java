package hhz.demo.service.impl;

import hhz.demo.service.EchoService;
import org.apache.dubbo.config.annotation.Service;

/**
 * @ClassName: EchoServiceImpl
 * @Description: TODO(概况)
 * @author: huanghz
 * @date: 2019/10/31 下午 09:43
 */
@Service(version = "1.0.0")
public class EchoServiceImpl implements EchoService
{
    @Override
    public String echo(String data)
    {
        return "service04 " + data;
    }
}
