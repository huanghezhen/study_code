package hhz.thread.base;

/**
 * @ClassName: Web12306
 * @Description: TODO
 * @author: huanghz
 * @date: 2019/7/5 10:37
 */
public class Web12306 implements Runnable
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
            // 如果睡了200毫秒就会出现数据问题
           /* try
            {
                Thread.sleep(200);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }*/
            System.out.println(Thread.currentThread().getName()+":"+ticketNums--);
        }
    }

    public static void main(String[] args)
    {
        Web12306 web12306 = new Web12306();

        new Thread(web12306,"01").start();
        new Thread(web12306,"02").start();
        new Thread(web12306,"03").start();
    }
}
