package hhz.demo11;

/**
 * @ClassName: ConcreteDecorator1
 * @Description: TODO(概况)
 * @author: huanghz
 * @date: 2019/9/5 上午 09:53
 */
public class ConcreteDecorator1 extends Decorator
{
    public ConcreteDecorator1(Component component)
    {
        super(component);
    }

    @Override
    public void doSomething()
    {
        super.doSomething();
        doOtherThing();
    }

    private void doOtherThing()
    {
        System.out.println("功能B");
    }
}
