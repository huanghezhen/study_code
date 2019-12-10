package hhz.decorator;

/**
 * @ClassName: Milk
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/12/10 8:10
 */
public class Milk extends Decorator {
    public Milk(Drink drink) {
        super(drink);
        setDes("Milk");
        setPrice(3.0f);
    }
}
