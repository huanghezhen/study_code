package hhz.decorator;

/**
 * @ClassName: Chocolate
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/12/10 8:09
 */
public class Chocolate extends Decorator {
    public Chocolate(Drink drink) {
        super(drink);
        setDes("Chocolate");
        setPrice(3.0f);
    }
}
