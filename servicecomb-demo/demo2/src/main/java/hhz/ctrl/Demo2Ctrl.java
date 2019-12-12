package hhz.ctrl;

import org.apache.servicecomb.provider.rest.common.RestSchema;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName: Demo2Ctrl
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/12/12 15:18
 */
@RestSchema(schemaId = "Demo2Ctrl")
@RequestMapping(path = "/")
public class Demo2Ctrl {

    @GetMapping("/echo2")
    public String echo2() {
        return "echo2";
    }
}
