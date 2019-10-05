package hhz.spring.cloud.alibaba.consumer.service.failback;

import hhz.spring.cloud.alibaba.consumer.service.EchoService;
import org.springframework.stereotype.Component;

/**
 * @ClassName: EchoServiceFailback
 * @Description: TODO(概况)
 * @author: huanghz
 * @date: 2019/10/4 下午 09:45
 */
@Component
public class EchoServiceFailback implements EchoService
{
    @Override
    public String echo(String string)
    {
        return "你的网络有问题 echo";
    }

    @Override
    public String lb()
    {
        return "你的网络有问题 lb";
    }
}
