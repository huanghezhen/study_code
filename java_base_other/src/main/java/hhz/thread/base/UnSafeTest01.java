package hhz.thread.base;

/**
 * @ClassName: UnSafeTest01
 * @Description: 线程不安全，有负数，也有相同的情况
 * @author: huanghz
 * @date: 2019/7/5 14:49
 */
public class UnSafeTest01
{
    public static void main(String[] args)
    {
        // 出现重复
        UnsafeWeb12306 web12306 = new UnsafeWeb12306();
        new Thread(web12306,"01").start();
        new Thread(web12306,"02").start();
        new Thread(web12306,"03").start();
    }
}

class UnsafeWeb12306 implements Runnable
{
    private boolean flag = true;
    private int ticketNums = 10;
    @Override
    public void run()
    {
        while (flag)
        {
            test01();
        }
    }

    public void test01()
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

}
