package hhz.thread.base;

/**
 * @ClassName: PriorityTest01
 * @Description: TODO
 * @author: huanghz
 * @date: 2019/7/5 14:11
 */
public class PriorityTest01
{
    public static void main(String[] args)
    {
        System.out.println(Thread.currentThread().getPriority());
        Thread t = new Thread(new MyPriority());
        t.setPriority(10);
        t.start();
        for (int i = 0; i < 100; i++)
        {
            System.out.println("main。。。"+i);
        }
    }
}

class MyPriority implements Runnable
{

    @Override
    public void run()
    {
        for (int i = 0; i < 100; i++)
        {
            System.out.println("啦啦啦。。。"+i);
        }

    }
}
