package hhz.facade;

/**
 * @ClassName: DVDPlayer
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/12/10 11:18
 */
public class DVDPlayer {
    private static DVDPlayer instance = new DVDPlayer();

    public static DVDPlayer getInstance() {
        return instance;
    }

    public void on() {
        System.out.println("DVDPlayer on");
    }

    public void off() {
        System.out.println("DVDPlayer off");
    }

    public void play() {
        System.out.println("DVDPlayer play");
    }
}
