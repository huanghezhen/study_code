package hhz.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @ClassName: Service02Application
 * @Description: TODO(概况)
 * @author: huanghz
 * @date: 2019/10/27 下午 04:56
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class Service03Application
{
    public static void main(String[] args)
    {
        SpringApplication.run(Service03Application.class, args);
    }

}
