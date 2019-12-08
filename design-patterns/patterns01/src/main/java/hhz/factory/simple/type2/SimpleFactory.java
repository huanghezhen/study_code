package hhz.factory.simple.type2;

import hhz.factory.simple.type1.CheesePizza;
import hhz.factory.simple.type1.GreekPizza;
import hhz.factory.simple.type1.PepperPizza;
import hhz.factory.simple.type1.Pizza;

public class SimpleFactory {
    public Pizza createPizza(String orderType) {
        Pizza pizza = null;
        switch (orderType) {
            case "greek":
                pizza = new GreekPizza("greek");
                break;
            case "cheese":
                pizza = new CheesePizza("cheese");
                break;
            case "pepper":
                pizza = new PepperPizza("pepper");
                break;
        }
        return pizza;
    }
}
