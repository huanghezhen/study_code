package hhz.ctrl;

import hhz.service.iface.DemoService;
import org.apache.servicecomb.provider.rest.common.RestSchema;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private DemoService service;

    @GetMapping("/echo3")
    public String echo3() {
        return "echo3";
    }

    @GetMapping("/updateMoney")
    public String updateMoney() {
        service.updateMoney();
        return "demo3";
    }
}
