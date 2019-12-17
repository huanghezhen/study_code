package com.itheima.controller.advice;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName: HandlerControllerException
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/12/16 23:32
 */
@Component
public class HandlerControllerException implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("ErrorMsg", ex.getMessage());
        if (ex instanceof AccessDeniedException) {
            mv.setViewName("forward:/403.jsp");
        }else{
            mv.setViewName("forward:/500.jsp");
        }
        return mv;
    }
}
