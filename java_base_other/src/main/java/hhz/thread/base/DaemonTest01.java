package hhz.thread.base;

/**
 * @ClassName: DaemonTest01
 * @Description: TODO
 * @author: huanghz
 * @date: 2019/7/5 14:19
 */
public class DaemonTest01
{
    public static void main(String[] args)
    {
        Thread you = new You01();
        Thread god = new God();
        // 设置为守护线程
        god.setDaemon(true);
        god.start();

        you.start();
    }
}

class You01 extends Thread
{
    @Override
    public void run()
    {
        for (int i = 1; i < 365 * 100; i++)
        {
            System.out.println("happy life");
        }
        System.out.println(".........");
    }
}

class God extends Thread
{
    @Override
    public void run()
    {
        while (true)
        {
            System.out.println("bless you");
        }
    }
}