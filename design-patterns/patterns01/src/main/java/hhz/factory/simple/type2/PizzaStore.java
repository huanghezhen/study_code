package hhz.factory.simple.type2;

public class PizzaStore {
    public static void main(String[] args) throws Exception {
        new OrderPizza(new SimpleFactory());
    }
}
