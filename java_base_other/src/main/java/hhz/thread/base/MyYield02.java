package hhz.thread.base;

/**
 * @ClassName: MyYield02
 * @Description: TODO
 * @author: huanghz
 * @date: 2019/7/5 13:24
 */
public class MyYield02
{
    public static void main(String[] args)
    {
        new Thread(() -> {
            for (int i = 0; i < 100; i++)
            {
                System.out.println("hhh..." + i);
            }
        }).start();

        for (int i = 0; i < 100; i++)
        {
            if (i % 10 == 0)
            {
                Thread.yield();
            }
            System.out.println("main..." + i);
        }

    }
}
