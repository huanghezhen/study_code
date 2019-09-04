package hhz.thread.base;

/**
 * @ClassName: BlockedSleep01
 * @Description: TODO
 * @author: huanghz
 * @date: 2019/7/5 12:49
 */
public class BlockedSleep01 implements Runnable
{
    private int ticketNums = 99;
    @Override
    public void run()
    {
        while (true)
        {
            if (ticketNums <= 0)
            {
                break;
            }
            try
            {
                Thread.sleep(200);
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
        BlockedSleep01 web12306 = new BlockedSleep01();

        new Thread(web12306,"01").start();
        new Thread(web12306,"02").start();
        new Thread(web12306,"03").start();
    }
}
