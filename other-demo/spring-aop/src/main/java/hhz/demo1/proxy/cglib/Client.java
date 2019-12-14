package hhz.demo1.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;

/**
 * @ClassName: Client
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/12/14 22:47
 */
public class Client {
    public static void main(String[] args) throws Exception {
        Producer producer = new Producer();

        Producer o = (Producer) Enhancer.create(producer.getClass(), (MethodInterceptor) (o1, method, objects, methodProxy) -> {
            System.out.println("proxy start");
            Object invoke = method.invoke(producer, objects);
            System.out.println("proxy end");
            return invoke;
        });
        o.sale("hh");
    }
}
