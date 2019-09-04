package hhz.thread.expand;

/**
 * @ClassName: SynTest01
 * @Description: 线程安全 同步方法
 * @author: huanghz
 * @date: 2019/7/5 14:49
 */
public class SynTest02 implements Runnable
{

    private boolean flag = true;
    private int ticketNums = 500;
    @Override
    public void run()
    {
        while (flag)
        {
            test02();
        }
    }

    // 线程安全：尽可能锁定合理范围（不是指代码，而是指数据）
    public void test02()
    {
        if (ticketNums <= 0)
        {
            flag = false;
            return;
        }
        synchronized (this)
        {
            if (ticketNums <= 0)
            {
                flag = false;
                return;
            }
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
    }

    // 线程不安全
    public void test01()
    {
        synchronized ((Integer)ticketNums)
        {
            if (ticketNums <= 0)
            {
                flag = false;
                return;
            }
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
    }

    public static void main(String[] args)
    {
        // 出现重复
        SynTest02 synTest01 = new SynTest02();
        new Thread(synTest01,"01").start();
        new Thread(synTest01,"02").start();
        new Thread(synTest01,"03").start();
    }
}

