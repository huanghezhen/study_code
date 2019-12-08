package hhz.adapter.type2;

/**
 * @ClassName: Phone
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/12/8 20:45
 */
public class Phone {
    public void charging() {
        Voltage5V v = new VoltageAdapter(new Voltage220V());
        System.out.println(v.output5V());
    }
}
