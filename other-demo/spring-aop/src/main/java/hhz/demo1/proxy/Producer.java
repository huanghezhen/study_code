package hhz.demo1.proxy;

/**
 * @ClassName: Producer
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/12/14 22:26
 */
public class Producer implements IProducer{

    @Override
    public void sale(String name) {
        System.out.println("买了"+name);
    }
}
