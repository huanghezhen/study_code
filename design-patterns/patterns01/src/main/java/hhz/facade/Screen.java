package hhz.facade;

/**
 * @ClassName: Screen
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/12/10 11:21
 */
public class Screen {
    private static Screen instance = new Screen();

    public static Screen getInstance() {
        return instance;
    }

    public void on() {
        System.out.println("Screen on");
    }

    public void off() {
        System.out.println("Screen off");
    }

    public void play() {
        System.out.println("Screen play");
    }
}
