package hhz.strategy;

/**
 * @ClassName: Duck
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/12/11 15:35
 */
public abstract class Duck {

    public abstract void display();

    public void quack(){
        System.out.println("quack");
    }

    public void swim() {
        System.out.println("swim");
    }

    public void fly() {
        System.out.println("fly");
    }
}
