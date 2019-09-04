package hhz.thread.base;

/**
 * @ClassName: JoinTest01
 * @Description: TODO
 * @author: huanghz
 * @date: 2019/7/5 13:34
 */
public class JoinTest01
{
    public static void main(String[] args)
    {
        Thread t = new Thread(() -> {
            for (int i = 0; i < 100; i++)
            {
                System.out.println("hhh..." + i);
            }
        });
        t.start();

        for (int i = 0; i < 100; i++)
        {
            if (i == 50)
            {
                try
                {
                    // t 插队，main被阻塞
                    t.join();
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
            System.out.println("main..." + i);
        }
    }
}
