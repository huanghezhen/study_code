package hhz.thread.base;

/**
 * @ClassName: StartThread01
 * @Description: TODO
 * @author: huanghz
 * @date: 2019/7/5 10:08
 */
public class StartThread01 extends Thread
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
        StartThread01 startThread01 = new StartThread01();
        // 2 启动
        startThread01.start();
        //startThread01.run(); 只是普通方法的调用

        for (int i = 0; i < 50; i++)
        {
            System.out.println("写代码");
        }
    }
}
