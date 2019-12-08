package hhz.demo.ctrl;

import hhz.demo.utils.HttpClientResult;
import hhz.demo.utils.HttpClientUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: DemoCtrl
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/12/7 11:00
 */
@RestController
public class DemoCtrl {

    @GetMapping("/getString")
    public String getString() {
        HttpClientResult result = new HttpClientResult();

        try {
            result = HttpClientUtils.doPost("http://172.17.0.1:8082/getString");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result.getContent();
    }
}
