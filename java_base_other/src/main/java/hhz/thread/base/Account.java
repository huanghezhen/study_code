package hhz.thread.base;

/**
 * @ClassName: Account
 * @Description: TODO
 * @author: huanghz
 * @date: 2019/7/5 16:08
 */
public class Account
{
    private int money;
    private String name;

    public Account(int money, String name)
    {
        this.money = money;
        this.name = name;
    }

    public int getMoney()
    {
        return money;
    }

    public void setMoney(int money)
    {
        this.money = money;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
}
