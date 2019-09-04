package hhz.io.decorate;

/**
 * @ClassName: DecorateTest02
 * @Description: 模拟咖啡
 * @author: huanghz
 * @date: 2019/7/4 9:34
 * <p>
 * 1 抽象组件：需要装饰的抽象对象
 * 2 具体组件：需要装饰的对象
 * 3 抽象装饰类：包含了对象抽象组件的引用以及装饰着共有的方法
 * 4 具体装饰类：被装饰的对象
 */
public class DecorateTest02
{
    public static void main(String[] args)
    {
        Drink drink = new Coffee();
        Drink milk = new Milk(drink);
        System.out.println(milk.cost());
        System.out.println(milk.info());
    }
}

// 抽象组件
interface Drink
{
    // 费用
    Double cost();

    // 说明
    String info();
}

class Coffee implements Drink
{
    private String name = "原味咖啡";

    @Override
    public Double cost()
    {
        return 20d;
    }

    @Override
    public String info()
    {
        return name;
    }
}

abstract class Decorate implements Drink
{

    private Drink drink;

    public Decorate(Drink drink)
    {
        this.drink = drink;
    }

    @Override
    public Double cost()
    {
        return drink.cost();
    }

    @Override
    public String info()
    {
        return drink.info();
    }
}

class Milk extends Decorate
{

    public Milk(Drink drink)
    {
        super(drink);
    }

    @Override
    public Double cost()
    {
        return super.cost()*4;
    }

    @Override
    public String info()
    {
        return super.info()+"加上牛奶";
    }
}
