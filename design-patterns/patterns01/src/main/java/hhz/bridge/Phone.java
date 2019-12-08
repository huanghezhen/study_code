package hhz.bridge;

/**
 * @ClassName: Phone
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/12/8 22:03
 */
public abstract class Phone {
    private Brand brand;

    public Phone(Brand brand) {
        this.brand = brand;
    }


    protected void open() {
        brand.open();
    }

    protected void close() {
        brand.close();
    }

    protected void call() {
        brand.call();
    }


}
