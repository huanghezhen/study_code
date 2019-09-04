package hhz.thread.base;

/**
 * @ClassName: JoinTest02
 * @Description: TODO
 * @author: huanghz
 * @date: 2019/7/5 13:41
 */
public class JoinTest02
{
    public static void main(String[] args)
    {
        System.out.println("爸爸和儿子买烟的故事");
        new Father().start();
    }
}

class Father extends Thread
{
    @Override
    public void run()
    {
        System.out.println("想抽烟，发现没了");
        System.out.println("让儿子去买中华");
        Thread son = new Son();
        son.start();
        try
        {
            // 老爸等待孩子中。。。（老爸被阻塞）
            son.join();

        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        System.out.println("老爸接过烟，把零钱给了儿子");
    }
}

class Son extends Thread
{
    @Override
    public void run()
    {
        System.out.println("接过老爸的钱");
        System.out.println("路边有个游戏厅玩了2秒");
        try
        {
            Thread.sleep(1000*2);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        System.out.println("2秒过去了");
        System.out.println("赶紧买烟去");
        System.out.println("手拿一包中华");
    }
}