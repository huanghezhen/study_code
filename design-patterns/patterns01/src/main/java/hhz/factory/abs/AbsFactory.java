package hhz.factory.abs;

import hhz.factory.simple.type1.Pizza;

public interface AbsFactory {
    Pizza createPizza(String orderType);
}
