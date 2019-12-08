package hhz.bridge;

/**
 * @ClassName: XiaoMi
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/12/8 22:02
 */
public class XiaoMi implements Brand {

    @Override
    public void open() {
        System.out.println("xiaomi open");
    }

    @Override
    public void close() {
        System.out.println("xiaomi close");
    }

    @Override
    public void call() {
        System.out.println("xiaomi call");
    }
}
