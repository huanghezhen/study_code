package hhz.thread.base;

/**
 * @ClassName: SynTest01
 * @Description: 线程安全 同步方法
 * @author: huanghz
 * @date: 2019/7/5 14:49
 */
public class SynTest01 implements Runnable
{

    private boolean flag = true;
    private int ticketNums = 1000;
    @Override
    public void run()
    {
        while (flag)
        {
            test01();
        }
    }

    public synchronized void test01()
    {
        if (ticketNums <= 0)
        {
            flag = false;
            return;
        }
        // 如果睡了200毫秒就会出现数据问题
        try
        {
            Thread.sleep(20);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+":"+ticketNums--);
    }

    public static void main(String[] args)
    {
        // 出现重复
        SynTest01 synTest01 = new SynTest01();
        new Thread(synTest01,"01").start();
        new Thread(synTest01,"02").start();
        new Thread(synTest01,"03").start();
    }
}

