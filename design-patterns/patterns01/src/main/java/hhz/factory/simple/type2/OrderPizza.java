package hhz.factory.simple.type2;

import hhz.factory.simple.type1.Pizza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OrderPizza {

    public OrderPizza(SimpleFactory simpleFactory) {
        do {
            String orderType = getType();
            Pizza pizza = simpleFactory.createPizza(orderType);
            if (pizza != null) {
                pizza.prepare();
                pizza.bake();
                pizza.cut();
                pizza.box();
            }else{
                System.out.println("no pizza");
                break;
            }
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
