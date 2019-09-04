package hhz.thread.base;

/**
 * @ClassName: Racer
 * @Description: 龟兔赛跑
 * @author: huanghz
 * @date: 2019/7/5 10:46
 */
public class Racer implements Runnable
{
    private static String winner;
    @Override
    public void run()
    {
        for (int i = 1; i <= 100; i++)
        {
            if ("兔子".equals(Thread.currentThread().getName()))
            {
                try
                {
                    Thread.sleep(1);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + "-->" + i);
            boolean b = gameOver(i);
            if (b)
            {
                break;
            }
        }
    }

    private boolean gameOver(int i)
    {
        if (winner != null)
        {
            return true;
        }else
        {
            if (i == 100)
            {
                winner = Thread.currentThread().getName();
                System.out.println(winner);
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args)
    {
        Racer racer = new Racer();
        new Thread(racer, "兔子").start();
        new Thread(racer, "乌龟").start();


    }
}
