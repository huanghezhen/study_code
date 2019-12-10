package hhz.decorator;

/**
 * @ClassName: Soy
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/12/10 8:11
 */
public class Soy extends Decorator {
    public Soy(Drink drink) {
        super(drink);
        setDes("Soy");
        setPrice(3.0f);
    }
}
