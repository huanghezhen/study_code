package hhz.demo.ctrl;

import hhz.demo.service.iface.Demo1MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/updateMoney/{id}")
    public String updateMoney(@PathVariable("id") int id) {
        String ret = ""+id;
        try {
            demo1MainService.updateMoney(id);
        } catch (Exception e) {
            //e.printStackTrace();
            ret += " 异常!!!!!";
            System.out.println("异常!!!!!");
        }
        return ret;
    }
}
