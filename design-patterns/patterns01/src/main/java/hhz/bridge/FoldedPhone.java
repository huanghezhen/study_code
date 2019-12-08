package hhz.bridge;

/**
 * @ClassName: FoldedPhone
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/12/8 22:15
 */
public class FoldedPhone extends Phone {
    public FoldedPhone(Brand brand) {
        super(brand);
    }


    public void open() {
        System.out.println("FoldedPhone");
        super.open();
    }

    public void close() {
        System.out.println("FoldedPhone");
        super.close();
    }

    public void call() {
        System.out.println("FoldedPhone");
        super.call();
    }
}
