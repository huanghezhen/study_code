package hhz.thread.base;

/**
 * @ClassName: AllState
 * @Description: TODO
 * @author: huanghz
 * @date: 2019/7/5 13:56
 */
public class AllState
{
    public static void main(String[] args)
    {
        Thread t = new Thread(()->{
            try
            {
                Thread.sleep(1000);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            System.out.println("...");
        });
        Thread.State state = t.getState();
        System.out.println(state);
        t.start();
        state = t.getState();
        System.out.println(state);

        while (true)
        {
            int num = Thread.activeCount();
            System.out.println("当前活动的线程数"+num);

            if (num == 2)
            {
                break;
            }
            try
            {
                Thread.sleep(500);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            state = t.getState();
            System.out.println(state);
        }
        state = t.getState();
        System.out.println(state);

    }
}
