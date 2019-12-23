package hhz.member.ctrl;

import hhz.common.entity.Result;
import hhz.member.entity.LoginQuery;
import hhz.member.service.iface.MemberService;
import org.apache.servicecomb.provider.rest.common.RestSchema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName: MemberCtrl
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/12/23 10:11
 */
@RestSchema(schemaId = "member")
@RequestMapping(path = "/member")
public class MemberCtrl {

    @Autowired
    private MemberService memberService;

    @GetMapping("/echo")
    public String echo() {
        return "member";
    }


    @PostMapping("/login")
    public Result login(@RequestBody LoginQuery loginQuery) {
        return memberService.login(loginQuery);
    }
}
