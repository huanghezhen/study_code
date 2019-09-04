package hhz.thread.base;

/**
 * @ClassName: StaticProxy
 * @Description: TODO
 * @author: huanghz
 * @date: 2019/7/5 11:07
 */
public class StaticProxy
{
    public static void main(String[] args)
    {
        new WeddingCompany(new You()).happyMarry();
    }
}

interface Marry
{
    void happyMarry();
}

class You implements Marry
{

    @Override
    public void happyMarry()
    {
        System.out.println("超级开心，结婚了");
    }
}

class WeddingCompany implements Marry
{
    private You you;

    public WeddingCompany(You you)
    {
        this.you = you;
    }

    @Override
    public void happyMarry()
    {
        System.out.println("唱歌");
        you.happyMarry();
        System.out.println("跳舞");
    }
}