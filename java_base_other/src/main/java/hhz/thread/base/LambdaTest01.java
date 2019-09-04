package hhz.thread.base;

/**
 * @ClassName: LambdaTest01
 * @Description: TODO
 * @author: huanghz
 * @date: 2019/7/5 11:28
 */
public class LambdaTest01
{
    public static void main(String[] args)
    {
        ILike like = new Like();
        like.lambda();

        // lambda
        ILike like1 = ()->{
            System.out.println("i like lambda3");
        };
        like1.lambda();
    }
}

interface ILike
{
    void lambda();
}

class Like implements ILike
{

    @Override
    public void lambda()
    {
        System.out.println("i like lambda");
    }
}
