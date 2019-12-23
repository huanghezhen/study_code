package hhz.member.ctrl;

import org.apache.servicecomb.provider.rest.common.RestSchema;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName: MemberCtrl
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/12/23 10:11
 */
@RestSchema(schemaId = "member")
@RequestMapping(path = "/member")
public class MemberCtrl {

    @GetMapping("/echo")
    public String echo() {
        return "member";
    }
}
