package hhz.pay.ctrl;

import org.apache.servicecomb.provider.rest.common.RestSchema;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName: PayCtrl
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/12/23 10:13
 */
@RestSchema(schemaId = "pay")
@RequestMapping(path = "/pay")
public class PayCtrl {
    @GetMapping("/echo")
    public String echo() {
        return "pay";
    }
}
