package hhz.ctrl;

import org.apache.servicecomb.provider.rest.common.RestSchema;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName: Demo3Ctrl
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/12/12 15:19
 */
@RestSchema(schemaId = "Demo3Ctrl")
@RequestMapping(path = "/")
public class Demo3Ctrl {

    @GetMapping("/echo3")
    public String echo3() {
        return "echo3";
    }
}
