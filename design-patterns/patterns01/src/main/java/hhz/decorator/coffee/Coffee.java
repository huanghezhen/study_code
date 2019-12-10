package hhz.decorator.coffee;

import hhz.decorator.Drink;

/**
 * @ClassName: Coffee
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/12/10 8:09
 */
public class Coffee extends Drink {
    @Override
    public float cost() {
        return getPrice();
    }
}
