package hhz.thread.base;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName: BlockedSleep02
 * @Description: 倒计时
 * @author: huanghz
 * @date: 2019/7/5 12:53
 */
public class BlockedSleep02
{
    public static void main(String[] args)
    {
        test02();
    }

    public static void test02()
    {
        Date endTime = new Date(System.currentTimeMillis() + 1000 * 10);
        long end = endTime.getTime();
        while (true)
        {
            try
            {
                System.out.println(new SimpleDateFormat("mm:ss").format(endTime));
                Thread.sleep(1000);
                endTime = new Date(endTime.getTime() - 1000);
                if (endTime.getTime() == end-10000)
                {
                    break;
                }
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }

    public static void test01()
    {
        int num = 10;
        while (num >= 0)
        {
            try
            {
                Thread.sleep(1000);
                System.out.println(num--);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }
}
