package hhz.demo11;

/**
 * @ClassName: Decorator
 * @Description: TODO(概况)
 * @author: huanghz
 * @date: 2019/9/5 上午 09:52
 */
public class Decorator implements Component
{
    private Component component;

    public Decorator(Component component)
    {
        this.component = component;
    }

    @Override
    public void doSomething()
    {
        component.doSomething();
    }
}
