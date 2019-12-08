package hhz.builder.type2;

public class CommonHouse extends HouseBuilder {
    @Override
    public void basic() {
        System.out.println("普通房子 basic");
    }

    @Override
    public void walls() {
        System.out.println("普通房子 walls");
    }

    @Override
    public void roofed() {
        System.out.println("普通房子 roofed");
    }
}
