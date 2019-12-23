package hhz.order.ctrl;

import org.apache.servicecomb.provider.rest.common.RestSchema;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName: OrderCtrl
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/12/23 10:12
 */
@RestSchema(schemaId = "order")
@RequestMapping(path = "/order")
public class OrderCtrl {
    @GetMapping("/echo")
    public String echo() {
        return "order";
    }
}
