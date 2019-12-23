package hhz.member.service.iface;

import hhz.common.entity.Result;
import hhz.member.entity.LoginQuery;

/**
 * @ClassName: MemberService
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/12/23 10:12
 */
public interface MemberService {
    Result login(LoginQuery loginQuery);
}
