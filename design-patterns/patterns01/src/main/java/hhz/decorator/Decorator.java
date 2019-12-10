package hhz.decorator;

/**
 * @ClassName: Decorator
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/12/10 8:09
 */
public class Decorator extends Drink {

    private Drink drink;

    public Decorator(Drink drink) {
        this.drink = drink;
    }

    @Override
    public float cost() {
        return getPrice() + drink.cost();
    }

    @Override
    public String getDes() {
        return des + " " + getPrice() + " + " + drink.getDes();
    }
}
