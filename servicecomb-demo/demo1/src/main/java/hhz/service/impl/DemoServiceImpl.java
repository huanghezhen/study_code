package hhz.service.impl;

import hhz.dao.UserMapper;
import hhz.service.iface.DemoService;
import org.apache.servicecomb.pack.omega.context.annotations.SagaStart;
import org.apache.servicecomb.provider.springmvc.reference.RestTemplateBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName: DemoServiceImpl
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/12/12 15:47
 */
@Service
public class DemoServiceImpl implements DemoService {
    @Autowired
    private UserMapper userMapper;

    private RestTemplate template = RestTemplateBuilder.create();

    @Override
    @SagaStart
    public void updateMoney() {
        System.out.println("demo1 updateMoney");
        ResponseEntity<String> stringResponseEntity2 = template.postForEntity(
                "cse://demo2/updateMoney", null, String.class);
        ResponseEntity<String> stringResponseEntity3 = template.postForEntity(
                "cse://demo3/updateMoney", null, String.class);

        System.out.println(stringResponseEntity2.getBody());
        System.out.println(stringResponseEntity3.getBody());
    }

    public void cancel() {
        System.out.println("demo1 cancel");
        userMapper.addMoney();
    }
}
