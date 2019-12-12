package hhz.ctrl;

import hhz.service.iface.DemoService;
import org.apache.servicecomb.provider.rest.common.RestSchema;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private DemoService service;

    @GetMapping("/echo1")
    public String echo1() {
        return "echo1";
    }
    @GetMapping("/updateMoney")
    public String updateMoney() {
        service.updateMoney();
        return "demo1";
    }
}
