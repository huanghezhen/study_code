package hhz.adapter.type2;

/**
 * @ClassName: VoltageAdapter
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/12/8 20:45
 */
public class VoltageAdapter implements Voltage5V {
    private Voltage220V voltage220V;

    public VoltageAdapter(Voltage220V voltage220V) {
        this.voltage220V = voltage220V;
    }

    @Override
    public int output5V() {
        return voltage220V.output220V()/44;
    }
}
