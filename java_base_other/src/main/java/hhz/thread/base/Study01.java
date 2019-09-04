package hhz.thread.base;

/**
 * @ClassName: Study01
 * @Description: TODO
 * @author: huanghz
 * @date: 2019/7/5 12:43
 */
public class Study01 implements Runnable
{
    private boolean flag = true;

    @Override
    public void run()
    {
        while (flag)
        {
            System.out.println("hhhh");
        }
    }

    public void stop()
    {
        flag = false;
    }
}
