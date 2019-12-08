package hhz.adapter.type1;

public class Client {
    public static void main(String[] args) throws Exception {
        Phone phone = new Phone();

        phone.charging(new VoltageAdapter());
    }
}
