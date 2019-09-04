package hhz.thread.base;

/**
 * @ClassName: StartThread01
 * @Description: TODO
 * @author: huanghz
 * @date: 2019/7/5 10:08
 */
public class StartThread02 implements Runnable
{
    @Override
    public void run()
    {
        for (int i = 0; i < 10; i++)
        {
            System.out.println("听歌");
        }
    }
    public static void main(String[] args)
    {
        // 1 创建对象
        // 2 创建代理对象并启动
        new Thread(new StartThread02()).start();
        for (int i = 0; i < 50; i++)
        {
            System.out.println("写代码");
        }
    }
}
