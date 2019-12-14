package hhz.demo1.proxy;

import java.lang.reflect.Proxy;

/**
 * @ClassName: Client
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/12/14 22:35
 */
public class Client {
    public static void main(String[] args) throws Exception {
        Producer producer = new Producer();
        IProducer iProducer = (IProducer) Proxy.newProxyInstance(producer.getClass().getClassLoader(),
                producer.getClass().getInterfaces(),
                (proxy, method, args1) -> {
                    System.out.println("开始买");
                    method.invoke(producer,args1);
                    System.out.println("结束买");
                    return null;
                });
        iProducer.sale("西瓜");
    }
}
