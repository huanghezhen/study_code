package hhz.thread.base;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: SynTest04
 * @Description: TODO
 * @author: huanghz
 * @date: 2019/7/5 16:29
 */
public class SynTest04
{
    public static void main(String[] args)
    {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 100000; i++)
        {
            new Thread(() -> {
                synchronized (list)
                {
                    list.add(Thread.currentThread().getName());
                }
            }).start();
        }
        try
        {
            Thread.sleep(1000*20);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        System.out.println(list.size());
    }
}
