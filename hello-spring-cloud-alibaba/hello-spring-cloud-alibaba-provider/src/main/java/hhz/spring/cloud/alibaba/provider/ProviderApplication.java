package hhz.spring.cloud.alibaba.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @ClassName: ProviderApplication
 * @Description: TODO(概况)
 * @author: huanghz
 * @date: 2019/10/4 下午 03:29
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ProviderApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(ProviderApplication.class, args);
    }
}
