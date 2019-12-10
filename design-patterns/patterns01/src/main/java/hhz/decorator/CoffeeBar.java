package hhz.decorator;

import hhz.decorator.coffee.LongBlack;

/**
 * @ClassName: CoffeeBar
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/12/10 8:09
 */
public class CoffeeBar {
    public static void main(String[] args) throws Exception {
        LongBlack longBlack = new LongBlack();
        Milk milk = new Milk(longBlack);
        milk = new Milk(milk);
        String des = milk.getDes();
        System.out.println(des);
    }
}
