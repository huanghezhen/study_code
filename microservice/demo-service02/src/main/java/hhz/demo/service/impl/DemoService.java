package hhz.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName: TestService
 * @Description: TODO(概况)
 * @author: huanghz
 * @date: 2019/10/27 下午 09:37
 */
@Service
public class DemoService
{

    private final RestTemplate restTemplate;

    @Autowired
    public DemoService(RestTemplate restTemplate) {this.restTemplate = restTemplate;}


    public String echoService01(@PathVariable String str) {
        return restTemplate.getForObject("http://service01/echo/" + str, String.class);
    }
}
