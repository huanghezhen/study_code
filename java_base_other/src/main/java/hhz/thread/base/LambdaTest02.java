package hhz.thread.base;

/**
 * @ClassName: LambdaTest01
 * @Description: TODO
 * @author: huanghz
 * @date: 2019/7/5 11:28
 */
public class LambdaTest02
{
    public static void main(String[] args)
    {
        ILove love = (a) ->{
            System.out.println(a);
        };
    }
}

interface ILove
{
    void lambda(int a);
}

