package hhz.demo.configure;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName: ConsumerConfiguration
 * @Description: TODO(概况)
 * @author: huanghz
 * @date: 2019/10/4 下午 04:03
 */
@Configuration
public class DemoConfiguration
{
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
