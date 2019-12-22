package hhz.common.interceptor;

import hhz.common.entity.ResultCode;
import hhz.common.exception.CommonException;
import hhz.common.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName: JwtInterceptor
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/12/20 15:07
 */

public class JwtInterceptor extends HandlerInterceptorAdapter {
    @Autowired
    private JwtUtils jwtUtils;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String authorization = request.getHeader("Authorization");
        if (!StringUtils.isEmpty(authorization)) {
            //2.替换Bearer+空格
            String token = authorization.replace("Bearer ", "");
            //3.解析token
            Claims claims = jwtUtils.parseJwt(token);
            if (claims != null) {

                String apis = (String) claims.get("apis");
                HandlerMethod h = (HandlerMethod) handler;
                RequestMapping methodAnnotation = h.getMethodAnnotation(RequestMapping.class);
                String name = methodAnnotation.name();
                if (apis.contains(name)) {
                    request.setAttribute("user_claims",claims);
                    return true;
                }else{
                    throw new CommonException(ResultCode.UNAUTHORISE);
                }
            }
        }
        throw new CommonException(ResultCode.UNAUTHENTICATED);
    }
}
