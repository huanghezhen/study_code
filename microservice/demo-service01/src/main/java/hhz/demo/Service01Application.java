package hhz.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @ClassName: Service01Application
 * @Description: TODO(概况)
 * @author: huanghz
 * @date: 2019/10/27 下午 04:57
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class Service01Application
{
    public static void main(String[] args)
    {
        SpringApplication.run(Service01Application.class, args);
    }

}
