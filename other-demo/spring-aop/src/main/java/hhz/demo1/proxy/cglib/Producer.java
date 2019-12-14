package hhz.demo1.proxy.cglib;

import hhz.demo1.proxy.IProducer;

/**
 * @ClassName: Producer
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/12/14 22:26
 */
public class Producer{

    public void sale(String name) {
        System.out.println("买了"+name);
    }
}
