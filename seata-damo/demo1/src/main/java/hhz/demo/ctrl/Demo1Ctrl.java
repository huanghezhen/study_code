package hhz.demo.ctrl;

import hhz.demo.service.iface.Demo1MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: Demo1Ctrl
 * @Description: TODO(概况)
 * @author: huanghz
 * @date: 2019/11/16 0016 16:34
 */
@RestController
public class Demo1Ctrl {

    @Autowired
    private Demo1MainService demo1MainService;

    @GetMapping("/updateMoney")
    public String updateMoney() {
        try {
            demo1MainService.updateMoney();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Demo1Ctrl";
    }
}
