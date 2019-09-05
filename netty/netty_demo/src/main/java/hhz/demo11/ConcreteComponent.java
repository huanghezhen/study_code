package hhz.demo11;

/**
 * @ClassName: ConcreteComponent
 * @Description: TODO(概况)
 * @author: huanghz
 * @date: 2019/9/5 上午 09:51
 */
public class ConcreteComponent implements Component
{
    @Override
    public void doSomething()
    {
        System.out.println("功能A");
    }
}
