package hhz.facade;

/**
 * @ClassName: Projector
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/12/10 11:21
 */
public class Projector {
    private static Projector instance = new Projector();

    public static Projector getInstance() {
        return instance;
    }

    public void on() {
        System.out.println("Projector on");
    }

    public void off() {
        System.out.println("Projector off");
    }

    public void play() {
        System.out.println("Projector play");
    }
}
