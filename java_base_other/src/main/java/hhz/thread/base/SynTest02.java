package hhz.thread.base;

/**
 * @ClassName: SynTest02
 * @Description: 取钱
 * @author: huanghz
 * @date: 2019/7/5 15:05
 */
public class SynTest02
{
    public static void main(String[] args)
    {
        Account account = new Account(100, "结婚礼金");
        SafeDrawing you = new SafeDrawing(account, 90, "你");
        SafeDrawing him = new SafeDrawing(account, 80, "他");

        you.start();
        him.start();
    }
}

class SafeDrawing extends Thread
{
    private Account account;
    private int drawingMoney; // 取的钱
    private int drawingAllMoney; // 取的总的钱

    public SafeDrawing(Account account, int drawingMoney,String name)
    {
        super(name);
        this.account = account;
        this.drawingMoney = drawingMoney;
    }

    @Override
    public void run()
    {
        test01();
    }

    // 目标不对锁定失败
    public synchronized void test01()
    {
        if (account.getMoney() - drawingMoney < 0)
        {
            return;
        }
        try
        {
            Thread.sleep(1000);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        account.setMoney(account.getMoney() - drawingMoney);
        drawingAllMoney += drawingMoney;
        System.out.println(this.getName() + "账户余额为" + account.getMoney());
        System.out.println(this.getName() + "一共取了" + drawingAllMoney);
    }
}