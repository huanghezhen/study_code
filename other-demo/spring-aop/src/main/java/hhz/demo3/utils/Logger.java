package hhz.demo3.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @ClassName: Logger
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/12/15 10:56
 */
@Component
@Aspect
public class Logger {

    @Pointcut("execution(* hhz.demo3.service.impl.*.*(..))")
    private void pt1() {

    }

    /**
     * 前置通知
     */
    //@Before("pt1()")
    public void before() {
        System.out.println("before");
    }

    /**
     * 后置通知
     */
    //@AfterReturning("pt1()")
    public void returning() {
        System.out.println("returning");
    }

    /**
     * 异常通知
     */
    //@AfterThrowing("pt1()")
    public void throwing() {
        System.out.println("throwing");
    }

    /**
     * 最终通知
     */
    //@After("pt1()")
    public void after() {
        System.out.println("after");
    }


    @Around("pt1()")
    public Object around(ProceedingJoinPoint point) {
        try {
            System.out.println("around1");
            point.proceed(point.getArgs());
            System.out.println("around2");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            System.out.println("around3");
        } finally {
            System.out.println("around4");
        }
        return 5;
    }
}
