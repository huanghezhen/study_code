package hhz.demo11;

/**
 * @ClassName: Client
 * @Description: TODO(概况)
 * @author: huanghz
 * @date: 2019/9/5 上午 09:56
 */
public class Client
{
    public static void main(String[] args)
    {
        Component component = new ConcreteDecorator2(new ConcreteDecorator1(new ConcreteComponent()));

        component.doSomething();
    }
}
