package hhz.thread.base;

/**
 * @ClassName: LambdaThread
 * @Description: TODO
 * @author: huanghz
 * @date: 2019/7/5 11:18
 */
public class LambdaThread
{
    // 创建静态内部类
    static class test01 implements Runnable
    {
        @Override
        public void run()
        {
            for (int i = 0; i < 20; i++)
            {
                System.out.println("啦啦啦。。。");
            }
        }
    }

    public static void main(String[] args)
    {
        // 静态内部类启动
        new Thread(new test01()).start();

        // 创建局部内部类
        class test02 implements Runnable
        {
            @Override
            public void run()
            {
                for (int i = 0; i < 20; i++)
                {
                    System.out.println("啦啦啦。。。");
                }
            }
        }
        // 局部内部类启动
        new Thread(new test02()).start();

        // 匿名内部类 必须借助接口或者父类
        new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                for (int i = 0; i < 20; i++)
                {
                    System.out.println("啦啦啦。。。");
                }
            }
        }).start();

        // jdk8 简化 lambda
        new Thread(() -> {
            for (int i = 0; i < 20; i++)
            {
                System.out.println("啦啦啦。。。");
            }
        }).start();
    }
}
