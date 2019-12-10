package hhz.proxy.demo2;

import java.lang.reflect.Proxy;

/**
 * @ClassName: ProxyFactory
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/12/10 16:59
 */
public class ProxyFactory {
    private Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }

    public Object getProxyInstance() {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                (proxy, method, args) -> {
                    System.out.println("jdk代理开始");
                    Object invoke = method.invoke(target, args);
                    System.out.println("结束");
                    return invoke;
                });
    }
}
