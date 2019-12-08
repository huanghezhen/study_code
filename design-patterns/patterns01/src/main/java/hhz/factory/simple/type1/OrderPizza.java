package hhz.factory.simple.type1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OrderPizza {
    public OrderPizza() {
        Pizza pizza = null;
        String orderType;

        do {
            orderType = getType();
            if ("greek".equals(orderType)) {
                pizza = new GreekPizza("greek");
            } else if ("cheese".equals(orderType)) {
                pizza = new CheesePizza("cheese");
            } else if ("pepper".equals(orderType)) {
                pizza = new PepperPizza("pepper");
            } else {
                break;
            }

            pizza.prepare();
            pizza.bake();
            pizza.cut();
            pizza.box();
        } while (true);
    }

    private String getType() {
        String str = null;
        try {
            BufferedReader strbr = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("input pizza type");
            str = strbr.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }
}
