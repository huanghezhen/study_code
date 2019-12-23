package hhz.member.service.impl;

import hhz.common.entity.Result;
import hhz.common.entity.ResultEnum;
import hhz.member.entity.LoginQuery;
import hhz.member.service.iface.MemberService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;

/**
 * @ClassName: MemberServiceImpl
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/12/23 10:12
 */
@Service
public class MemberServiceImpl implements MemberService {
    @Override
    public Result login(LoginQuery loginQuery) {
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(loginQuery.getUsername(), loginQuery.getPassword());
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(usernamePasswordToken);
            String id = (String) subject.getSession().getId();
            return new Result(id);
        } catch (AuthenticationException e) {
            return new Result(ResultEnum.LOGIN_ERROR);
        }
    }
}
