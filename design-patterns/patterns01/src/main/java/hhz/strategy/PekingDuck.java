package hhz.strategy;

/**
 * @ClassName: PekingDuck
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/12/11 15:38
 */
public class PekingDuck extends Duck {
    @Override
    public void display() {
        System.out.println("PekingDuck");
    }

    @Override
    public void fly() {
        System.out.println("no fly");
    }
}
