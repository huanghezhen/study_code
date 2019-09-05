package hhz.demo11;

/**
 * @ClassName: ConcreteDecorator2
 * @Description: TODO(概况)
 * @author: huanghz
 * @date: 2019/9/5 上午 09:54
 */
public class ConcreteDecorator2 extends Decorator
{

    public ConcreteDecorator2(Component component)
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
        System.out.println("功能C");
    }
}
