package hhz.common.controller;

import hhz.common.entity.Result;
import hhz.common.entity.ResultCode;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: ErrorController
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/12/22 16:12
 */
@RestController
public class ErrorController {

    @RequestMapping("/authError")
    public Result authError(int code) {
        return code == 1 ? new Result(ResultCode.UNAUTHENTICATED) : new Result(ResultCode.UNAUTHORISE);
    }
}
