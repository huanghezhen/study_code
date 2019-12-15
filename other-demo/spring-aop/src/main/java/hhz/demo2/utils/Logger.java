package hhz.demo2.utils;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * @ClassName: Logger
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/12/15 10:56
 */
public class Logger {

    /**
     * 前置通知
     */
    public void before() {
        System.out.println("before");
    }

    /**
     * 后置通知
     */
    public void returning() {
        System.out.println("returning");
    }

    /**
     * 异常通知
     */
    public void throwing() {
        System.out.println("throwing");
    }

    /**
     * 最终通知
     */
    public void after() {
        System.out.println("after");
    }


    public Object around(ProceedingJoinPoint point) {
        try {
            point.proceed(point.getArgs());
            System.out.println("around");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return 5;
    }
}
