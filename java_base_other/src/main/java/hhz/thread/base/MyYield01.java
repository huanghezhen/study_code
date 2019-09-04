package hhz.thread.base;

/**
 * @ClassName: MyYield01
 * @Description: TODO
 * @author: huanghz
 * @date: 2019/7/5 13:19
 */
public class MyYield01
{
    public static void main(String[] args)
    {
        MyYieldDemo myYieldDemo = new MyYieldDemo();
        new Thread(myYieldDemo,"小黄").start();
        new Thread(myYieldDemo,"小王").start();
    }
}

class MyYieldDemo implements Runnable
{

    @Override
    public void run()
    {
        System.out.println(Thread.currentThread().getName() + "-->start");
        Thread.yield();
        System.out.println(Thread.currentThread().getName()+"-->end");
    }
}
