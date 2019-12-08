package hhz.adapter.type1;

public class Phone {
    public void charging(Voltage5V v) {
        int i = v.output5V();
        System.out.println(i);
    }
}
