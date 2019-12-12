package hhz.ctrl;

import org.apache.servicecomb.provider.rest.common.RestSchema;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName: Demo1Ctrl
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/12/12 15:18
 */
@RestSchema(schemaId = "Demo1Ctrl")
@RequestMapping(path = "/")
public class Demo1Ctrl {

    @GetMapping("/echo1")
    public String echo1() {
        return "echo1";
    }
}
