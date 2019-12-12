package hhz.ctrl;

import hhz.service.iface.DemoService;
import org.apache.servicecomb.provider.rest.common.RestSchema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
    @Autowired
    private DemoService service;

    @GetMapping("/echo2")
    public String echo2() {
        return "echo2";
    }

    @PostMapping("/updateMoney")
    public String updateMoney() {
        service.updateMoney();
        return "demo2";
    }
}
